package com.example.manage_backend.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class TokenUtils {

    public static String genToken(String username, String sign){
        return JWT.create().withAudience(username)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 12))
                .sign(Algorithm.HMAC256(sign));
    }
}
