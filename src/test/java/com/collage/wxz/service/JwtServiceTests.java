package com.collage.wxz.service;

import com.collage.wxz.entity.User;
import com.collage.wxz.util.JwtUtil;
import org.junit.Test;

public class JwtServiceTests {

    @Test
    public void JwtCreateToken() {
        JwtUtil jwt = new JwtUtil();
        User user = new User();
        user.setUsername("wxz");
        user.setNick("wxz");
        user.setUserClassification(1);
        String token = jwt.createToken(user);
        System.out.println(token);
    }
    @Test
    public void JwtPraseToken(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6Ind4eiIsIlVzZXJDbGFzc2lmaWNhdGlvbiI6MSwibmljayI6Ind4eiIsInN1YiI6ImxvZ2luX3Rlc3QiLCJleHAiOjE2NzI5Mjc2OTIsImp0aSI6IjdkY2Y1Zjk2LWI3ODgtNGFhYS05ODY1LWMwMWI0Njk3NGY5MSJ9.AKAo3Cw5ic0lZffBlShY3gFgTlWcG-aPqzuci3HoZtA";
        JwtUtil jwtUtil = new JwtUtil();
        System.out.println(jwtUtil.JWTParse(token));
    }
}
