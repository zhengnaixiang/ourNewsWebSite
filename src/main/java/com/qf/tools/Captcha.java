package com.qf.tools;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class Captcha {

    @Autowired
    private Producer producer;

    @RequestMapping( value = "/tryCaptcha.jpg")
    public void testCaptcha(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();

        String lastCode = (String)session.getAttribute("yzm");
//        System.out.println("存在上一次验证码记录："+lastCode);

        // 浏览器关闭缓存
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String newCode = producer.createText();
//        System.out.println("本次验证码："+newCode);

        session.setAttribute("yzm",newCode);
        BufferedImage image = producer.createImage(newCode);
        ServletOutputStream out;
        try {

            out = response.getOutputStream();
            ImageIO.write(image,"jpg",out);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
