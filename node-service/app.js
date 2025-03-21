const express = require("express");
const bodyParser = require("body-parser");
const mysql = require("mysql2/promise");
const { NacosNamingClient } = require("nacos"); // 引入 Nacos 客户端库

const app = express();
app.use(bodyParser.json());
const PORT = 3002;

// ====================== 数据库配置 ======================
const pool = mysql.createPool({
  host: "localhost",
  user: "root",
  password: "zjw20040929",
  database: "user_center",
  waitForConnections: true,
  connectionLimit: 10,
});

// ====================== Nacos 客户端配置 ======================
const logger = {
  info: (msg) => console.log(`INFO: ${msg}`),
  error: (msg) => console.error(`ERROR: ${msg}`),
  warn: (msg) => console.warn(`WARN: ${msg}`),
};

const nacosClient = new NacosNamingClient({
  serverList: "localhost:8848", // Nacos 服务器地址
  namespace: "public", // 命名空间（默认是 public）
  username: "nacos", // Nacos 用户名（如果启用了身份验证）
  password: "nacos", // Nacos 密码（如果启用了身份验证）
  logger: logger, // 日志记录器
});

// ====================== 注册服务到 Nacos ======================
async function registerToNacos() {
  try {
    console.log("🚀 正在尝试将服务注册到 Nacos...");

    // 注册服务实例
    await nacosClient.registerInstance("node-service", {
      ip: "localhost", // 若部署在远程，替换为实际 IP（如 192.168.1.100）
      port: PORT, // 与服务启动端口一致
      clusterName: "DEFAULT", // 集群名称
      healthy: true, // 健康状态
      enabled: true, // 是否启用
      ephemeral: true, // 是否为临时实例
    });

    console.log("✅ 服务成功注册到 Nacos");
  } catch (err) {
    console.error("❌ Nacos 注册失败:", err.message);
    if (err.code === "ECONNREFUSED") {
      console.log("--- 可能原因：Nacos 未启动或地址错误！");
    }
    console.error("错误详情：", err); // 打印完整的错误对象
  }
}

// ====================== 业务路由 ======================
// 查所有数据
app.get("/user", async (req, res) => {
  try {
    const [rows] = await pool.query("SELECT * FROM t_user");
    res.json(rows);
  } catch (err) {
    console.error("数据库查询失败:", err);
    res.status(500).json({ error: "Internal Server Error" });
  }
});

// 查单个数据
app.get("/user/:id", async (req, res) => {
  try {
    const [rows] = await pool.query("SELECT * FROM t_user WHERE id = ?", [
      req.params.id,
    ]);
    res.json(rows[0] || {});
  } catch (err) {
    console.error("数据库查询失败:", err);
    res.status(500).json({ error: "Internal Server Error" });
  }
});

// 增
app.post("/user", async (req, res) => {
  try {
    const { mobile, password, user_name, avatar_url } = req.body;
    const create_time = new Date();
    const update_time = new Date();
    const [result] = await pool.query(
      "INSERT INTO t_user (mobile, password, user_name, avatar_url, create_time, update_time) VALUES (?, ?, ?, ?, ?, ?)",
      [mobile, password, user_name, avatar_url, create_time, update_time]
    );
    res.json({ id: result.insertId, ...req.body });
  } catch (err) {
    console.error("数据库插入失败:", err);
    res.status(500).json({ error: "Internal Server Error" });
  }
});

// 删
app.delete("/user/:id", async (req, res) => {
  try {
    await pool.query("DELETE FROM t_user WHERE id = ?", [req.params.id]);
    res.json({ message: "Item deleted" });
  } catch (err) {
    console.error("数据库删除失败:", err);
    res.status(500).json({ error: "Internal Server Error" });
  }
});

// 改
app.put("/user/:id", async (req, res) => {
  try {
    const { mobile, password, user_name, avatar_url } = req.body;
    const update_time = new Date();
    await pool.query(
      "UPDATE t_user SET mobile = ?, password = ?, user_name = ?, avatar_url = ?, update_time = ? WHERE id = ?",
      [mobile, password, user_name, avatar_url, update_time, req.params.id]
    );
    res.json({ id: req.params.id, ...req.body });
  } catch (err) {
    console.error("数据库更新失败:", err);
    res.status(500).json({ error: "Internal Server Error" });
  }
});

// ====================== 启动服务并注册 ======================
app.listen(PORT, async () => {
  console.log(`🚀 Node.js 服务运行在 http://localhost:${PORT}`);
  await registerToNacos(); // 服务启动后立即注册到 Nacos
});
