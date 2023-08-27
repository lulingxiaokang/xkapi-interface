package com.llxk.xkapiinterface;

import com.llxk.xkapiclientsdk.client.XkApiClient;
import com.llxk.xkapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class XkapiInterfaceApplicationTests {

//    public static void main(String[] args) {
//        String accessKey = "llxk";
//        String secretKey = "abcdefgh";
//        XkApiClient xkApiClient = new XkApiClient(accessKey, secretKey);
//        String result1 = xkApiClient.getNameByGet("LLXK");
//        String result2 = xkApiClient.getNameByPost("LLXK");
//        User user = new User();
//        user.setUsername("LLXK");
//        String result3 = xkApiClient.getNameByPost(user);
//        System.out.println(result1);
//        System.out.println(result2);
//        System.out.println(result3);
//    }

    @Resource
    private XkApiClient xkApiClient;


    @Test
    void contextLoads() throws UnsupportedEncodingException {
        String result = xkApiClient.getNameByGet("LLXK");
        User user = new User();
        user.setUsername("xk");
        String nameByPost = xkApiClient.getNameByPost(user);
        System.out.println(result);
        System.out.println(nameByPost);

    }

}
