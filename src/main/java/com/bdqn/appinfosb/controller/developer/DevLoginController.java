package com.bdqn.appinfosb.controller.developer;

import com.bdqn.appinfosb.exception.BusinessException;
import com.bdqn.appinfosb.exception.CommonReturnType;
import com.bdqn.appinfosb.exception.EnumBusinessError;
import com.bdqn.appinfosb.pojo.DevUser;
import com.bdqn.appinfosb.service.IDevUserService;
import com.bdqn.appinfosb.utils.constant.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: DevLoginController
 * create by:  xyf
 * description: TODO 开发者登录相关的控制器
 * create time: 2019/9/16 21:34
 */
@Controller
@RequestMapping(value = "/dev")
public class DevLoginController {

    private Logger logger = Logger.getLogger(DevLoginController.class);

    @Autowired
    private IDevUserService iDevUserService;

    /**
     * description: TODO 跳转到开发者登录页面
     * create time: 2019/9/16 21:48
     * []
     *
     * @return java.lang.String
     */
    @GetMapping(value = "/login")
    public String login() {

        logger.debug("LoginController welcome AppInfoSystem backend==================");
        return "dev/devlogin";
    }

    /**
     * description: TODO 处理开发者的登录
     * create time: 2019/9/16 21:50
     * [devcode, devpassword, request, session]
     *
     * @return java.lang.String
     */
    @PostMapping(value = "/doLogin")
    @ResponseBody
    public CommonReturnType doLogin(@RequestParam String devcode,
                                    @RequestParam String devpassword,
                                    HttpServletRequest request) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //        1、入参校验
        if (StringUtils.isEmpty(devcode)
                || StringUtils.isEmpty(devpassword)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        DevUser user = iDevUserService.login(devcode, devpassword);
        request.getSession().setAttribute(Constants.USERSESSION, user);
        //页面跳转（main.jsp）
//            return "redirect:/dev/flatform/main";
        return CommonReturnType.create(user);
    }

    @RequestMapping(value = "/flatform/main")
    public String main(HttpSession session) {
        if (session.getAttribute(Constants.USERSESSION) == null) {
            return Constants.REDIRECT + "dev/login";
        }
        return "dev/main";
    }

}
