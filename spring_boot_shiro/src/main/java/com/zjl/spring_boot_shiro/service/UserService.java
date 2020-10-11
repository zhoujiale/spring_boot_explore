package com.zjl.spring_boot_shiro.service;

import com.zjl.spring_boot_shiro.domian.LoginParam;
import com.zjl.spring_boot_shiro.domian.UserParam;
import com.zjl.spring_boot_shiro.domian.UserVO;
import com.zjl.spring_boot_shiro.model.ShiroUserPO;

/**
 * @Auther: zhou
 * @Date: 2020-10-08 10:46
 * @Description:
 */
public interface UserService {

    /**
     * @description 添加用户
     * @author zhou
     * @created  2020/10/8 10:52
     * @param userParam 用户参数
     * @return com.zjl.spring_boot_shiro.model.ShiroUserPO
     **/
    ShiroUserPO addUser(UserParam userParam);

    /** 
     * @description 登录 
     * @author zhou       
     * @created  2020/10/11 18:20
     * @param 
     * @return com.zjl.spring_boot_shiro.domian.UserVO
     **/
    UserVO login(LoginParam loginParam);
}
