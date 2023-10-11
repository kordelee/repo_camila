package com.junefw.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;

@Controller
@RequestMapping(value = "/v1/infra/codegroup")
public class CodeGroupController extends BaseController{
	
	String pathCommonXdm = "xdm/v1/infra/codeGroup/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/codegroup/";

	String pathCommonUsr = "usr/v1/infra/codeGroup/";
	String pathRedirectCommonUsr = "";
	
	String pathCommonAdt = "adt/v1/infra/codeGroup/";
	String pathRedirectCommonAdt = "";
	
	@Autowired
	CodeGroupService service;
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
//			List<CodeGroupDao> list = service.selectList(vo));
//			model.addAttribute("list", list);
			
			model.addAttribute("list", service.selectList(vo));
		}
        return pathCommonXdm + "codeGroupXdmList";
  	}
	
	
	@RequestMapping(value = "/codeGroupXdmView")
	public String codeGroupXdmView(@ModelAttribute("vo") CodeGroupVo vo, Model model) {
		
//		CodeGroupDto item = service.selectOne(vo);
//		model.addAttribute("item", item);

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "codeGroupXdmView";
	}

	
	@RequestMapping(value = "/codeGroupXdmForm")
	public String codeGroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		
		if (vo.getIfcgSeq().equals("0") || vo.getIfcgSeq().equals("")) {
//			insert mode
		} else {
//			update mode

//			CodeGroupDto item = service.selectOne(vo);
//			model.addAttribute("item", item);
			
			model.addAttribute("item", service.selectOne(vo));
		}
		return pathCommonXdm + "codeGroupXdmForm";
	}
	
	
	@RequestMapping(value = "codeGroupXdmMultiUele")
	public String codeGroupXdmMultiUele(CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfcgSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeGroupXdmList";
	}

	
	@RequestMapping(value = "codeGroupXdmMultiDele")
	public String codeGroupXdmMultiDele(CodeGroupVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfcgSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeGroupXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIfcgSeq(dto.getIfcgSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "codeGroupXdmForm";
		} else {
			return pathRedirectCommonXdm + "codeGroupXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "codeGroupXdmUpdt")
	public String codeGroupXdmUpdt(CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "codeGroupXdmForm";
		} else {
			return pathRedirectCommonXdm + "codeGroupXdmList";
		}
	}
	
	@RequestMapping(value = "codeGroupXdmUele")
	public String codeGroupXdmUele(CodeGroupVo vo, CodeGroupDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeGroupXdmList";
	}

	
	@RequestMapping(value = "codeGroupXdmDele")
	public String codeGroupXdmDele(CodeGroupVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeGroupXdmList";
	}
	
}
