package com.llxk.xkapiinterface.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.llxk.xkapiinterface.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.llxk.xkapiinterface.utils.SignUtils.getSign;

/**
 * ClassName: XkApiClient
 * Package: com.llxk.xkapiinterface.client
 *
 * @author 庐陵小康
 * @version 1.0
 * @Desc 调用第三方接口的客户端
 * @Date 2023/8/24 22:01
 */
public class XkApiClient {
    private String accessKey;
    private String secretKey;

    public XkApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }
    public String getNameByPost(String name){
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body){
        Map<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        //一定不能直接发送
//        map.put("secretKey", secretKey);
        map.put("nonce", RandomUtil.randomNumbers(4));
        map.put("body", body);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", getSign(body, secretKey));
        return map;
    }



    public String getNameByPost(User user){
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }


}
