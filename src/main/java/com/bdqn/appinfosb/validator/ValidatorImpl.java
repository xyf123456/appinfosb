package com.bdqn.appinfosb.validator;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @ Author     ：xyf
 * @ Date       ：Created in 2018/12/23 0023下午 11:30
 * @ Description：TODO 校验实现类(通过校验器，校验每个字段的设置是否合理)
 * @ Modified By：xyf
 * @Version:
 */
@Component
public class ValidatorImpl implements InitializingBean {

    //校验器对象
    private Validator validator;

    @Override
    public void afterPropertiesSet() throws Exception {
        //将Hibernate validator通过工厂化的初始方式使其实例化，得到一个javax的校验器
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * create by: xyf
     * description: 校验每个属性的方法
     * create time: 下午 11:44 2018/12/23 0023
     *
     * @return tt.validator.ValidatorResult
     * @Param: bean
     */
    public ValidatorResult validate(Object bean) {
        //创建ValidatorResult对象
        final ValidatorResult result = new ValidatorResult();
        //通过Validator进行校验bean，得到校验结果，将其存放于ValidatorResult中
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(bean);
        if (constraintViolationSet.size() > 0) {//有错误
            result.setHasErrors(true);
//            jdk的lamd特有的表达式
            constraintViolationSet.forEach(constraintViolation -> {
                //得到错误信息
                String errMsg = constraintViolation.getMessage();
                //详细的知道哪个字段发生了错误
                String propertiesName = constraintViolation.getPropertyPath().toString();
                result.getErorMsgMap().put(propertiesName, errMsg);
            });
        }

        return result;
    }
}
