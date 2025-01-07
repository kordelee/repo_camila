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

	String pathCommonUsr = "usr/v1/infra/popup/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/popup/";
	
	
	@Autowired
	PopupService service;
	
	
	@RequestMapping(value = "/popupXdmList")
	public String popupXdmList(@ModelAttribute("vo") PopupVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}

		return pathCommonXdm + "popupXdmList";
  	}
	

	@RequestMapping(value = "/popupXdmView")
	public String popupXdmView(@ModelAttribute("vo") PopupVo vo, Model model) {

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "popupXdmView";
	}

	
	@RequestMapping(value = "/popupXdmForm")
	public String popupXdmForm(@ModelAttribute("vo") PopupVo vo, Model model) throws Exception{
		
		if (vo.getIfppSeq().equals("0") || vo.getIfppSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", service.selectOne(vo));
			model.addAttribute("listUploaded", service.selectListUploaded(vo));
		}
		return pathCommonXdm + "popupXdmForm";
	}
	
	
	@RequestMapping(value = "/popupXdmMultiUele")
	public String popupXdmMultiUele(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfppSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}

	
	@RequestMapping(value = "/popupXdmMultiDele")
	public String popupXdmMultiDele(PopupVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfppSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/popupXdmInst")
	public String popupXdmInst(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIfppSeq(dto.getIfppSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "popupXdmForm";
		} else {
			return pathRedirectCommonXdm + "popupXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/popupXdmUpdt")
	public String popupXdmUpdt(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "popupXdmForm";
		} else {
			return pathRedirectCommonXdm + "popupXdmList";
		}
	}
	
	@RequestMapping(value = "/popupXdmUele")
	public String popupXdmUele(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}

	
	@RequestMapping(value = "/popupXdmDele")
	public String popupXdmDele(PopupVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "popupXdmList";
	}
	
	
	@RequestMapping(value = "/popupUploadedXdmUele")
	public String popupUploadedXdmUele(PopupVo vo, PopupDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.ueleteUploaded(dto);
		
		redirectAttributes.addFlashAttribute("vo", vo);
		
		return pathRedirectCommonXdm + "popupXdmForm";
	}
	
	
	@RequestMapping(value = "/popupUploadedXdmDele")
	public String popupUploadedXdmDele(PopupDto dto, PopupVo vo, RedirectAttributes redirectAttributes) throws Exception {
		
		service.deleteUploaded(dto);
		
		redirectAttributes.addFlashAttribute("vo", vo);
		
		return pathRedirectCommonXdm + "popupXdmForm";
	}
}
