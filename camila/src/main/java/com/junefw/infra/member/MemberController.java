package com.junefw.infra.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/v1/infra/member")
public class MemberController extends BaseController{
	
	String pathCommonXdm = "xdm/v1/infra/member/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/member/";

	String pathCommonUsr = "usr/v1/infra/member/";
	String pathRedirectCommonUsr = "";
	
	String pathCommonAdt = "adt/v1/infra/member/";
	String pathRedirectCommonAdt = "";	
	
	
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
		
//		mailService.sendMailSimple();
		
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				mailService.sendMailSimple();
//			}
//		});
//		
//		thread.start();
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				mailService.sendMailSimple();
			}
		});
		
		thread.start();
		
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
		httpSession.invalidate();
		returnMap.put("rt", "success");
		return returnMap;
	}
    
}
