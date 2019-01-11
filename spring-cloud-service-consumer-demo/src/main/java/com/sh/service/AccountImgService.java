package com.sh.service;

import com.sh.config.FeignConfiguration;
import com.sh.config.MultipartSupportConfig;
import com.sh.model.Account;
import com.sh.model.AccountChgLog;
import com.sh.model.AccountImg;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 14:43 2018/12/7
 */
@FeignClient(value = "faAccountData",  configuration = {MultipartSupportConfig.class}, path = "/accountImg")
//@Qualifier("accountImgService")
public interface AccountImgService {

/*
    @RequestLine("GET /account/img/get/{userName}?demo={demo}")
    Map<String,Object> get(@Param("userName")String  userName, @Param("demo") String demo);

    @RequestLine("GET /account/img/status?userName={userName}")
    Integer getStatusByUserName(@Param("userName")String  userName);


 /*   @RequestMapping(value = "/accountImg/file1-file2-accountImgInfo", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    boolean insert(@RequestPart("file1") MultipartFile file1,@RequestPart("file2") MultipartFile file2);*/


    @RequestLine("POST /file1-file2-accountImgInfo")
    boolean insert(@Param("file1") MultipartFile file, @Param("file2") MultipartFile file2, @Param("accountImg") AccountImg accountImg);

    @RequestLine("GET /getImg1?userName={userName}")
    Response getImg1(@Param("userName") String userName);

    @RequestLine("POST /getImg2?userName={userName}")
    Response getImg2(@Param("userName") String userName, @Param("accountImg")AccountImg accountImg, @Param("accountChgLog")AccountChgLog accountChgLog);

    @RequestLine("GET /status?userName={userName}")
    Integer getStatusByUserName(@Param("userName") String  userName);

    @RequestLine("GET /fileName1-fileName2-hhtStatus?userName={userName}")
    AccountImg queryAccountImageByName(@Param("userName") String  userName);

    @RequestLine("PUT /status?userName={userName}&status={status}")
    void updateStatus(@Param("userName") String userName, @Param("status") int status);

    @RequestLine("PUT /hhtFileName1-hhtFileName2-hhtStatus")
    void updateHhtFilenameAndHhtStatus(@RequestBody AccountImg accountImg);

    }
