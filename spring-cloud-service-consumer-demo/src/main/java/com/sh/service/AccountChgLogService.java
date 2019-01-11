package com.sh.service;

import com.sh.config.FeignConfiguration;
import com.sh.model.AccountChgLog;
import com.sh.model.AccountChgTypeEnum;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 11:20 2018/12/20
 */
@FeignClient(value = "faAccountData",  configuration = {FeignConfiguration.class}, path = "/account/chgLogs")

public interface AccountChgLogService {

    @RequestLine("GET /longType-userName-partnerId-status?logType={logType}&userName={userName}&partnerId={partnerId}&status={status}")
    List<AccountChgLog> queryAccountChgLogByTypeAndFirmId(@Param("logType")AccountChgTypeEnum logType, @Param("userName") String userName,
            @Param("partnerId") String partnerId, @Param("status") List<Integer> status);

}
