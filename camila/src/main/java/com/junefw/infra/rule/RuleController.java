package com.junefw.infra.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;

@Controller
@RequestMapping(value = "/v1/infra/rule")
public class RuleController extends BaseController{

	String pathCommonXdm = "xdm/v1/infra/rule/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/rule/";

	String pathCommonUsr = "usr/v1/infra/codeGroup/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/rule/";
	
	
	@Autowired
	RuleService service;
	
	
	@RequestMapping(value = "/ruleXdmList")
	public String ruleXdmList(@ModelAttribute("vo") RuleVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}

		return pathCommonXdm + "ruleXdmList";
  	}
	

	@RequestMapping(value = "/ruleXdmView")
	public String ruleXdmView(@ModelAttribute("vo") RuleVo vo, Model model) {

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "ruleXdmView";
	}

	
	@RequestMapping(value = "/ruleXdmForm")
	public String ruleXdmForm(@ModelAttribute("vo") RuleVo vo, Model model) throws Exception{
		
		if (vo.getIfrlSeq().equals("0") || vo.getIfrlSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", service.selectOne(vo));
		}
		return pathCommonXdm + "ruleXdmForm";
	}
	
	
	@RequestMapping(value = "ruleXdmMultiUele")
	public String ruleXdmMultiUele(RuleVo vo, RuleDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfrlSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "ruleXdmList";
	}

	
	@RequestMapping(value = "ruleXdmMultiDele")
	public String ruleXdmMultiDele(RuleVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfrlSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "ruleXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "ruleXdmInst")
	public String ruleXdmInst(RuleVo vo, RuleDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIfrlSeq(dto.getIfrlSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "ruleXdmForm";
		} else {
			return pathRedirectCommonXdm + "ruleXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "ruleXdmUpdt")
	public String ruleXdmUpdt(RuleVo vo, RuleDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "ruleXdmForm";
		} else {
			return pathRedirectCommonXdm + "ruleXdmList";
		}
	}
	
	@RequestMapping(value = "ruleXdmUele")
	public String ruleXdmUele(RuleVo vo, RuleDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "ruleXdmList";
	}

	
	@RequestMapping(value = "ruleXdmDele")
	public String ruleXdmDele(RuleVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "ruleXdmList";
	}
}
