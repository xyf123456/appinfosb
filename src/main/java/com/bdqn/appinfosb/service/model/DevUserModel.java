package com.bdqn.appinfosb.service.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * ClassName: DevUserModel
 * create by:  xyf
 * description: TODO
 * create time: 2019/9/16 22:05
 */
@Data
public class DevUserModel {
    private Long id;

    @NotBlank(message = "用户编码不能为空")
    private String devcode;

    @NotBlank(message = "用户名不能为空")
    private String devname;

    @NotBlank(message = "密码不能为空")
    private String devpassword;

    private String devemail;

    private String devinfo;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;
}
