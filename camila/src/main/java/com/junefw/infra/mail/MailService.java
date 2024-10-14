package com.junefw.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.junefw.infra.member.MemberDto;
import com.junefw.infra.template.TemplateService;
import com.junefw.infra.template.TemplateVo;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@Autowired
	TemplateService templateService;
	
	private MimeMessage message;
    private MimeMessageHelper helper;
	
//	public void sendMailSimple() {
//    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//    	
//    	simpleMailMessage.setTo("kordelee@naver.com");
//    	simpleMailMessage.setSubject("안녕하세요");
////    	simpleMailMessage.setFrom("wjsgusfhr324@gmail.com");
//    	simpleMailMessage.setText("안녕하세요\n\n 잘지내고 계시죠");
//    	javaMailSender.send(simpleMailMessage);
//    }

//
//	파일을 전송 s
//	
	
//    public void sendMailAuthorizationPwd() {
//    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//    	int randomKey = (int)(Math.random() * 899999) + 100000;
//    	String authoKey = String.valueOf(randomKey);
////    	simpleMailMessage.setTo("kordelee@naver.com");
//    	simpleMailMessage.setTo("relationrok@gmail.com");
//    	simpleMailMessage.setSubject("이메일 인증");
////    	simpleMailMessage.setFrom("relationrok@gmail.com"); 
//    	simpleMailMessage.setText(authoKey);
//    	javaMailSender.send(simpleMailMessage);
//    	
//    }
//    

    public void sendEmailTemplate(MemberDto dto, TemplateVo tvo) throws Exception{
    	int randomKey = (int)(Math.random() * 899999) + 100000;
    	String authoKey = String.valueOf(randomKey);
        Context context = new Context();
//        데이터 뭐 넘겨줄지 설정
        context.setVariable("randomNum", authoKey);
//        템플릿 시퀀스 설정
        tvo.setIftpSeq("4");
        
        String contentsHtml = templateService.selectOne(tvo).getIftpContents();

        // html에서 인증번호라는 곳에 authokey를 넣는다
        String template = contentsHtml.replace("인증번호", authoKey);
        
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        mimeMessageHelper.setTo(dto.getIfmeEmailFull()); // 메일 수신자
        mimeMessageHelper.setSubject("test"); // 메일 제목
        mimeMessageHelper.setText(template, true); // 메일 본문 내용, HTML 여부
        javaMailSender.send(mimeMessage);

    }
    
    
//    public void sendEmailTemplate(MemberDto dto,TemplateVo tvo) throws Exception{
//    	int randomKey = (int)(Math.random() * 899999) + 100000;
//    	String authoKey = String.valueOf(randomKey);
//        Context context = new Context();
//        tvo.setIftpSeq("4");
////        데이터 뭐 넘겨줄지 설정
//        context.setVariable("randomNum", authoKey);
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
//        mimeMessageHelper.setTo(dto.getIfmeEmailFull()); // 메일 수신자
//        mimeMessageHelper.setSubject("test"); // 메일 제목
//        mimeMessageHelper.setText(templateService.selectOne(tvo).getIftpContents(), true); // 메일 본문 내용, HTML 여부
//        javaMailSender.send(mimeMessage);
//
//    }
	
//
//	파일을 전송 e
//	

//	public void templateMailSend(MemberDto dto) throws Exception {
//		helper = new MimeMessageHelper(message, true, "UTF-8");
//		helper.setTo(dto.getIfmeEmailFull());
//		helper.setSubject("emailTest");
//		helper.sette
//	}
	
    
    public String randomNumber() {
    	int randomKey = (int)(Math.random() * 899999) + 100000;
    	String authoKey = String.valueOf(randomKey);
    	Context context = new Context();
    	context.setVariable("randomNum", authoKey);
    	return authoKey;
    }
}
