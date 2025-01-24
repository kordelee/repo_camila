package com.junefw.infra.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.junefw.common.base.BaseDto;

public class CategoryDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = -2553162448988326215L;
	
	private String ifctSeq;
	private String ifctName;
	private String ifctNameEng;
	private Integer ifctParents;
	private Integer ifctDepth;
	private Integer ifctUseNy;
	private Integer ifctOrder;
	private String ifctDesc;
	private Integer ifctDelNy;
//	for cache
	public static List<CategoryDto> cachedCategoryArrayList = new ArrayList<CategoryDto>();
	//	-----
	public String getIfctSeq() {
		return ifctSeq;
	}
	public void setIfctSeq(String ifctSeq) {
		this.ifctSeq = ifctSeq;
	}
	public String getIfctName() {
		return ifctName;
	}
	public void setIfctName(String ifctName) {
		this.ifctName = ifctName;
	}
	public String getIfctNameEng() {
		return ifctNameEng;
	}
	public void setIfctNameEng(String ifctNameEng) {
		this.ifctNameEng = ifctNameEng;
	}
	public Integer getIfctParents() {
		return ifctParents;
	}
	public void setIfctParents(Integer ifctParents) {
		this.ifctParents = ifctParents;
	}
	public Integer getIfctDepth() {
		return ifctDepth;
	}
	public void setIfctDepth(Integer ifctDepth) {
		this.ifctDepth = ifctDepth;
	}
	public Integer getIfctUseNy() {
		return ifctUseNy;
	}
	public void setIfctUseNy(Integer ifctUseNy) {
		this.ifctUseNy = ifctUseNy;
	}
	public Integer getIfctOrder() {
		return ifctOrder;
	}
	public void setIfctOrder(Integer ifctOrder) {
		this.ifctOrder = ifctOrder;
	}
	public String getIfctDesc() {
		return ifctDesc;
	}
	public void setIfctDesc(String ifctDesc) {
		this.ifctDesc = ifctDesc;
	}
	public Integer getIfctDelNy() {
		return ifctDelNy;
	}
	public void setIfctDelNy(Integer ifctDelNy) {
		this.ifctDelNy = ifctDelNy;
	}
	public static List<CategoryDto> getCachedCategoryArrayList() {
		return cachedCategoryArrayList;
	}
	public static void setCachedCategoryArrayList(List<CategoryDto> cachedCategoryArrayList) {
		CategoryDto.cachedCategoryArrayList = cachedCategoryArrayList;
	}

}
