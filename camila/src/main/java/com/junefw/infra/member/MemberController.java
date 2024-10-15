package com.junefw.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;
import com.junefw.common.util.UtilCookie;
import com.junefw.infra.mail.MailService;
import com.junefw.infra.template.TemplateVo;

import jakarta.servlet.http.HttpSession;

@Controller
@EnableRedisHttpSession
@RequestMapping(value = "/v1/infra/member")
public class MemberController extends BaseController{
	
	String pathCommonXdm = "xdm/v1/infra/member/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/member/";

	String pathCommonUsr = "usr/v1/infra/member/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/member/";
	
	
	@Autowired
	MemberService service;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value = "/memberXdmList")
	public String memberXdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception{
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		return pathCommonXdm + "memberXdmList";
	}
	
	
	
	@RequestMapping(value = "/memberXdmView")
	public String memberXdmView(@ModelAttribute("vo") MemberVo vo, Model model) {

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "memberXdmView";
	}

	
	@RequestMapping(value = "memberXdmForm")
	public String memberXdmForm(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
		
		if (vo.getIfmmSeq().equals("0") || vo.getIfmmSeq().equals("")) {
			//	insert
		} else {
			model.addAttribute("item", service.selectOne(vo));
			model.addAttribute("listUploaded", service.selectListUploaded(vo));
		}
		
		return pathCommonXdm + "memberXdmForm";
	}
	

	@RequestMapping(value = "memberXdmMultiUele")
	public String memberXdmMultiUele(MemberVo vo, MemberDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfmmSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "memberXdmList";
	}

	
	@RequestMapping(value = "memberXdmMultiDele")
	public String memberXdmMultiDele(MemberVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfmmSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "memberXdmList";
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "memberXdmInst")
	public String memberXdmInst(MemberVo vo, MemberDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
	
		vo.setIfmmSeq(dto.getIfmmSeq());
//		vo.setIfmmSeq(encodeBcrypt(dto.getIfmmPassword(), 10));
		
//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				mailService.sendMailAuthorizationPwd();
//			}
//		});
//		
//		thread.start();
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "memberXdmForm";
		} else {
			return pathRedirectCommonXdm + "memberXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "memberXdmUpdt")
	public String memberXdmUpdt(MemberVo vo, MemberDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.UPDATE_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "memberXdmForm";
		} else {
			return pathRedirectCommonXdm + "memberXdmList";
		}
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "memberUseXdmUpdt")
	public String memberUseXdmUpdt(MemberDto dto) throws Exception {

		service.useUpdate(dto);

		return pathRedirectCommonXdm + "memberUseXdmForm";
	}

	
	@RequestMapping(value = "memberXdmUele")
	public String memberXdmUele(MemberVo vo, MemberDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "memberXdmList";
	}

	
	@RequestMapping(value = "memberXdmDele")
	public String memberXdmDele(MemberVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "memberXdmList";
	}
	
    
    @RequestMapping(value = "/signupXdmForm")
    public String signupXdmForm() throws Exception{
    	return "xdm/v1/infra/member/signupXdmForm";
    }

    
    @RequestMapping(value = "signinXdmForm")
	public String signinXdmForm(MemberVo vo, HttpSession httpSession) throws Exception {

    	if(UtilCookie.getValueXdm(Constants.COOKIE_SEQ_NAME_XDM) != null) {
			//	auto login
			if(httpSession.getAttribute("sessSeqXdm") == null) { 
				
				vo.setIfmmSeq(UtilCookie.getValueXdm(Constants.COOKIE_SEQ_NAME_XDM));
				
				MemberDto rtMember = service.selectOne(vo);
				
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtMember.getIfmmSeq());
				httpSession.setAttribute("sessIdXdm", rtMember.getIfmmId());
				httpSession.setAttribute("sessNameXdm", rtMember.getIfmmName());
			} else {
				//	by pass
			}
			return "redirect:/v1/infra/index/indexXdmView";
		} else {
			return pathCommonXdm + "signinXdmForm";
		}
	}


	@ResponseBody
	@RequestMapping(value = "signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		MemberDto rtMember = service.selectOneId(dto);

		if (rtMember != null) {
//			dto.setIfmmPassword(UtilSecurity.encryptSha256(dto.getIfmmPassword()));
			MemberDto rtMember2 = service.selectOneLogin(dto);

			if (rtMember2 != null) {
				
				if(dto.getAutoLogin() == true) {
					UtilCookie.createCookie(
							Constants.COOKIE_SEQ_NAME_XDM, 
							rtMember2.getIfmmSeq(), 
							Constants.COOKIE_DOMAIN_XDM, 
							Constants.COOKIE_PATH_XDM, 
							Constants.COOKIE_MAXAGE_XDM);
				} else {
					// by pass
				}

				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqXdm", rtMember2.getIfmmSeq());
				httpSession.setAttribute("sessIdXdm", rtMember2.getIfmmId());
				httpSession.setAttribute("sessNameXdm", rtMember2.getIfmmName());

				rtMember2.setIfmmSocialLoginCd(103);
				rtMember2.setIflgResultNy(1);
				service.insertLogLogin(rtMember2);

//				Date date = rtMember2.getIfmmPwdModDate();
//				LocalDateTime ifmmPwdModDateLocalDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
//
//				if (ChronoUnit.DAYS.between(ifmmPwdModDateLocalDateTime, UtilDateTime.nowLocalDateTime()) > Constants.PASSWOPRD_CHANGE_INTERVAL) {
//					returnMap.put("changePwd", "true");
//				}
				
				returnMap.put("rt", "success");
			} else {
				dto.setIfmmSocialLoginCd(103);
				dto.setIfmmSeq(rtMember.getIfmmSeq());
				dto.setIflgResultNy(0);
				service.insertLogLogin(dto);

				returnMap.put("rt", "fail");
			}
		} else {
			dto.setIfmmSocialLoginCd(103);
			dto.setIflgResultNy(0);
			service.insertLogLogin(dto);

			returnMap.put("rt", "fail");
		}
		return returnMap;
	}

	
	@RequestMapping(value = "/expiredPwdXdmForm")
	public String expiredPwdXdmForm() throws Exception {

		return pathCommonXdm + "expiredPwdXdmForm";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UtilCookie.deleteCookieXdm();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
//	개인정보 관리
	@RequestMapping(value = "memberUseXdmForm")
	public String memberUseXdmForm(@ModelAttribute("vo") MemberVo vo, Model model,HttpSession session) throws Exception {
		vo.setIfmmSeq(session.getAttribute("sessSeqXdm").toString());
		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "memberUseXdmForm";
	}
	
//
//	usr
//	
	
	@RequestMapping(value = "signinUsrForm")
	public String signinUsrForm(MemberVo vo, HttpSession httpSession) throws Exception {

    	if(UtilCookie.getValueUsr(Constants.COOKIE_SEQ_NAME_USR) != null) {
			//	auto login
			if(httpSession.getAttribute("sessSeqUsr") == null) { 
				
				vo.setIfmmSeq(UtilCookie.getValueUsr(Constants.COOKIE_SEQ_NAME_USR));
				
				MemberDto rtMember = service.selectOne(vo);
				
				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_USR); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMember.getIfmmSeq());
				httpSession.setAttribute("sessIdUsr", rtMember.getIfmmId());
				httpSession.setAttribute("sessNameUsr", rtMember.getIfmmName());
			} else {
				//	by pass
			}
			return "redirect:/v1/infra/index/indexUsrView";
		} else {
			return pathCommonUsr + "signinUsrForm";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "signoutUsrProc")
	public Map<String, Object> signoutUsrProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UtilCookie.deleteCookieUsr();
//		httpSession.invalidate();
		httpSession.setAttribute("sessSeqUsr", null);
		httpSession.setAttribute("sessIdUsr", null);
		httpSession.setAttribute("sessNameUsr", null);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "signinUsrProc")
	public Map<String, Object> signinUsrProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		MemberDto rtMember = service.selectOneId(dto);

		if (rtMember != null) {
			MemberDto rtMember2 = service.selectOneLogin(dto);

			if (rtMember2 != null) {
				
				if(dto.getAutoLogin() == true) {
					UtilCookie.createCookie(
							Constants.COOKIE_SEQ_NAME_USR, 
							rtMember2.getIfmmSeq(), 
							Constants.COOKIE_DOMAIN_USR, 
							Constants.COOKIE_PATH_USR, 
							Constants.COOKIE_MAXAGE_USR);
				} else {
					// by pass
				}

				httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_USR); // 60second * 30 = 30minute
				httpSession.setAttribute("sessSeqUsr", rtMember2.getIfmmSeq());
				httpSession.setAttribute("sessIdUsr", rtMember2.getIfmmId());
				httpSession.setAttribute("sessNameUsr", rtMember2.getIfmmName());

				rtMember2.setIfmmSocialLoginCd(103);
				rtMember2.setIflgResultNy(1);
				service.insertLogLogin(rtMember2);

				returnMap.put("rt", "success");
			} else {
				dto.setIfmmSocialLoginCd(103);
				dto.setIfmmSeq(rtMember.getIfmmSeq());
				dto.setIflgResultNy(0);
				service.insertLogLogin(dto);

				returnMap.put("rt", "fail");
			}
		} else {
			dto.setIfmmSocialLoginCd(103);
			dto.setIflgResultNy(0);
			service.insertLogLogin(dto);

			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	
	@RequestMapping(value = "findIdPwdUsrForm")
	public String findIdPwdUsrForm(MemberVo vo, HttpSession httpSession) throws Exception {

		return pathCommonUsr + "findIdPwdUsrForm";
	}
	
	@RequestMapping(value = "findPwdUsrForm")
	public String findPwdUsrForm(@ModelAttribute("vo") MemberVo vo, MemberDto dto) throws Exception {
		return pathCommonUsr + "findPwdUsrForm";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "findIdPwdProc")
	public Map<String, Object> findIdPwdProc(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		MemberDto findMember = service.selectOneFindIdPwd(dto);
		
		if(findMember != null) {
			returnMap.put("rt", "success");
			returnMap.put("id", findMember.getIfmmId());
		}
		return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "emailSendUsrProc")
	public Map<String, Object> emailSendUsrProc(MemberDto dto,TemplateVo tvo, MemberVo vo) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		MemberDto findMember = service.selectOneFindIdPwd(dto);
		
		if(findMember != null) {
			Thread thread = new Thread(new Runnable() {
	
				@Override
				public void run() {
					try {
						mailService.sendEmailTemplate(dto, tvo);
						service.insertCertification(dto);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			});
			
			thread.start();
			vo.setIfmmSeq(findMember.getIfmmSeq());
			returnMap.put("seq", vo.getIfmmSeq());
			returnMap.put("rt", "success");
			if(service.selectOneCertification(dto) != null) {
				returnMap.put("rt", "checked");
			}
		}
		return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "emailCheckUsrProc")
	public Map<String, Object> emailCheckUsrProc(MemberDto dto,TemplateVo tvo) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		if(service.selectOneCertification(dto) != null) {
			returnMap.put("rt", "success");
		}
		
		return returnMap;
	}
	
	
	@RequestMapping(value = "changePwdUsrForm")
    public String changePwdUsrForm(@ModelAttribute("vo") MemberVo vo) throws Exception{
    	return pathCommonUsr + "changePwdUsrForm";
    }
	
	
	@ResponseBody
	@RequestMapping(value = "changPwdUsrProc")
	public Map<String, Object> changPwdUsrProc(MemberVo vo) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		service.updateChangePwd(vo);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "signupUsrForm")
    public String signupUsrForm() throws Exception{
    	return pathCommonUsr + "signupUsrForm";
    }
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "memberUsrInst")
	public String memberUsrInst(MemberVo vo, MemberDto dto, RedirectAttributes redirectAttributes) throws Exception {

		vo.setIfmmSeq(encodeBcrypt(dto.getIfmmPassword(), 10));
		service.insert(dto);
	
//		vo.setIfmmSeq(dto.getIfmmSeq());
		
//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				mailService.sendMailAuthorizationPwd();
//			}
//		});
//		
//		thread.start();
		
		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonUsr + "welcomeUsrView";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "signupUsrIdCheck")
	public Map<String, Object> signupUsrIdCheck(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		int idCheck = service.selectOneIdCheck(dto);
		
		if(idCheck != 0) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "signupUsrEmailCheck")
	public Map<String, Object> signupUsrEmailCheck(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		int emailCheck = service.selectOneEmailCheck(dto);
		
		if(emailCheck != 0) {
			returnMap.put("rt", "success");
		} else {
//			by pass
		}
		return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "signupUsrPwdCheck")
	public Map<String, Object> signupUsrPwdCheck(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		if(dto.getIfmmPassword().equals(dto.getIfmmPwdCheck())) {
			returnMap.put("rt", "success");
		} else {
//			by pass
		}
		return returnMap;
	}
	
	
	@RequestMapping(value = "infoChangeUsrForm")
    public String infoChangeUsrForm(Model model, MemberVo vo,HttpSession session) throws Exception{
		vo.setIfmmSeq(session.getAttribute("sessSeqUsr").toString());
		model.addAttribute("item", service.selectOne(vo));
    	return pathCommonUsr + "infoChangeUsrForm";
    }
	
	
	@ResponseBody
	@RequestMapping(value = "infoUpdtUsrProc")
	public Map<String, Object> infoUpdtUsrProc(MemberDto dto, HttpSession session) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		dto.setIfmmSeq(session.getAttribute("sessSeqUsr").toString());
		service.infoUpdate(dto);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "infoPwdChangeUsrForm")
    public String infoPwdChangeUsrForm() throws Exception{
    	return pathCommonUsr + "infoPwdChangeUsrForm";
    }
	
	
	@ResponseBody
	@RequestMapping(value = "infoPwdChangeUsrProc")
	public Map<String, Object> infoPwdChangeUsrProc(MemberVo vo,HttpSession session) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		vo.setIfmmSeq(session.getAttribute("sessSeqUsr").toString());
		service.updateChangePwd(vo);
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	
	@RequestMapping(value = "withdrawUsrForm")
    public String withdrawUsrForm() throws Exception{
    	return pathCommonUsr + "withdrawUsrForm";
    }
	
	
	@ResponseBody
	@RequestMapping(value = "withdrawUsrProc")
	public Map<String, Object> withdrawUsrProc(MemberDto dto,HttpSession session) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		dto.setIfmmSeq(session.getAttribute("sessSeqUsr").toString());
		if(service.withdrawUelete(dto) != 0) {
			service.withdrawUelete(dto);
			returnMap.put("rt", "success");
		}
		return returnMap;
	}
	
	
	@RequestMapping(value = "welcomeUsrView")
	public String welcomeUsrView() throws Exception{
		return pathCommonUsr + "welcomeUsrView";
	}
	
}
