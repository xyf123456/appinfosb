package com.bdqn.appinfosb.service.impl;

import com.bdqn.appinfosb.dao.DevUserMapper;
import com.bdqn.appinfosb.exception.BusinessException;
import com.bdqn.appinfosb.exception.EnumBusinessError;
import com.bdqn.appinfosb.pojo.DevUser;
import com.bdqn.appinfosb.service.IDevUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: DevUserService
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/16 21:51
 */
@Service
public class DevUserService implements IDevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    /**
     * description: TODO 开发者登录
     * create time: 2019/9/16 21:54
     * [devcode, devpassword]
     *
     * @param devcode
     * @param devpassword
     * @return com.bdqn.appinfosb.pojo.DevUser
     */
    @Override
    public DevUser login(String devcode, String devpassword) throws BusinessException {
        DevUser devUser = devUserMapper.selectByDevCode(devcode);
        if (devUser == null) {
            throw new BusinessException(EnumBusinessError.USER_CODEORPASSWORD);
        }
        //比对用户信息内加密的密码是否和传输进来的密钥相匹配
        if (!StringUtils.equals(devpassword, devUser.getDevpassword())) {
            throw new BusinessException(EnumBusinessError.USER_CODEORPASSWORD);
        }
        return devUser;
    }
}
