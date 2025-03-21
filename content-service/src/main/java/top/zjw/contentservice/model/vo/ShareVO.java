package top.zjw.contentservice.model.vo;

import lombok.Data;
import top.zjw.contentservice.model.dto.UserDTO;
import top.zjw.contentservice.model.entity.Share;

@Data
public class ShareVO {
    private Share share;
    private UserDTO user;
}
