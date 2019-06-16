package com.ywh.cloudcommon.utils;//package com.ywh.corecommon.utils;
//
//import com.alibaba.fastjson.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//
///**
// * CreateTime: 2018-12-03 12:42
// * ClassName: HttpUtils
// * Package: com.xiyi.common.utils
// * Describe:
// * http工具类
// *
// * @author YWH
// */
//public class HttpUtils {
//
//    /**
//     *  请求微信后台地址获取openID  和sessionKey
//     * @param appId 小程序主体的id
//     * @param appSecret 小程序的密钥
//     * @param code 微信前端获取的临时凭证
//     * @return 返回微信小程序的认证（忘记返回什么了）
//     */
//    public static JSONObject wxAuthRestTemplate(String appId, String appSecret, String code){
//        //请求微信后台的url地址
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret="
//                + appSecret + "&js_code=" + code +"&grant_type=authorization_code";
//        //初始化
//        URL obj;
//        StringBuilder buffer = new StringBuilder();
//        InputStream inputStream = null;
//        InputStreamReader inputStreamReader = null;
//        BufferedReader bufferedReader = null;
//        HttpURLConnection conn;
//        try {
//            //建立连接
//            obj = new URL(url);
//            conn = (HttpURLConnection) obj.openConnection();
//            //默认值GET
//            conn.setRequestMethod("GET");
//            inputStream = conn.getInputStream();
//            //获取请求的数据流
//            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//            bufferedReader = new BufferedReader(inputStreamReader);
//            String str;
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            return JSONObject.parseObject(buffer.toString());
//        }catch (IOException ex){
//            throw MyExceptionUtil.mxe("获取微信接口失败了！",ex);
//        }finally{
//            try {
//                assert inputStreamReader != null;
//                inputStreamReader.close();
//                inputStream.close();
//                assert bufferedReader != null;
//                bufferedReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
