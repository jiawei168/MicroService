package top.zjw.contentservice.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_share")
public class Share {

    private Integer id;

    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */

    /**
     * 是否删除（0: 未删除, 1: 已删除）
     */
    private Integer isOriginal;

    /**
     * 作者
     */
    private String author;

    /**
     * 图片 URL
     */
    private String cover;

    /**
     * 描述
     */
    private String summary;

    /**
     * 点赞数
     */
    private Integer price;

    /**
     * 下载链接
     */
    private String downloadUrl;

    /**
     * 下载次数
     */
    private Integer buyCount;

    private Integer showFlag;
    /**
     * 审核状态（0: 待审核, 1: 通过, 2: 拒绝）
     */
    private String auditStatus;

    /**
     * 审核备注
     */
    private String reason;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
