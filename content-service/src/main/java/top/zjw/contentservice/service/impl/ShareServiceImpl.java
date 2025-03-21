package top.zjw.contentservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.zjw.contentservice.model.entity.Share;
import top.zjw.contentservice.mapper.ShareMapper;
import top.zjw.contentservice.service.ShareService;

@Service
@AllArgsConstructor
public class ShareServiceImpl extends ServiceImpl<ShareMapper, Share> implements ShareService {

    private final ShareMapper shareMapper;
    @Override
    public Share getShareById(Integer id) {
        return shareMapper.selectById(id);
    }
}
