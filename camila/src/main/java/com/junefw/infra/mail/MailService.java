package com.junefw.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import com.junefw.infra.member.MemberDao;
import com.junefw.infra.member.MemberDto;
import com.junefw.infra.template.TemplateDto;
import com.junefw.infra.template.TemplateService;
import com.junefw.infra.template.TemplateVo;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	TemplateService templateService;
	
	@Autowired
	MemberDao memberDao;
	
//	public void sendMailSimple() {
//    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//    	
//    	simpleMailMessage.setTo("kordelee@naver.com");
//    	simpleMailMessage.setSubject("안녕하세요");
////    	simpleMailMessage.setFrom("wjsgusfhr324@gmail.com");
//    	simpleMailMessage.setText("안녕하세요\n\n 잘지내고 계시죠");
//    	javaMailSender.send(simpleMailMessage);
//    }
	
	
//	회원가입 축하 메일
    public void sendMailWelcome(MemberDto memberDto, TemplateVo templateVo) throws Exception{
//        템플릿 시퀀스 설정
    	templateVo.setIftpSeq("1");
    	
    	TemplateDto templateDto = templateService.selectOne(templateVo);
    	String contentsHtml = templateDto.getIftpContents();
    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setTo(memberDto.getIfmeEmailFull()); 
    	mimeMessageHelper.setSubject(templateDto.getIftpTitle());
    	mimeMessageHelper.setText(contentsHtml, true); 
    	javaMailSender.send(mimeMessage);
    	
    }


//	이메일 인증
    public void sendMailCertification(MemberDto memberDto, TemplateVo templateVo) throws Exception{
//        템플릿 시퀀스 설정
    	templateVo.setIftpSeq("2");
        Context context = new Context();
//        데이터 뭐 넘겨줄지 설정
        String key = createRandomNumber();
        context.setVariable("randomNum", key);
        memberDto.setIfcfKey(key);
        memberDao.insertCertification(memberDto);
        
        TemplateDto templateDto = templateService.selectOne(templateVo);
        String contentsHtml = templateDto.getIftpContents();
        
        // html에서 인증번호라는 곳에 key를 넣는다
        String template = contentsHtml.replace("인증번호", key);
        
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        mimeMessageHelper.setTo(memberDto.getIfmeEmailFull()); 
        mimeMessageHelper.setSubject(templateDto.getIftpTitle()); 
        mimeMessageHelper.setText(template, true); 
        javaMailSender.send(mimeMessage);

    }
    
    
    public String createRandomNumber() {
//    	6자리 난수
    	int randomKey = (int)(Math.random() * 899999) + 100000;
    	String randomKeyString = String.valueOf(randomKey);
    	return randomKeyString;
    }
}
