package com.nfs.bank_co.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.Cookie;

public class AuthenticationUtility {

    public static String getCookieByName(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName))
                    return cookie.getValue();
            }
        }
        return null;
    }

    public static String createToken() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret"); // TODO Modifier le secret
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean checkTokenValidity(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret"); // TODO Modifier le secret
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            System.out.println(jwt.getToken());
            return true;
        } catch (JWTVerificationException e) {
            System.out.println(e);
            return false;
        }
    }
}
