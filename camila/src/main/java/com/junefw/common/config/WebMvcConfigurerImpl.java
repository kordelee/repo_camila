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
				.addPathPatterns("/*/*/*/*Xdm*")
				.excludePathPatterns(
//						"/resources/**",
						"/adt/**",
						"/xdm/**",
						"/v1/infra/member/signupXdmForm",
						"/v1/infra/member/signinXdmForm",
						"/v1/infra/member/signinXdmProc"
		);
	}

}
