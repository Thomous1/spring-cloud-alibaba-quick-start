package org.wangxiaolang.serviceprovider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wangxiaolang.serviceprovider.entity.UsersDO;
import org.wangxiaolang.serviceprovider.mapper.UsersDOMapper;
import org.wangxiaolang.serviceprovider.service.UsersService;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月04日 18:14
 **/

@Service
public class UsersServiceImpl extends ServiceImpl<UsersDOMapper, UsersDO> implements UsersService {

}