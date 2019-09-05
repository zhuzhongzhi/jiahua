package com.xgit.iot.infra.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class VerifyCodeUtils {


    /**
     * 生成4位验证码
     * @return
     */
    public static String createCode() {
        String[] verificationCodeArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuffer verificationCode = new StringBuffer();
        Random random = new Random();
        for (int i=0; i<4; i++) {
            verificationCode.append(verificationCodeArray[random.nextInt(verificationCodeArray.length)]);
        }
        return verificationCode.toString();
    }


}
