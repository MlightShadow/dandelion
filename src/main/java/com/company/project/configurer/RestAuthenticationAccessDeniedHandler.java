package com.company.project.configurer;

import com.company.project.core.ResultGenerator;
import com.company.project.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("RestAuthenticationAccessDeniedHandler")
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ResponseUtil responseUtil;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e)
            throws IOException, ServletException {
        // 登陆状态下，权限不足执行该方法
        System.out.println("权限不足：" + e.getMessage());
        responseUtil.responseResult(response, ResultGenerator.genForbiddenResult("接口权限异常"));
    }
}
