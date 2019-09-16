package com.bdqn.appinfosb.service;

import com.bdqn.appinfosb.exception.BusinessException;
import com.bdqn.appinfosb.pojo.DevUser;

/**
 * ClassName: IDevUser
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/16 21:51
 */
public interface IDevUserService {

    /**
     * description: TODO 开发者登录
     * create time: 2019/9/16 21:54
     * [devcode, devpassword]
     * @return com.bdqn.appinfosb.pojo.DevUser
     */
    DevUser login(String devcode, String devpassword)  throws BusinessException;
}
