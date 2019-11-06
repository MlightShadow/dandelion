package com.company.project.configurer;

import com.company.project.core.ResultGenerator;
import com.company.project.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Autowired
    private ResponseUtil responseUtil;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException {
        // 验证为未登陆状态会进入此方法
        System.out.println("未登录访问：" + authException.getMessage());
        responseUtil.responseResult(response, ResultGenerator.genUnAuthorizedResult("无TOKEN访问"));
    }
}
