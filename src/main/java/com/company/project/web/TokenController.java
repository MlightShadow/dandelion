package com.company.project.web;

import java.util.List;

import javax.annotation.Resource;

import com.company.project.aop.NeedApiLog;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dto.AuthorizedInfo;
import com.company.project.dto.LoginDTO;
import com.company.project.dto.account.AccountDTO;
import com.company.project.model.Account;
import com.company.project.service.AccountService;
import com.company.project.util.JWTUtil;
import com.company.project.util.MD5Util;
import com.company.project.util.SecurityContextUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import tk.mybatis.mapper.entity.Condition;

/**
 * 账号认证控制器
 */
@Api(description = "登录管理")
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private SecurityContextUtil securityContextUtil;

    @Autowired
    private MD5Util MD5;

    @Autowired
    private JWTUtil jwtUtil;

    @Resource
    private AccountService accountService;

    @NeedApiLog
    @PostMapping("/take")
    public Result<?> take(@RequestBody LoginDTO loginInfo) {
        Condition condition = new Condition(Account.class);

        condition.createCriteria().andCondition("name=", loginInfo.getName()).andCondition("password=",
                MD5.md5(loginInfo.getPassword()));

        List<Account> list = accountService.findByCondition(condition);
        Account account = new Account();
        if (list.size() == 1) {
            account = list.get(0);

            AuthorizedInfo authInfo = new AuthorizedInfo(account.getId(), account.getName(), account.getPassword());
            String token = jwtUtil.generateAccessToken(authInfo);
            jwtUtil.putToken(account.getId(), token);
            return ResultGenerator.genSuccessResult(token);

        } else {
            return ResultGenerator.genFailResult("登录失败");
        }

    }

    @GetMapping("/whoami")
    public Result<?> whoami() {
        AccountDTO info = new AccountDTO();
        Account account = accountService.findById(securityContextUtil.getAuthInfo().getId());

        info.setName(account.getName());
        info.setAvatar(account.getAvatar());
        info.setNickName(account.getNickName());

        return ResultGenerator.genSuccessResult(info);
    }
}
