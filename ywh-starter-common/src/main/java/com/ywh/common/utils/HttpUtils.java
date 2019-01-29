package com.ywh.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * CreateTime: 2018-12-03 12:42
 * ClassName: HttpUtils
 * Package: com.xiyi.common.utils
 * Describe:
 * http工具类
 *
 * @author YWH
 */
public class HttpUtils {

    /**
     *  请求微信后台地址获取openID  和sessionKey
     * @param appId 小程序主体的id
     * @param appSecret 小程序的密钥
     * @param code 微信前端获取的临时凭证
     * @return
     */
    public static JSONObject wxAuthRestTemplate(String appId, String appSecret, String code){
        //请求微信后台的url地址
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret="
                + appSecret + "&js_code=" + code +"&grant_type=authorization_code";
        //初始化
        URL obj = null;
        StringBuffer buffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        HttpURLConnection conn = null;
        String rsession;
        try {
            //建立连接
            obj = new URL(url);
            conn = (HttpURLConnection) obj.openConnection();
            //默认值GET
            conn.setRequestMethod("GET");
            inputStream = conn.getInputStream();
            //获取请求的数据流
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            JSONObject list = JSONObject.parseObject(buffer.toString());
            return list;
        }catch (IOException ex){
            throw MyExceptionUtil.mxe("获取微信接口失败了！",ex);
        }finally{
            try {
                inputStreamReader.close();
                inputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
