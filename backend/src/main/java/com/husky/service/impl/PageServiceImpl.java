package com.husky.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husky.entity.Page;
import com.husky.mapper.PageMapper;
import com.husky.service.PageService;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/16
 * Time: 10:58
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {
}
