package com.sh.controller;

import com.google.common.collect.Maps;
import com.netflix.ribbon.Ribbon;
import com.sh.config.FeignSpringFormEncoder;
import com.sh.model.AccountImg;
import com.sh.service.AccountImgService;
import com.sh.service.AccountImgTest;
import com.sh.service.HystrixFactory;
import feign.Feign;
import feign.Param;

import feign.Response;
import feign.codec.Decoder;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.RibbonClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/test")
    @ResponseBody
    public Map<String,Object> test(@RequestParam("userName") String userName) throws IOException {
        Map<String,Object> resultMap = Maps.newHashMap();

        AccountImg accountImg = new AccountImg();
        accountImg.setUserName(userName);
        accountImg.setStatus(3);
        accountImg.setFileType("C");
        byte[] image = getBytes("E:\\log\\111.jpg");


        MockMultipartFile file1 = new MockMultipartFile("file1", "111.jpg", null, image);


/*        AccountImgService accountImgService = HystrixFeign.builder().client(RibbonClient.create())
                .decoder(new JacksonDecoder())
                .encoder(new FeignSpringFormEncoder()).target(AccountImgService.class, "http://fa-account-api", (file, file2, accountImg1) -> false);*/
        accountImgService.insert(file1,file1,accountImg);
        resultMap.put("data",accountImg);
        return resultMap;

    }

    @RequestMapping("/byte")
    @ResponseBody
    public Map<String,Object> byteTest(@RequestParam("userName") String userName) throws IOException {

        Map<String,Object> result = Maps.newHashMap();

/*        AccountImgService accountImgService = Feign.builder().client(RibbonClient.create())
                .decoder(new Decoder.Default())
                .encoder(new JacksonEncoder()).target(AccountImgService.class, "http://fa-account-api");*/


        Response response = accountImgService.getImg1(userName);
        FileOutputStream ops1 = new FileOutputStream(new File("E://log//666.jpg"));
        InputStream in = response.body().asInputStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int count = -1;
        while((count = in.read(data,0,1024)) != -1){
            output.write(data, 0, count);
        }
        output.close();

        byte[] resultByte = output.toByteArray();


        byte buffer[] = new byte[1024];
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

        System.out.println(accountImgTest.getStatusByUserName(userName));

        result.put("result","ok");
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
