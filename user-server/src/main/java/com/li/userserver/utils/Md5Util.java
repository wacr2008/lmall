package com.li.userserver.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密
 * @author WilsonSong
 * @date 2018/8/2/002
 */
public class Md5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     * @Author lihaodong
     * @Description 固定的salt
     * @Date 09:34 2019/1/21
     * @Param
     * @return
     **/
    private static final String SALT = "1a2b3c4d";

    public static String inputPass2FromPass(String inputPass) {
        String str = ""+ SALT.charAt(0)+ SALT.charAt(2) + inputPass + SALT.charAt(5) + SALT.charAt(4);
        return md5(str);
    }

    public static String fromPass2DBPass(String fromPass, String salt) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + fromPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * @Author lihaodong
     * @Description 两次MD5将用户密码存入数据库
     * @Date 09:34 2019/1/21
     * @Param [inputPass, saltDB]
     * @return java.lang.String
     **/
    public static String inputPass2DBPass(String inputPass){
        String fromPass = inputPass2FromPass(inputPass);
        return fromPass2DBPass(fromPass,SALT);
    }

    /**
     * @Author lihaodong
     * @Description 用户输入密码进行校验
     * @Date 10:10 2019/1/21
     * @Param [inputPass, saltDB]
     * @return java.lang.String
     **/
    public static String formPassToDBPass(String inputPass,String saltDB){
        String fromPass = inputPass2FromPass(inputPass);
        return fromPass2DBPass(fromPass,saltDB);
    }


    public static void main(String[] args){

        System.out.println(inputPass2FromPass("123456"));
        System.out.println(fromPass2DBPass("123456", SALT));
        System.out.println(Md5Util.fromPass2DBPass("Chen100?!","1a2b3c4d"));
        System.out.println(inputPass2DBPass("123456"));
        System.out.println(formPassToDBPass("123456","1a2b3c4d"));
    }
}
