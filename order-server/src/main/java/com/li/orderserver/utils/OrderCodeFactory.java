package com.li.orderserver.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName OrderCodeFactory
 * @Author lihaodong
 * @Date 2019/2/11 17:32
 * @Mail lihaodongmail@163.com
 * @Description
 * @Version 1.0
 **/

/**
 * 订单编码码生成器，生成32位数字编码，
 * @生成规则 1位单号类型+17位时间戳+14位(用户id加密&随机数)
 * Date:2017年9月8日上午10:05:19
 * @author jiwengjian
 */
public class OrderCodeFactory {

    /** 订单类别头 */
    private static final String ORDER_CODE = "1";
    /** 退货类别头 */
    private static final String RETURN_ORDER = "2";
    /** 退款类别头 */
    private static final String REFUND_ORDER = "3";
    /** 未付款重新支付别头 */
    private static final String AGAIN_ORDER = "4";
    /** 随即编码 */
    private static final int[] R = new int[]{7, 9, 6, 2, 8 , 1, 3, 0, 5, 4};
    /** 用户id和随机数总长度 */
    private static final int MAX_LENGTH = 14;

    /**
     * 更具id进行加密+加随机数组成固定长度编码
     */
    private static String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1 ; i >= 0; i--) {
            idsbs.append(R[idStr.charAt(i)-'0']);
        }
        return idsbs.append(getRandom(MAX_LENGTH - idStr.length())).toString();
    }

    /**
     * 生成时间戳
     */
    private static String getDateTime(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    /**
     * 生成固定长度随机码
     * @param n    长度
     */
    private static long getRandom(long n) {
        long min = 1,max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min ;
        return rangeLong;
    }

    /**
     * 生成不带类别标头的编码
     * @param userId
     */
    private static synchronized String getCode(Long userId){
        userId = userId == null ? 10000 : userId;
        return getDateTime() + toCode(userId);
    }

    /**
     * 生成订单单号编码
     * @param userId
     */
    public static String getOrderCode(Long userId){
        return ORDER_CODE + getCode(userId);
    }

    /**
     * 生成退货单号编码
     * @param userId
     */
    public static String getReturnCode(Long userId){
        return RETURN_ORDER + getCode(userId);
    }

    /**
     * 生成退款单号编码
     * @param userId
     */
    public static String getRefundCode(Long userId){
        return REFUND_ORDER + getCode(userId);
    }

    /**
     * 未付款重新支付
     * @param userId
     */
    public static String getAgainCode(Long userId){
        return AGAIN_ORDER + getCode(userId);
    }

    public static String getOrderIdByUUId() {
        //最大支持1-9个集群机器部署
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        //有可能是负数
        if(hashCodeV < 0) {
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
    public static void main(String[] args) {
        System.out.println(getOrderIdByUUId());
        System.out.println(getOrderIdByUUId());
        System.out.println(getOrderIdByUUId());
        System.out.println(getOrderIdByUUId());
    }

}
