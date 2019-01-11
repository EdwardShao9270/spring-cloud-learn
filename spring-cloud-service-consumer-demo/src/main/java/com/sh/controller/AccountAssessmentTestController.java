package com.sh.controller;

import com.google.common.collect.Maps;
import com.sh.model.Account;
import com.sh.service.AssessmentTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 11:37 2018/12/19
 */
@RestController
@RequestMapping("/consumer/assessment")
public class AccountAssessmentTestController {

    @Autowired
    private AssessmentTest assessmentTest;

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert()  {
        Map<String,Object> result = Maps.newHashMap();
        Account account = new Account();
        account.setUsername("shaohangtest1@126.com");
        account.setPartnerId("hht");
        account.setStatus(1);
        account.setAnswer(65535);
        account.setUserIp("127.0.0.1");

        result.put("result", assessmentTest.insert(account));
        return result;
    }
}
