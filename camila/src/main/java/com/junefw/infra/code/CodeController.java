package com.junefw.infra.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junefw.common.base.BaseController;
import com.junefw.common.constants.Constants;
import com.junefw.common.util.UtilDateTime;
import com.junefw.infra.codegroup.CodeGroupService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/v1/infra/code/")
public class CodeController extends BaseController{
	
	String pathCommonXdm = "xdm/v1/infra/code/";
	String pathRedirectCommonXdm = "redirect:/v1/infra/code/";

	String pathCommonUsr = "usr/v1/infra/code/";
	String pathRedirectCommonUsr = "redirect:/v1/infra/code/";
	
	
	@Autowired
	CodeService service;
	
	@Autowired
	CodeGroupService codeGroupService;
	   
	
	@RequestMapping(value = "/codeXdmAjaxList")
	public String codeXdmAjaxList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
		
		setSearch(vo);
		return pathCommonXdm + "codeXdmAjaxList";
	}
	
	
	@RequestMapping(value = "/codeXdmAjaxLita")
	public String codeXdmAjaxLita(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return pathCommonXdm + "codeXdmAjaxLita";
	}
	
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", service.selectList(vo));
		}
		
		return pathCommonXdm + "codeXdmList";
	}
		
	
	@RequestMapping(value = "/codeXdmView")
	public String codeXdmView(@ModelAttribute("vo") CodeVo vo, Model model) {

		model.addAttribute("item", service.selectOne(vo));
		
		return pathCommonXdm + "codeXdmView";
	}

	
	@RequestMapping(value = "/codeXdmForm")
	public String codeXdmForm(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		model.addAttribute("listCodeGroup", codeGroupService.selectListWithoutPaging());
		
		if (vo.getIfcdSeq().equals("0") || vo.getIfcdSeq().equals("")) {
			//	insert
		} else {
			model.addAttribute("item", service.selectOne(vo));
		}
		
		return pathCommonXdm + "codeXdmForm";
	}
	
	
	@RequestMapping(value = "/codeXdmMultiUele")
	public String codeXdmMultiUele(CodeVo vo, CodeDto dto, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			dto.setIfcdSeq(checkboxSeq);
			service.uelete(dto);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeXdmList";
	}

	
	@RequestMapping(value = "/codeXdmMultiDele")
	public String codeXdmMultiDele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		for (String checkboxSeq : vo.getCheckboxSeqArray()) {
			vo.setIfcdSeq(checkboxSeq);
			service.delete(vo);
		}

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeXdmList";
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/codeXdmInst")
	public String codeXdmInst(CodeVo vo, CodeDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.insert(dto);
	
		vo.setIfcdSeq(dto.getIfcdSeq());
		
		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.INSERT_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "codeXdmForm";
		} else {
			return pathRedirectCommonXdm + "codeXdmList";
		}
	}
	
	
	@SuppressWarnings(value = { "all" })
	@RequestMapping(value = "/codeXdmUpdt")
	public String codeXdmUpdt(CodeVo vo, CodeDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.update(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		if (Constants.UPDATE_AFTER_TYPE == 1) {
			return pathRedirectCommonXdm + "codeXdmForm";
		} else {
			return pathRedirectCommonXdm + "codeXdmList";
		}
	}

	
	@RequestMapping(value = "/codeXdmUele")
	public String codeXdmUele(CodeVo vo, CodeDto dto, RedirectAttributes redirectAttributes) throws Exception {

		service.uelete(dto);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeXdmList";
	}

	
	@RequestMapping(value = "/codeXdmDele")
	public String codeXdmDele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);

		redirectAttributes.addFlashAttribute("vo", vo);

		return pathRedirectCommonXdm + "codeXdmList";
	}


	@RequestMapping("/excelDownload")
    public void excelDownload(CodeVo vo, HttpServletResponse httpServletResponse) throws Exception {
		
		setSearch(vo);
		vo.setParamsPaging(service.selectOneCount(vo));

		if (vo.getTotalRows() > 0) {
			List<CodeDto> list = service.selectList(vo);
			
//			Workbook workbook = new HSSFWorkbook();	// for xls
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("첫번째 시트");
	        CellStyle cellStyle = workbook.createCellStyle();        
	        Row row = null;
	        Cell cell = null;
	        int rowNum = 0;
			
//	        each column width setting
	        sheet.setColumnWidth(0, 2100);
	        sheet.setColumnWidth(1, 3100);

//	        Header
	        String[] tableHeader = {"코드그룹 코드", "코드그룹 이름", "코드", "대체 코드", "코드 이름", "코드 이름 (영문)", "사용", "순서", "등록일", "수정일"};

	        row = sheet.createRow(rowNum++);
			for(int i=0; i<tableHeader.length; i++) {
				cell = row.createCell(i);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
				cell.setCellValue(tableHeader[i]);
			}

//	        Body
	        for (int i=0; i<list.size(); i++) {
	            row = sheet.createRow(rowNum++);
	            
//	            String type: null 전달 되어도 ok
//	            int, date type: null 시 오류 발생 하므로 null check
//	            String type 이지만 정수형 데이터가 전체인 seq 의 경우 캐스팅
	            
	            cell = row.createCell(0);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	            cell.setCellValue(Integer.parseInt(list.get(i).getIfcgSeq()));
	            
	            cell = row.createCell(1);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfcgName());
	        	
	            cell = row.createCell(2);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(Integer.parseInt(list.get(i).getIfcdSeq()));
	        	
	            cell = row.createCell(3);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	cell.setCellValue(list.get(i).getIfcdSeqAnother());
	            
	            cell = row.createCell(4);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfcdName());
	            
	            cell = row.createCell(5);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            cell.setCellValue(list.get(i).getIfcdNameEng());
     
	            cell = row.createCell(6);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfcdUseNy() != null) cell.setCellValue(list.get(i).getIfcdUseNy() == 0 ? "N" : "Y");
	            
	            cell = row.createCell(7);
	            cellStyle.setAlignment(HorizontalAlignment.CENTER);
	            cell.setCellStyle(cellStyle);
	            if(list.get(i).getIfcdOrder() != null) cell.setCellValue(list.get(i).getIfcdOrder());
	            
	            cell = row.createCell(8);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getRegDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getRegDateTime()));
	        	
	        	cell = row.createCell(9);
	        	cellStyle.setAlignment(HorizontalAlignment.CENTER);
	        	cell.setCellStyle(cellStyle);
	        	if(list.get(i).getModDateTime() != null) cell.setCellValue(UtilDateTime.dateTimeToString(list.get(i).getModDateTime()));
	        }

	        httpServletResponse.setContentType("ms-vnd/excel");
//	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xls");	// for xls
	        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

	        workbook.write(httpServletResponse.getOutputStream());
	        workbook.close();
		}
    }
	
	
	@ResponseBody
	@RequestMapping(value = "/codeXdmInit")
	public Map<String, Object> codeXdmInit() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		service.selectListCachedCodeArrayList();
		returnMap.put("rt", "success");
		return returnMap;
	}	

	
	@RequestMapping(value = "/codeXdmCreateUuidForm")
	public String codeXdmCreateUuidForm() throws Exception {
		
		return pathCommonXdm + "codeXdmCreateUuidForm";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/codeXdmCreateUuidProc")
	public Map<String, Object> codeXdmCreateUuidProc() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String uuid = UUID.randomUUID().toString();
		returnMap.put("uuid", uuid);
		return returnMap;
	}
}
