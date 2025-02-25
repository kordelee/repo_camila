package com.junefw.infra.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/v1/infra/qna")
public class QnaController extends BaseController {
	String pathCommonXdm = "xdm/v1/infra/qna/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/qna/";

	String pathCommonUsr = "usr/v1/infra/qna/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/qna/";
	
	
	@Autowired
	QnaService service;
	
	
	@RequestMapping(value = "/qnaXdmList")
	public String qnaXdmList(@ModelAttribute("vo") QnaVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}

		return pathCommonXdm + "qnaXdmList";
  	}
	

	@RequestMapping(value = "/qnaXdmView")
	public String qnaXdmView(@ModelAttribute("vo") QnaVo vo, Model model) {

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "qnaXdmView";
	}

	
	@RequestMapping(value = "/qnaXdmForm")
	public String qnaXdmForm(@ModelAttribute("vo") QnaVo vo, Model model) throws Exception{
		
		if (vo.getIfqaSeq().equals("0") || vo.getIfqaSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", service.selectOne(vo));
		}
		return pathCommonXdm + "qnaXdmForm";
	}
	
	
	@RequestMapping(value = "/qnaXdmMultiUele")
	public String qnaXdmMultiUele(QnaVo vo, QnaDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfqaSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "qnaXdmList";
	}

	
	@RequestMapping(value = "/qnaXdmMultiDele")
	public String qnaXdmMultiDele(QnaVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfqaSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "qnaXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/qnaXdmInst")
	public String qnaXdmInst(QnaVo vo, QnaDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIfqaSeq(dto.getIfqaSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "qnaXdmForm";
		} else {
			return pathRedirectCommonXdm + "qnaXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/qnaXdmUpdt")
	public String qnaXdmUpdt(QnaVo vo, QnaDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "qnaXdmForm";
		} else {
			return pathRedirectCommonXdm + "qnaXdmList";
		}
	}
	
	@RequestMapping(value = "/qnaXdmUele")
	public String qnaXdmUele(QnaVo vo, QnaDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "qnaXdmList";
	}

	
	@RequestMapping(value = "/qnaXdmDele")
	public String qnaXdmDele(QnaVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "qnaXdmList";
	}
	
//	
//	usr
//	
	
	@RequestMapping(value = "/qnaUsrList")
	public String qnaUsrList(@ModelAttribute("vo") QnaVo vo, Model model,HttpSession session) throws Exception{

		vo.setShOptionDate(0);
		vo.setRegSeq(session.getAttribute("sessSeqUsr").toString());
		vo.setParamsPaging(service.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {
			
			model.addAttribute("list", service.selectMyList(vo));
		}

		return pathCommonUsr + "qnaUsrList";
  	}
	
	
	@RequestMapping(value = "/qnaUsrView")
	public String qnaUsrView(@ModelAttribute("vo") QnaVo vo, Model model) {
		
		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonUsr + "qnaUsrView";
	}
}
