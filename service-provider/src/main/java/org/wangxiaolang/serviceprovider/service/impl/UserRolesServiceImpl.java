package org.wangxiaolang.serviceprovider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.wangxiaolang.serviceprovider.entity.UserRolesDO;
import org.wangxiaolang.serviceprovider.mapper.UserRolesDOMapper;
import org.wangxiaolang.serviceprovider.service.UserRolesService;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月05日 15:40
 **/
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesDOMapper, UserRolesDO> implements UserRolesService {
}