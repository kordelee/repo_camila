package com.junefw.common.apiExternal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApiExternalController {

	@PostMapping(value = "/validate")
	public String test() throws Exception {
	    // RestTemplate 객체 생성
	    RestTemplate restTemplate = new RestTemplate();

	    // Body 설정
	    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
	    List<Map<String, String>> businesses = new ArrayList<>();

	    Map<String, String> businessInfo = new HashMap<>();
	    businessInfo.put("b_no", "7628103410");
	    businessInfo.put("start_dt", "20240906");
	    businessInfo.put("p_nm", "송준용");
	    businesses.add(businessInfo);

	    body.add("businesses", businesses);

	    // 설정한 Body와 Header를 가진 HttpEntity 객체 생성
	    HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body);

	    // HTTP POST 요청
	    String url = "http://api.odcloud.kr/api/nts-businessman/v1/validate?returnType=json&serviceKey=VxD/2teDfmU+YTvJG9g+HlKZSr0AFATDBwshQPBytrbQqtsBWBZ257FWQZOoxd4Z8Sxy0D7BP8VjAB8yDYd5sw==";
	    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
	     
	    // HTTP POST 요청에 대한 응답 확인
	    System.out.println("status : " + response.getStatusCode());
	    System.out.println("body : " + response.getBody());

	    return "usr/v1/infra/apiExternal/apiExternalBizNum";
	}
	
	@RequestMapping(value = "/apiExternalBizNum")
	public String apiExternalBizNum() {
		return "usr/v1/infra/apiExternal/apiExternalBizNum";
	}
}
