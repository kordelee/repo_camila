package com.junefw.infra.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;

@Controller
@RequestMapping(value = "/v1/infra/banner")
public class BannerController extends BaseController {
	
	String pathCommonXdm = "xdm/v1/infra/banner/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/banner/";

	String pathCommonUsr = "usr/v1/infra/banner/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/banner/";
	
	
	@Autowired
	BannerService service;
	
	
	@RequestMapping(value = "/bannerXdmList")
	public String bannerXdmList(@ModelAttribute("vo") BannerVo  vo, Model model) throws Exception{

		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}

		return pathCommonXdm + "bannerXdmList";
  	}
	

	@RequestMapping(value = "/bannerXdmView")
	public String bannerXdmView(@ModelAttribute("vo") BannerVo  vo, Model model) {

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "bannerXdmView";
	}

	
	@RequestMapping(value = "/bannerXdmForm")
	public String bannerXdmForm(@ModelAttribute("vo") BannerVo  vo, Model model) throws Exception{
		
		if (vo.getIfbnSeq().equals("0") || vo.getIfbnSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", service.selectOne(vo));
			model.addAttribute("listUploaded", service.selectListUploaded(vo));
		}
		return pathCommonXdm + "bannerXdmForm";
	}
	
	
	@RequestMapping(value = "/bannerXdmMultiUele")
	public String bannerXdmMultiUele(BannerVo  vo, BannerDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfbnSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "bannerXdmList";
	}

	
	@RequestMapping(value = "/bannerXdmMultiDele")
	public String bannerXdmMultiDele(BannerVo  vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfbnSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "bannerXdmList";
	}
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/bannerXdmInst")
	public String bannerXdmInst(BannerVo  vo, BannerDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
		
		vo.setIfbnSeq(dto.getIfbnSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "bannerXdmForm";
		} else {
			return pathRedirectCommonXdm + "bannerXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/bannerXdmUpdt")
	public String bannerXdmUpdt(BannerVo  vo, BannerDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "bannerXdmForm";
		} else {
			return pathRedirectCommonXdm + "bannerXdmList";
		}
	}
	
	@RequestMapping(value = "/bannerXdmUele")
	public String bannerXdmUele(BannerVo  vo, BannerDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "bannerXdmList";
	}

	
	@RequestMapping(value = "/bannerXdmDele")
	public String bannerXdmDele(BannerVo  vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "bannerXdmList";
	}
	
	
	@RequestMapping(value = "/bannerUploadedXdmUele")
	public String bannerUploadedXdmUele(BannerVo vo, BannerDto dto, RedirectAttributes redirectAttributes) throws Exception {
		
		service.ueleteUploaded(dto);
		
		redirectAttributes.addFlashAttribute("vo", vo);
		
		return pathRedirectCommonXdm + "bannerXdmForm";
	}
	
	
	@RequestMapping(value = "/bannerUploadedXdmDele")
	public String bannerUploadedXdmDele(BannerDto dto, BannerVo vo, RedirectAttributes redirectAttributes) throws Exception {
		
		service.deleteUploaded(dto);
		
		redirectAttributes.addFlashAttribute("vo", vo);
		
		return pathRedirectCommonXdm + "bannerXdmForm";
	}

}
