package com.junefw.mallbicycle.major;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/v1/mallbicycle/major")
public class MajorController extends BaseController{

	String pathXdmCommon = "xdm/v1/mallbicycle/major/";
	String pathUsrCommon = "usr/v1/mallbicycle/major/";
	
	String pathRedirectCommon = "redirect:/v1/mallbicycle/major/";

	@Autowired
	MajorService service;
	
//	@Autowired
//	MajorCommentServiceImpl serviceComment;
	

//	usr s ////////////////////
//
//	goods
	@RequestMapping(value = "/majorGoodsUsrAjaxList")
	public String majorGoodsUsrAjaxList(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		return pathUsrCommon + "majorGoodsUsrAjaxList";
	}
	
	
	@RequestMapping(value = "/majorGoodsUsrLita")
	public String majorGoodsUsrLita(@ModelAttribute("vo") MajorVo vo, HttpSession session, Model model) throws Exception {
		setSearch(vo);
		vo.setSessUsrSeq(session.getAttribute("sessSeqUsr").toString());
		vo.setParamsPaging(service.selectOneCountMajorGoods(vo));
		
		if (vo.getTotalRows() > 0) {
			List<MajorDto> list = service.selectListMajorGoods(vo);
			model.addAttribute("list", list);
		}
		
		return pathUsrCommon + "majorGoodsUsrLita";
	}
	
	
	@RequestMapping(value = "/majorGoodsUsrView")
	public String majorGoodsUsrView(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		MajorDto item = service.selectOneMajorGoods(vo);
		model.addAttribute("item", item);
		
		return pathUsrCommon + "majorGoodsUsrView";
	}
	
	
	@RequestMapping(value = "/majorGoodsUsrForm")
	public String majorGoodsUsrForm() throws Exception {
		
		return pathUsrCommon + "majorGoodsUsrForm";
	}
	
	
//	trade
	@RequestMapping(value = "/majorTradeUsrAjaxList")
	public String majorTradeUsrAjaxList(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		return pathUsrCommon + "majorTradeUsrAjaxList";
	}
	
	
	@RequestMapping(value = "/majorTradeUsrLita")
	public String majorTradeUsrLita(@ModelAttribute("vo") MajorVo vo, HttpSession httpSession, Model model) throws Exception {
		
		setSearch(vo);
		vo.setSessUsrSeq((String) httpSession.getAttribute("sessUsrSeq"));
		vo.setParamsPaging(service.selectOneCountMajorTrade(vo));
		
		if (vo.getTotalRows() > 0) {
			List<MajorDto> list = service.selectListMajorTrade(vo);
			model.addAttribute("list", list);
		}
		
		return pathUsrCommon + "majorTradeUsrLita";
	}
	
	
	@RequestMapping(value = "/majorTradeUsrView")
	public String majorTradeUsrView(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		MajorDto item = service.selectOneMajorTrade(vo);
		model.addAttribute("item", item);
		
		return pathUsrCommon + "majorTradeUsrView";
	}
	
	
	@RequestMapping(value = "/majorTradeUsrForm")
	public String majorTradeUsrForm() throws Exception {
		
		return pathUsrCommon + "majorTradeUsrForm";
	}
	
	
	@RequestMapping(value = "/majorTradeUsrSalesNyUpdt")
	public String majorTradeUsrSalesNyUpdt(MajorVo vo, MajorDto dto, RedirectAttributes redirectAttributes) throws Exception {
			    
		service.updateMajorTradeSalesNy(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommon + "majorTradeUsrView";
	}
	
	
	// majorTradeCommentUsrAjaxList


//	favorite
	@RequestMapping(value = "/majorFavoriteUsrAjaxList")
	public String majorFavoriteUsrAjaxList(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		return pathUsrCommon + "majorFavoriteUsrAjaxList";
	}
	
	
	@RequestMapping(value = "/majorFavoriteUsrLita")
	public String majorFavoriteUsrLita(@ModelAttribute("vo") MajorVo vo, HttpSession session, Model model) throws Exception {
		
		setSearch(vo);
		vo.setSessUsrSeq(session.getAttribute("sessSeqUsr").toString());
		vo.setParamsPaging(service.selectOneCountMajorFavorite(vo));
		
		if (vo.getTotalRows() > 0) {
			List<MajorDto> list = service.selectListMajorFavorite(vo);
			model.addAttribute("list", list);
		}
		
		return pathUsrCommon + "majorFavoriteUsrLita";
	}
	
	
	@RequestMapping(value = "/majorFavoriteUsrView")
	public String majorFavoriteUsrView(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		MajorDto item = service.selectOneMajorFavorite(vo);
		model.addAttribute("item", item);
		
		return pathUsrCommon + "majorFavoriteUsrView";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/majorFavoriteUsrInst")
	public Map<String, Object> majorFavoriteUsrInst(MajorDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		int result = service.insertMajorFavorite(dto);

		if (result > 0) {
			returnMap.put("rt", "success");
		} else {
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	

	@RequestMapping(value = "/majorFavoriteUsrUele")
	public String majorFavoriteUsrUele(MajorVo vo, MajorDto dto, RedirectAttributes redirectAttributes, HttpSession httpSession) throws Exception {
		
		dto.setMbmfSeq(vo.getMbmfSeq());
		service.ueleteMajorFavorite(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommon + "majorFavoriteUsrAjaxList";
	}
	
	
//	show
	@RequestMapping(value = "/majorShowUsrAjaxList")
	public String majorShowUsrAjaxList(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		return pathUsrCommon + "majorShowUsrAjaxList";
	}
	
	
	@RequestMapping(value = "/majorShowUsrLita")
	public String majorShowUsrLita(@ModelAttribute("vo") MajorVo vo, HttpSession session, Model model) throws Exception {
		
		setSearch(vo);
//		vo.setSessUsrSeq(session.getAttribute("sessUsrSeq").toString());
		vo.setParamsPaging(service.selectOneCountMajorShow(vo));
		
		if (vo.getTotalRows() > 0) {
			List<MajorDto> list = service.selectListMajorShow(vo);
			model.addAttribute("list", list);
		}
		
		return pathUsrCommon + "majorShowUsrLita";
	}
	
	
	@RequestMapping(value = "/majorShowUsrView")
	public String majorShowUsrView(@ModelAttribute("vo") MajorVo vo, MajorDto dto, HttpSession httpSession, Model model) throws Exception {
		
		dto.setMbmtSeq(vo.getMbmtSeq());
		dto.setIfmmSeq((String) httpSession.getAttribute("sessUsrSeq"));
		service.insertMajorHit(dto);
		
		vo.setSessUsrSeq((String) httpSession.getAttribute("sessUsrSeq"));
		MajorDto item = service.selectOneMajorShow(vo);
		model.addAttribute("item", item);
		
		return pathUsrCommon + "majorShowUsrView";
	}	
	
	
	@RequestMapping(value = "/majorShow2UsrAjaxList")
	public String majorShow2UsrAjaxList(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		setSearch(vo);
		
		return pathUsrCommon + "majorShow2UsrAjaxList";
	}
	
	
	@RequestMapping(value = "/majorShow2UsrLita")
	public String majorShow2UsrLita(@ModelAttribute("vo") MajorVo vo, Model model) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCountMajorShow(vo));
		
		if (vo.getTotalRows() > 0) {
			List<MajorDto> list = service.selectListMajorShow(vo);
			model.addAttribute("list", list);
		}
		
		return pathUsrCommon + "majorShow2UsrLita";
	}
}
