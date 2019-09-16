package com.bdqn.appinfosb.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：xyf
 * @ Date       ：Created in 2018/12/23 0023下午 11:23
 * @ Description：TODO 校验结果类
 * @ Modified By：xyf
 * @Version:
 */
public class ValidatorResult {

    //检验结果是否有错
    private boolean hasErrors;

    //存放错误信息的map
    private Map<String, String> erorMsgMap = new HashMap<>();

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErorMsgMap() {
        return erorMsgMap;
    }

    public void setErorMsgMap(Map<String, String> erorMsgMap) {
        this.erorMsgMap = erorMsgMap;
    }

    /**
     * create by: xyf
     * description: 实现通用的通过格式化字符串信息获取错误结果的msg方法(多条的话，通过","串联起来)
     * create time: 下午 11:27 2018/12/23 0023
     *
     * @return java.lang.String
     * @Param:
     */
    public String getErrMsg() {
        return StringUtils.join(erorMsgMap.values().toArray(), ",");
    }
}
