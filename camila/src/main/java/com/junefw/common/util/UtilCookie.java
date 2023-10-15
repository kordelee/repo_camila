package com.junefw.common.util;

import java.net.URLEncoder;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.junefw.common.constants.Constants;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UtilCookie {
	
	public static Cookie createCookie(String name, String value) throws Exception {
        return new Cookie(name, URLEncoder.encode(value, "utf-8"));
    }
	
    
    public static void createCookie(String name, String value, String domain, String path, int maxAge) throws Exception {
    	HttpServletResponse httpServletResponse = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
    	Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(cookie);
    }
    

    public static String getValueUsr(String name) throws Exception {
    	HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
    	Cookie[] cookies = httpServletRequest.getCookies();
    	
    	String rt = null;
    	
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constants.COOKIE_SEQ_NAME_USR)) {
					rt = cookie.getValue();
				} else {
					//	by pass
				}
			}
		} else {
			//	by pass
		}
    	return rt;
    }

    
    public static String getValueXdm(String name) throws Exception {
    	HttpServletRequest httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
    	Cookie[] cookies = httpServletRequest.getCookies();
    	
    	String rt = null;
    	
    	if (cookies != null) {
    		for (Cookie cookie : cookies) {
    			if (cookie.getName().equals(Constants.COOKIE_SEQ_NAME_XDM)) {
    				rt = cookie.getValue();
    			} else {
    				//	by pass
    			}
    		}
    	} else {
    		//	by pass
    	}
    	return rt;
    }
    

    public static void deleteCookieXdm() throws Exception {
    	HttpServletResponse httpServletResponse = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
       	Cookie cookie = new Cookie(Constants.COOKIE_SEQ_NAME_XDM, null);
       	cookie.setPath("/");
       	cookie.setDomain("");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }
    
    
    public static void deleteCookieUsr() throws Exception {
    	HttpServletResponse httpServletResponse = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getResponse();
       	Cookie cookie = new Cookie(Constants.COOKIE_SEQ_NAME_USR, null);
       	cookie.setPath("/");
       	cookie.setDomain("");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }

}
