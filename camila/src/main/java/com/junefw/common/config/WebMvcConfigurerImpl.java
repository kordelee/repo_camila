package com.junefw.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.junefw.common.constants.Constants;
import com.junefw.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constants.UPLOADED_RESSOURCE_HANDLER)
                .addResourceLocations(Constants.UPLOADED_RESSOURCE_LOCATIONS);
    }
    
    
//    "/resources/**" 설정이 적용이 되지 않는다. spring 에서는 적용이 되었는데...
//    /resources/static/ 하위 폴도를 예외로 설정하지 잘 적용이 되었다.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor())
//				.order(1)
				.addPathPatterns("/*/*/*/*Xdm*", "/*/*/*/*Usr*")
				.excludePathPatterns(
//						"/resources/**",
						"/usr/**",
						"/v1/infra/member/signupUsrForm",
						"/v1/infra/member/signinUsrForm",
						"/v1/infra/member/signinUsrProc",
						"/v1/infra/member/signupIdCheckUsrProc",
						"/v1/infra/member/sendMailGoogleCertificationUsrProc",
						"/v1/infra/member/certificationCheckUsrProc",
						"/v1/infra/member/memberUsrInst",
						"/v1/infra/member/findIdUsrForm",
						"/v1/infra/member/findPwdUsrForm",
						"/v1/infra/index/indexUsrView",
						"/v1/infra/member/findIdUsrProc",
						"/adt/**",
						"/xdm/**",
						"/v1/infra/member/signupXdmForm",
						"/v1/infra/member/signinXdmForm",
						"/v1/infra/member/signinXdmProc"
		);
	}

}
