package com.junefw.infra.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.common.base.BaseController;

@Controller
@RequestMapping(value = "/infra/member")
public class MemberController extends BaseController{
	
	String uriList = "xdm/v1/infra/member/memberXdmList";
	String uriAjaxList = "xdm/v1/infra/member/memberXdmAjaxList";
	String uriAjaxLita = "xdm/v1/infra/member/memberXdmAjaxLita";
	String uriForm = "xdm/v1/infra/member/memberXdmForm";
	String uriView = "xdm/v1/infra/member/memberXdmView";
	
	String uriRedirectList = "redirect:/v1/infra/member/memberXdmList";
	String uriRedirectAjaxList = "redirect:/v1/infra/member/memberXdmAjaxList";
	String uriRedirectForm = "redirect:/v1/infra/member/memberXdmForm";
	String uriRedirectView = "";
	
    @RequestMapping(value = "/signInXdmForm")
	public String signInXdmForm() throws Exception{
    	return "xdm/v1/infra/member/signInXdmForm";
    }
    
    
    @RequestMapping(value = "/signUpXdmForm")
    public String signUpXdmForm() throws Exception{
    	return "xdm/v1/infra/member/signUpXdmForm";
    }

}
