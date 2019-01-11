package com.sh.controller;

import com.google.common.collect.Maps;
import com.netflix.ribbon.Ribbon;
import com.sh.config.FeignSpringFormEncoder;
import com.sh.model.AccountChgLog;
import com.sh.model.AccountImg;
import com.sh.service.AccountImgService;
import com.sh.service.AccountImgTest;
import com.sh.service.HystrixFactory;
import feign.Feign;
import feign.Param;

import feign.Response;
import feign.codec.Decoder;
import feign.hystrix.HystrixFeign;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: bjshaohang
 * @Description:
 * @Date: Created in 14:42 2018/12/7
 */
@RestController
@RequestMapping("/consumer")
public class TestController {

    @Autowired
    AccountImgService accountImgService;

    @Autowired
    AccountImgTest accountImgTest;

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> test(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> resultMap = Maps.newHashMap();

        AccountImg accountImg = new AccountImg();
        accountImg.setUserName(userName);
        accountImg.setStatus(3);
        accountImg.setFileType("C");
        byte[] image = getBytes("E:\\log\\111.jpg");

        byte[] image2 = getBytes("E:\\log\\222.jpg");
        MockMultipartFile file1 = new MockMultipartFile("file1", "111.jpg", null, image);

        MockMultipartFile file2 = new MockMultipartFile("file2", "222.jpg", null, image2);

/*        AccountImgService accountImgService = HystrixFeign.builder().client(RibbonClient.create())
                .decoder(new JacksonDecoder())
                .encoder(new FeignSpringFormEncoder()).target(AccountImgService.class, "http://fa-account-api", (file, file2, accountImg1) -> false);*/
        accountImgService.insert(file1,file2,accountImg);
        resultMap.put("data",accountImg);
        return resultMap;
    }

    @RequestMapping("/getImg1")
    @ResponseBody
    public Map<String,Object> getImg1(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> result = Maps.newHashMap();

/*        AccountImgService accountImgService = Feign.builder().client(RibbonClient.create())
                .decoder(new Decoder.Default())
                .encoder(new JacksonEncoder()).target(AccountImgService.class, "http://fa-account-api");*/


        Response response = accountImgService.getImg1(userName);



        FileOutputStream ops1 = new FileOutputStream(new File("E://log//6666.jpg"));

        InputStream in = response.body().asInputStream();


        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = in.read(buffer)) >= 0){
            ops1.write(buffer,0,length);
        }
        ops1.close();
        result.put("result","ok");
        return result;
    }

    @RequestMapping("/getImg2")
    @ResponseBody
    public Map<String,Object> getImg2(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> result = Maps.newHashMap();
        AccountImg accountImg = new AccountImg();
        accountImg.setUserName(userName);
        accountImg.setStatus(3);
        accountImg.setFileType("C");

        AccountChgLog accountChgLog = new AccountChgLog();
        accountChgLog.setFirmId("111111111111111111");

        Response response = accountImgService.getImg2(userName,accountImg,accountChgLog);

        FileOutputStream ops1 = new FileOutputStream(new File("E://log//7777.jpg"));

        InputStream in = response.body().asInputStream();


        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = in.read(buffer)) >= 0){
            ops1.write(buffer,0,length);
        }
        ops1.close();
        result.put("result","ok");
        return result;
    }


    @RequestMapping("/status")
    @ResponseBody
    public Map<String,Object> statusTest(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> result = Maps.newHashMap();

        System.out.println(accountImgService.getStatusByUserName(userName));

        result.put("result",accountImgService.getStatusByUserName(userName));
        return result;
    }

    @RequestMapping("/fileName1-fileName2-hhtStatus")
    @ResponseBody
    public Map<String,Object> queryAccountImageByName(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> result = Maps.newHashMap();

        System.out.println(accountImgService.queryAccountImageByName(userName));

        result.put("result",accountImgService.queryAccountImageByName(userName));
        return result;
    }


    @GetMapping("/put/status")
    @ResponseBody
    public Map<String,Object> updateStatus(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> result = Maps.newHashMap();

        accountImgService.updateStatus(userName,10);

        result.put("result",accountImgService.getStatusByUserName(userName));
        return result;
    }

    @GetMapping("/put/fileName1-fileName2-hhtStatus")
    @ResponseBody
    public Map<String,Object> updateHhtFilenameAndHhtStatus(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> result = Maps.newHashMap();
        AccountImg accountImg = new AccountImg();
        accountImg.setUserName(userName);
        accountImg.setHhtFileName1("test1.jpg");
        accountImg.setHhtFilename2("test2.jpg");
        accountImg.setHhtStatus(88);
        accountImgService.updateHhtFilenameAndHhtStatus(accountImg);

        result.put("result",accountImgService.queryAccountImageByName(userName));
        return result;
    }


    public static byte[] getBytes(String filePath){
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
