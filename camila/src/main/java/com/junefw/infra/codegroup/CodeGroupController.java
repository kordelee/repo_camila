package com.junefw.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.common.base.BaseController;

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
	
	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		System.out.println("vo.getShDelNy(): " + vo.getShDelNy());
		System.out.println("vo.getShUseNy(): " + vo.getShUseNy());
		System.out.println("vo.getShOptionDate(): " + vo.getShOptionDate());
		System.out.println("vo.getShOption(): " + vo.getShOption());
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
        return pathCommonXdm + "codeGroupXdmList";
  	}

	
	@RequestMapping(value = "/codeGroupXdmForm")
	public String codeGroupXdmForm() throws Exception{
		return pathCommonXdm + "codeGroupXdmForm";
	}
	
}
