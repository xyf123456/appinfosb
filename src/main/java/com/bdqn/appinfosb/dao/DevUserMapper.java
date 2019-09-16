package com.bdqn.appinfosb.dao;

import com.bdqn.appinfosb.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);

    /**
     * description: TODO 通过devcode查找到用户
     * create time: 2019/9/16 22:44
     * [devcode]
     * @return com.bdqn.appinfosb.pojo.DevUser
     */
    DevUser selectByDevCode(@Param("devcode") String devcode);
}