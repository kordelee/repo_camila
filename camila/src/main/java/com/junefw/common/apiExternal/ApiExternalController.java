package com.junefw.common.apiExternal;

import java.io.StringReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.XMLObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class ApiExternalController {
	
	@Value("${serviceKeyPublilcDataPotal}")
	private String serviceKeyPublilcDataPotal;
	
	@Value("${serviceKeyKiprisPlus}")
	private String serviceKeyKiprisPlus;

	
	@ResponseBody
	@RequestMapping(value = "/apiExternalCheckBiznum")
	public Map<String, Object> apiExternalCheckBiznum(@RequestParam("fappBizNumber") String fappBizNumber) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

//	 	Header set
	    HttpHeaders header = new HttpHeaders();
	    header.setContentType(MediaType.APPLICATION_JSON);
	    
//	    json객체 생성(request 전달시 필요)
	    ObjectMapper objectMapper = new ObjectMapper();
	    ObjectNode body = objectMapper.createObjectNode();
	    ArrayNode array = objectMapper.createArrayNode();
	    array.add(fappBizNumber); 
	    body.set("b_no", array);
	    
//	    RestTemplate 구조
	    HttpEntity<String> entity = new HttpEntity<>(body.toString(),header);

	    String url = "http://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey=" + serviceKeyPublilcDataPotal;
	    URI uri = new URI(url);

	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

	    JsonNode jsonResponse = objectMapper.readTree(response.getBody());
	    
	    if (jsonResponse.get("data").get(0).get("b_stt_cd").asText().equals("01")) {
	    	returnMap.put("rt", "success");
	    } else {
	    	returnMap.put("rt", "fail");
	    }
	    
	    return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/apiExternalCheckCopyright")
	public Map<String, Object> apiExternalCheckCopyright(@RequestParam("copyrightNumber") String copyrightNumber) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

//		Header셋팅
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
//        RestTemplate 구조
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        String url ="https://api.odcloud.kr/api/CpyrRegInforService/v1/getCpyrRegInforUniDetail?page=1&perPage=10&cond[REG_ID::EQ]="+copyrightNumber+"&type=json&application=true&registration=true&serviceKey=" + serviceKeyPublilcDataPotal;
        URI uri = new URI(url);
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response.getBody());
        
	    if(jsonResponse.get("currentCount").asText() == "1") {
	    	returnMap.put("rt", "success");
	    }else {
	    	returnMap.put("rt", "fail");
	    }
	    return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/apiExternalCheckTrademark")
	public Map<String, Object> apiExternalCheckTrademark(@RequestParam("trademarkNumber") String trademarkNumber) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
//        RestTemplate 구조
		HttpEntity<?> entity = new HttpEntity<>(null);
		String url ="http://plus.kipris.or.kr/openapi/rest/trademarkInfoSearchService/registerNumberSearchInfo?trademark=true&docsStart=1&registration=true&registerNumber="+trademarkNumber+"&accessKey="+serviceKeyKiprisPlus;
		URI uri = new URI(url);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		
//		xml 파싱 빌드
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(new InputSource(new StringReader(response.getBody())));
	    String trademarkStatus = document.getElementsByTagName("ApplicationStatus").item(0).getTextContent();
	    
		if(trademarkStatus.equals("등록")) {
			returnMap.put("rt", "success");
		} else {
//			by pass
		}
		return returnMap;
	}
	
	
	@RequestMapping(value = "/test")
	public String test() throws Exception {
		RestTemplate restTemplate = new RestTemplate();

        // Header set
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        
        // Body set
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("b_no","7628103410");
//        body.add("start_dt", "20240906");
//        body.add("p_nm", "송준용");

        // Message
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        String serviceKey = "Yvrc%2FZGzFEMPFSmNCRDxi1GLfxo1Klu8%2BTdMn0KibDwqZgKdrJ3dtRLV6RMdSIDADAOkdcBy86t170tM4mZ%2FwA%3D%3D";
        String url ="http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getMmCovidDagnsRgntExprtStusInq?serviceKey="+serviceKey+"&numOfRows=3&pageNo=1&type=json";
        URI uri = new URI(url);
        
        // Request
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(response.getBody());
//        System.out.println(jsonResponse.get("body") + "@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(jsonResponse.get("body").get("items").get(0).get("YYYY").asText() + "@@@@@@@@@@@@@@@@@@@@@@");
        return "usr/v1/infra/apiExternal/apiExternalBizNum";
    }
	
	
	@RequestMapping(value = "/apiExternalBizNum")
	public String apiExternalBizNum() {
		return "usr/v1/infra/apiExternal/apiExternalBizNum";
	}
}
