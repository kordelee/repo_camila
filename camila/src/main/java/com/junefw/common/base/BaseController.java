package com.junefw.common.base;

import java.awt.Font;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junefw.common.constants.Constants;
import com.junefw.common.util.UtilDateTime;

import io.springboot.captcha.SpecCaptcha;
import io.springboot.captcha.base.Captcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BaseController {

	public String todayDateString () {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Calendar today = Calendar.getInstance();
		String todayString = formatDate.format(today);	
		return todayString;
	}
	
	
	public String base64Decoder (String str) {
		String decodedString = null;
		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes = decoder.decode(str);
		try {
			decodedString = new String(decodedBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decodedString;
	}
	
	
	public String base64Encoder (String str) {
		String encodedString = null;
		byte[] targetBytes = str.getBytes(); 
		Encoder encoder = Base64.getEncoder(); 
		byte[] encodedBytes = encoder.encode(targetBytes);
		try {
			encodedString = new String(encodedBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encodedString;
	}
	
	
	public static String getClientIp(HttpServletRequest request) {
        String ip = null;
        ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("X-Real-IP"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("X-RealIP"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        }
		return ip;
	}
	
	
	public static int getRandomNumberInt(){
		Random rand = new Random();
		String rst = Integer.toString(rand.nextInt(8) + 1);
		for(int i=0; i < 7; i++){
			rst += Integer.toString(rand.nextInt(9));
		}
		return Integer.parseInt(rst);
	}
	
	
	public static String getRandomNumberStr(){
		Random rand = new Random();
		String rst = Integer.toString(rand.nextInt(8) + 1);
		for(int i=0; i < 7; i++){
			rst += Integer.toString(rand.nextInt(9));
		}
		return rst;
	}
	
	
	public void setSearch(BaseVo vo) throws Exception {
		/* 최초 화면 로딩시에 세팅은 문제가 없지만 */
		/*이후 전체적으로 데이터를 조회를 하려면 null 값이 넘어 오는 관계로 문제가 전체 데이터 조회가 되지 못한다.*/
		/*해서 BaseVo.java 에서 기본값을 주어서 처리*/
//		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
//		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		
		/* 초기값 세팅이 있는 경우 사용 */
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayReplace00TimeString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
		
//		/* 초기값 세팅이 없는 경우 사용 */
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		
	}		
	
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}	
	
	
	@RequestMapping(value = "easyCaptchaCreateImageUsrProc")
	public void easyCaptchaCreateImageUsrProc(HttpServletResponse response,HttpSession session) throws IOException {
	    response.setContentType("image/gif");
	    response.setHeader("Pragma", "No-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
	    SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
	    specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));
	    specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
	    session.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_USR); // 60second * 30 = 30minute
	    session.setAttribute(Constants.SESSION_LOGIN_CAPTCHA_USR, specCaptcha.text().toLowerCase());
	    specCaptcha.out(response.getOutputStream());
	}
	
	
	@ResponseBody
	@RequestMapping(value = "easyCaptchaVerificationUsrProc")
	public Map<String, Object> easyCaptchaVerificationUsrProc(@RequestParam("captchaCode") String captchaCode,HttpSession session) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// EasyCaptcha 검증
		if (captchaCode.equals(session.getAttribute(Constants.SESSION_LOGIN_CAPTCHA_USR).toString())) {
        	returnMap.put("rt", "success");
        	System.out.println(session.getAttribute("captcha"));
        	session.removeAttribute(Constants.SESSION_LOGIN_CAPTCHA_USR);
//        	session.invalidate();
        } else {
        	returnMap.put("rt", "fail");
        }
		return returnMap;
	}
	

//	public void simpleMailSender(String from, String to, String title, String contents) {
//		try {
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
//
//			messageHelper.setFrom(from);
//			messageHelper.setTo(to);
//			messageHelper.setSubject(title);
////			messageHelper.setText(contents);
//			messageHelper.setText(contents, true);
//
//			mailSender.send(message);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
}
