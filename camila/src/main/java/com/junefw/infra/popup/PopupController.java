package com.junefw.infra.popup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;

@Controller
@RequestMapping(value = "/v1/infra/popup")
public class PopupController extends BaseController {

	String pathCommonXdm = "xdm/v1/infra/popup/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/popup/";

//	String pathCommonUsr = "usr/v1/infra/codeGroup/";
//	String pathRedirectCommonUsr = "";
	
//	String pathCommonAdt = "adt/v1/infra/codeGroup/";
//	String pathRedirectCommonAdt = "";
	
	
	@Autowired
	PopupService service;
	
	
	@RequestMapping(value = "/popupXdmList")
	public String popupXdmList(@ModelAttribute("vo") PopupVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
//			List<PopupDao> list = service.selectList(vo));
//			model.addAttribute("list", list);
			
			model.addAttribute("list", service.selectList(vo));
		}

		return pathCommonXdm + "popupXdmList";
  	}
	

	@RequestMapping(value = "/popupXdmView")
	public String popupXdmView(@ModelAttribute("vo") PopupVo vo, Model model) {
		
//		PopupDto item = service.selectOne(vo);
//		model.addAttribute("item", item);

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "popupXdmView";
	}

	
	@RequestMapping(value = "/popupXdmForm")
	public String popupXdmForm(@ModelAttribute("vo") PopupVo vo, Model model) throws Exception{
		
		if (vo.getIfppSeq().equals("0") || vo.getIfppSeq().equals("")) {
//			insert mode
		} else {
//			update mode

//			PopupDto item = service.selectOne(vo);
//			model.addAttribute("item", item);
			
			model.addAttribute("item", service.selectOne(vo));
		}
		return pathCommonXdm + "popupXdmForm";
	}
	
	
	@RequestMapping(value = "popupXdmMultiUele")
	public String popupXdmMultiUele(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfppSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}

	
	@RequestMapping(value = "popupXdmMultiDele")
	public String popupXdmMultiDele(PopupVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfppSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "popupXdmInst")
	public String popupXdmInst(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIfppSeq(dto.getIfppSeq());
		
//		System.out.println("dto.getUploadFiles().length: " + dto.getUploadFiles().length);
		
		
//		for(MultipartFile a : dto.getUploadFiles()) {
//			System.out.println("a.getOriginalFilename() : " + a.getOriginalFilename());
//		}
		
		

		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "popupXdmForm";
		} else {
			return pathRedirectCommonXdm + "popupXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "popupXdmUpdt")
	public String popupXdmUpdt(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "popupXdmForm";
		} else {
			return pathRedirectCommonXdm + "popupXdmList";
		}
	}
	
	@RequestMapping(value = "popupXdmUele")
	public String popupXdmUele(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}

	
	@RequestMapping(value = "popupXdmDele")
	public String popupXdmDele(PopupVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}
}
