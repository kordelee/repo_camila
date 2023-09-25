package com.junefw.infra.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.common.base.BaseController;

@Controller
@RequestMapping(value = "/infra/index")
public class IndexController extends BaseController{
	
	String uriList = "xdm/v1/infra/index/indexXdmList";
	String uriAjaxList = "xdm/v1/infra/index/indexXdmAjaxList";
	String uriAjaxLita = "xdm/v1/infra/index/indexXdmAjaxLita";
	String uriForm = "xdm/v1/infra/index/indexXdmForm";
	String uriView = "xdm/v1/infra/index/indexXdmView";
	
	String uriRedirectList = "redirect:/v1/infra/index/indexXdmList";
	String uriRedirectAjaxList = "redirect:/v1/infra/index/indexXdmAjaxList";
	String uriRedirectForm = "redirect:/v1/infra/index/indexXdmForm";
	String uriRedirectView = "";
	
    @RequestMapping(value = "/indexXdmView")
	public String indexView() throws Exception{
	return uriView;
}

}
