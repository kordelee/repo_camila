package com.junefw.infra.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.common.base.BaseController;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/v1/infra/index" , "/v0/infra/index"})
public class IndexController extends BaseController{
	
	String pathCommonXdm = "xdm/v1/infra/index/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/index/";

//	String pathCommonUsr = "usr/v0/infra/index/";
//	String pathRedirectCommonUsr = "redirect:/v0/infra/index/";
	
	String pathCommonUsr = "usr/v1/infra/index/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/index/";
	
	
    @RequestMapping(value = "/indexXdmView")
	public String indexXdmView(HttpSession httpSession) throws Exception{
    	return pathCommonXdm + "indexXdmView";
    }
    
//    
//	user
//	
    
	@RequestMapping(value = {"/indexUsrView"})
	public String indexUsrView() throws Exception {
		return pathCommonUsr + "indexUsrView";
	}

}
