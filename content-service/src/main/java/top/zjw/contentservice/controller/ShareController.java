package top.zjw.contentservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zjw.contentservice.model.dto.UserDTO;
import top.zjw.contentservice.model.entity.Result;
import top.zjw.contentservice.model.entity.Share;
import top.zjw.contentservice.model.vo.ShareVO;
import top.zjw.contentservice.openfeign.UserService;
import top.zjw.contentservice.service.ShareService;

@Slf4j
@RestController
@RequestMapping("/share")
@AllArgsConstructor
public class ShareController {

    private final ShareService shareService;

    private final UserService userService;

    @GetMapping("/{id}")
//    @SentinelResource(value="/share/{id}")
    public ShareVO getShareById(@PathVariable Integer id) throws InterruptedException {
        Share share = shareService.getShareById(id);
//        Thread.sleep(500);
        System.out.println(share);
        UserDTO user = userService.getUserById(share.getUserId()).getData();
        ShareVO shareVO = new ShareVO();
        shareVO.setShare(share);
        shareVO.setUser(user);

        return shareVO;
    }
}
