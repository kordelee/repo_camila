package com.junefw.infra.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;

@Controller
@RequestMapping(value = "/v1/infra/notice")
public class NoticeController extends BaseController {

	String pathCommonXdm = "xdm/v1/infra/notice/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/notice/";

//	String pathCommonUsr = "usr/v1/infra/codeGroup/";
//	String pathRedirectCommonUsr = "";
	
//	String pathCommonAdt = "adt/v1/infra/codeGroup/";
//	String pathRedirectCommonAdt = "";
	
	
	@Autowired
	NoticeService service;
	
	
	@RequestMapping(value = "/noticeXdmList")
	public String noticeXdmList(@ModelAttribute("vo") NoticeVo vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
//			List<NoticeDao> list = service.selectList(vo));
//			model.addAttribute("list", list);
			
			model.addAttribute("list", service.selectList(vo));
		}

		return pathCommonXdm + "noticeXdmList";
  	}
	

	@RequestMapping(value = "/noticeXdmView")
	public String noticeXdmView(@ModelAttribute("vo") NoticeVo vo, Model model) {
		
//		NoticeDto item = service.selectOne(vo);
//		model.addAttribute("item", item);

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "noticeXdmView";
	}

	
	@RequestMapping(value = "/noticeXdmForm")
	public String noticeXdmForm(@ModelAttribute("vo") NoticeVo vo, Model model) throws Exception{
		
		if (vo.getIfntSeq().equals("0") || vo.getIfntSeq().equals("")) {
//			insert mode
		} else {
//			update mode

//			NoticeDto item = service.selectOne(vo);
//			model.addAttribute("item", item);
			
			model.addAttribute("item", service.selectOne(vo));
		}
		return pathCommonXdm + "noticeXdmForm";
	}
	
	
	@RequestMapping(value = "noticeXdmMultiUele")
	public String noticeXdmMultiUele(NoticeVo vo, NoticeDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfntSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "noticeXdmList";
	}

	
	@RequestMapping(value = "noticeXdmMultiDele")
	public String noticeXdmMultiDele(NoticeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfntSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "noticeXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "noticeXdmInst")
	public String noticeXdmInst(NoticeVo vo, NoticeDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIfntSeq(dto.getIfntSeq());
		
//		System.out.println("dto.getUploadFiles().length: " + dto.getUploadFiles().length);
		
		
//		for(MultipartFile a : dto.getUploadFiles()) {
//			System.out.println("a.getOriginalFilename() : " + a.getOriginalFilename());
//		}
		
		

		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "noticeXdmForm";
		} else {
			return pathRedirectCommonXdm + "noticeXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "noticeXdmUpdt")
	public String noticeXdmUpdt(NoticeVo vo, NoticeDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "noticeXdmForm";
		} else {
			return pathRedirectCommonXdm + "noticeXdmList";
		}
	}
	
	@RequestMapping(value = "noticeXdmUele")
	public String noticeXdmUele(NoticeVo vo, NoticeDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "noticeXdmList";
	}

	
	@RequestMapping(value = "noticeXdmDele")
	public String noticeXdmDele(NoticeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "noticeXdmList";
	}
}
