package com.qf.personalInformation.tools;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidatorCheck {
    public static void checkParameter(BindingResult errors){

        // 后台校验 - Hibernate Validator插件
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            StringBuilder sb = new StringBuilder();
            //String desc = "";
            for (ObjectError error : errorList) {
                FieldError fieldError = (FieldError) error;
                //desc = fieldError.getDefaultMessage();
                sb.append(fieldError.getDefaultMessage() + "|");
            }
            throw new RuntimeException(sb.toString());
        }
    }
}
