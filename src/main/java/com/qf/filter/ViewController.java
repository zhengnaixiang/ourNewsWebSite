package com.qf.filter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * Author:  winggon
 * Date:    2019/5/11
 * Time:    22:31
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public ModelAndView GoIndex(){
        return new ModelAndView("/index");
    }

}
