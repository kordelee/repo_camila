package com.junefw.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;
import com.junefw.common.util.UtilDateTime;

@Controller
@RequestMapping(value = "/v1/infra/codegroup")
public class CodeGroupController extends BaseController{
	
	String pathCommonXdm = "xdm/v1/infra/codeGroup/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/codeGroup/";

	String pathCommonUsr = "usr/v1/infra/codeGroup/";
	String pathRedirectCommonUsr = "";
	
	String pathCommonAdt = "adt/v1/infra/codeGroup/";
	String pathRedirectCommonAdt = "";
	
	@Autowired
	CodeGroupService service;
	
	
	public void setSearch(CodeGroupVo vo) throws Exception {
		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		vo.setShDateStart(vo.getShDateStart() == null
		    ? UtilDateTime.calculateDayString(UtilDateTime.nowLocalDateTime(), Constants.DATE_INTERVAL)
		    : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null
		    ? UtilDateTime.nowString()
		    : UtilDateTime.addNowTimeString(vo.getShDateEnd()));		
		
//		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
//		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}	
	
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
        model.addAttribute("list", service.selectList(vo));
        return pathCommonXdm + "codeGroupXdmList";
  	}

	
	@RequestMapping(value = "/codeGroupXdmForm")
	public String codeGroupXdmForm() throws Exception{
		return pathCommonXdm + "codeGroupXdmForm";
	}
	
}
