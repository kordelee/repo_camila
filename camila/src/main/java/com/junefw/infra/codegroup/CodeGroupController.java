package com.junefw.infra.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.common.base.BaseController;
import com.junefw.common.util.UtilDateTime;

@Controller
@RequestMapping(value = "/infra/codegroup")
public class CodeGroupController extends BaseController{

	String uriList = "xdm/v1/infra/codegroup/codeGroupXdmList";
	String uriAjaxList = "xdm/v1/infra/codegroup/codeGroupXdmAjaxList";
	String uriAjaxLita = "xdm/v1/infra/codegroup/codeGroupXdmAjaxLita";
	String uriForm = "xdm/v1/infra/codegroup/codeGroupXdmForm";
	String uriView = "";
	
	String uriRedirectList = "redirect:/v1/infra/codegroup/codeGroupXdmList";
	String uriRedirectAjaxList = "redirect:/v1/infra/codegroup/codeGroupXdmAjaxList";
	String uriRedirectForm = "redirect:/v1/infra/codegroup/codeGroupXdmForm";
	String uriRedirectView = "";
	
	@Autowired
	CodeGroupService service;
	
	public void setSearch(CodeGroupVo vo) throws Exception {
		
		vo.setShUseNy(vo.getShUseNy() == null ? 1 : vo.getShUseNy());
		vo.setShDelNy(vo.getShDelNy() == null ? 0 : vo.getShDelNy());
		vo.setShOptionDate(vo.getShOptionDate() == null ? 2 : vo.getShOptionDate());
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}	
	
//    @RequestMapping(value = "/codeGroupList")
//    	public String codeGroupList(@ModelAttribute("vo") CodeGroupVo vo, Model model) throws Exception{
//        vo.setParamsPaging(service.selectOneCount(vo));
//        List<CodeGroupDto> list = service.selectList(vo);
//        System.out.println("asdasdf");
//        System.out.println("asdasdf");
//        System.out.println("asdasdf");
//        System.out.println("asdasdf");
//        System.out.println("asdasdf");
//        model.addAttribute("list", list);
//        return "codeGroupList";
//    }
	
	@RequestMapping(value = "/codeGroupList")
	public String codeGroupList() throws Exception{
	  return uriList;
  	}
	
	@RequestMapping(value = "/codeGroupForm")
	public String codeGroupForm() throws Exception{
		return uriForm;
	}
	
}