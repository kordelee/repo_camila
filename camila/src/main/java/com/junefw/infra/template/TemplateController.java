package com.junefw.infra.template;

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
import com.junefw.infra.mail.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/v1/infra/template")
public class TemplateController extends BaseController{

	String pathCommonXdm = "xdm/v1/infra/template/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/template/";

	String pathCommonUsr = "usr/v1/infra/template/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/template/";
	
	
	@Autowired
	TemplateService service;
	
	@Autowired
	MailService mailService;
	
	
	@RequestMapping(value = "/templateXdmList")
	public String templateXdmList(@ModelAttribute("vo") TemplateVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}

		return pathCommonXdm + "templateXdmList";
  	}
	

	@RequestMapping(value = "/templateXdmView")
	public String templateXdmView(@ModelAttribute("vo") TemplateVo vo, Model model) {
		
		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "templateXdmView";
	}

	
	@RequestMapping(value = "/templateXdmForm")
	public String templateXdmForm(@ModelAttribute("vo") TemplateVo vo, Model model) throws Exception{
		
		if (vo.getIftpSeq().equals("0") || vo.getIftpSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", service.selectOne(vo));
		}
		return pathCommonXdm + "templateXdmForm";
	}
	
	
	@RequestMapping(value = "/templateXdmMultiUele")
	public String templateXdmMultiUele(TemplateVo vo, TemplateDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIftpSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "templateXdmList";
	}

	
	@RequestMapping(value = "/templateXdmMultiDele")
	public String templateXdmMultiDele(TemplateVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIftpSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "templateXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/templateXdmInst")
	public String templateXdmInst(TemplateVo vo, TemplateDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIftpSeq(dto.getIftpSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "templateXdmForm";
		} else {
			return pathRedirectCommonXdm + "templateXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/templateXdmUpdt")
	public String templateXdmUpdt(TemplateVo vo, TemplateDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "templateXdmForm";
		} else {
			return pathRedirectCommonXdm + "templateXdmList";
		}
	}
	
	@RequestMapping(value = "/templateXdmUele")
	public String templateXdmUele(TemplateVo vo, TemplateDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "templateXdmList";
	}

	
	@RequestMapping(value = "/templateXdmDele")
	public String templateXdmDele(TemplateVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "templateXdmList";
	}
	
	
	@RequestMapping(value = "/templatePreviewXdmView")
	public String templatePreviewXdmView(@ModelAttribute("vo") TemplateVo vo, Model model) {
		
		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "templatePreviewXdmView";
	}
	
	@ResponseBody
	@RequestMapping(value = "/templateTestXdmProc")
	public Map<String, Object> signoutUsrProc(TemplateVo vo, TemplateDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
//		154: mail
//		155: sms
//		156: kakao talk
		if(dto.getIftpTypeCd() == 154) {
			mailService.sendMailTest(vo);
		} else if (dto.getIftpTypeCd() == 155) {
//			not yet
		} else {
//			not yet
		}
		
		returnMap.put("rt", "success");
		return returnMap;
	}
	
}
