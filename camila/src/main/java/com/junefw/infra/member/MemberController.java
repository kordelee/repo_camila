package com.junefw.infra.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;

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
	
    
	@RequestMapping(value = "/memberXdmAjaxList")
	public String memberXdmAjaxList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception{
		
		setSearch(vo);
		
		return pathCommonXdm + "memberXdmAjaxList";
	}
	
	
	@RequestMapping(value = "/memberXdmAjaxLita")
	public String memberXdmAjaxLita(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception{
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return pathCommonXdm + "memberXdmAjaxLita";
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
	
	
	@RequestMapping(value = "/signInXdmForm")
	public String signInXdmForm() throws Exception{
    	return "xdm/v1/infra/member/signInXdmForm";
    }
    
    
    @RequestMapping(value = "/signUpXdmForm")
    public String signUpXdmForm() throws Exception{
    	return "xdm/v1/infra/member/signUpXdmForm";
    }

}
