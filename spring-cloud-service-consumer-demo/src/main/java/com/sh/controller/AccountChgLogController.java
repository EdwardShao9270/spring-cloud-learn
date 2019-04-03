package com.sh.controller;

import com.google.common.collect.Maps;
import com.sh.model.Account;
import com.sh.model.AccountChgTypeEnum;
import com.sh.service.AccountChgLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 11:20 2018/12/20
 */
@RestController
@RequestMapping("/consumer/chgLog")
public class AccountChgLogController {
    @Autowired
    private AccountChgLogService accountChgLogService;

    @RequestMapping("/get")
    @ResponseBody
    public Map<String,Object> insert()  {
        Map<String,Object> result = Maps.newHashMap();
        System.out.println("test");
        result.put("result", accountChgLogService.queryAccountChgLogByTypeAndFirmId(AccountChgTypeEnum.QUICK_SING_AND_IN,"linyuchenp007@163.com","hht",null));
        return result;
    }

}
