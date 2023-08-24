package com.llxk.xkapiinterface;

import com.llxk.xkapiinterface.client.XkApiClient;
import com.llxk.xkapiinterface.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XkapiInterfaceApplicationTests {

    public static void main(String[] args) {
        String accessKey = "llxk";
        String secretKey = "abcdefgh";
        XkApiClient xkApiClient = new XkApiClient(accessKey, secretKey);
        String result1 = xkApiClient.getNameByGet("LLXK");
        String result2 = xkApiClient.getNameByPost("LLXK");
        User user = new User();
        user.setUsername("LLXK");
        String result3 = xkApiClient.getNameByPost(user);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    @Test
    void contextLoads() {
    }

}
