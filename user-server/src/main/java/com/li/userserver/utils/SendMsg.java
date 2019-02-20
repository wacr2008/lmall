package com.li.userserver.utils;/**
 * @author lihaodong
 * @create 2018-12-01 14:46
 * @desc
 **/

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaodong
 * @create 2018-12-01 14:46
 * @mail lihaodongmail@163.com
 * @desc
 **/
@Slf4j
public class SendMsg {

    static final String ACCOUNT_SID = "2be56dd4aa6e4564b9690abb2d0a3f89";//这里填写你在平台里的ACOUNT_SID
    static final String AUTH_TOKEN = "cc8f4a3bf3664665ade85818fa3b2516";//这里填写你在平台里的AUTH_TOKEN
    static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//请求地址是固定的不用改
    static int randNum = (int) ((Math.random() * 9 + 1) * 100000);//随机数
    //短信模板
    static String smsContent = "【小东科技】您的验证码为" + randNum + "，请于" + 2 + "分钟内正确输入，如非本人操作，请忽略此短信。";

    /**
     * 测试短信发送（平台：秒嘀科技）
     *
     * @param to 接收信息手机号
     * @return
     */
    public static Map<String, Object> sendSMSG(String to) {

        Map<String, Object> resMap = new HashMap<>();

        //设置时间戳
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String timeStamp = format.format(date);

        //各个数据经过MD5加密之后返回sig
        String sig = MD5(ACCOUNT_SID, AUTH_TOKEN, timeStamp);

        // 组装参数
        NetUtils netUtils = NetUtils.getInstance();
        Map<String, String> map = new HashMap<>();
        map.put("accountSid", ACCOUNT_SID);
        map.put("smsContent", smsContent);
        map.put("to", to);
        map.put("timestamp", timeStamp);
        map.put("sig", sig);
        String res = netUtils.postDataSynToNet(BASE_URL, map);
        JSONObject jsonObject = JSONObject.parseObject(res);
        System.out.println(jsonObject);
        resMap.put("respCode",jsonObject.get("respCode"));
        resMap.put("securityCode",randNum);
        return resMap;
    }


    //MD5算法
    //动态参数
    public static String MD5(String... args) {
        StringBuffer result = new StringBuffer();
        if (args == null || args.length == 0) {
            return "";
        } else {
            StringBuffer str = new StringBuffer();
            for (String string : args) {
                str.append(string);
            }
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] bytes = digest.digest(str.toString().getBytes());
                for (byte b : bytes) {
                    String hex = Integer.toHexString(b & 0xff);  //转化十六进制
                    if (hex.length() == 1) {
                        result.append("0" + hex);
                    } else {
                        result.append(hex);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

}
