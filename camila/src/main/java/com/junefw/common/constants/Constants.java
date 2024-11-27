package com.junefw.common.constants;

public final class Constants {

//	common
	public static final String PROJECT_NAME = "camila";
	
	public static final String ABBREVIATION_ADMIN = "Xdm"; 
	public static final String ABBREVIATION_USER = "Usr";
	
//	for paging
	public static final int ROW_NUM_TO_SHOW = 5;
	public static final int PAGE_NUM_TO_SHOW = 5;

// insert 또는 update 후 페이지 전환 타입: 1:form, 2:list	
	public static final int INSERT_AFTER_TYPE = 1;		
	public static final int UPDATE_AFTER_TYPE = 1;		
	
	public static final int SESSION_MINUTE_XDM = 30;
	
	public static final String URL_LOGINXDMFORM = "/v1/infra/member/signinXdmForm";
	
	public static final String DATETIME_FORMAT_BASIC = "yyyy-MM-dd HH:mm:ss";

	public static final String TIME_FORMAT_BASIC = "HH:mm:ss";
	
	public static final int DATE_INTERVAL = -30;
	
	public static final long PASSWOPRD_CHANGE_INTERVAL = 90;
	
	public static final String UPLOADED_PATH_PREFIX_LOCAL = "D:/factory/ws_sts4_4180/repo_camila_uploaded";
	public static final String UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL = "/uploaded";
	
	public static final String UPLOADED_RESSOURCE_HANDLER = "/uploaded/**";
	public static final String UPLOADED_RESSOURCE_LOCATIONS = "file:///D:/factory/ws_sts4_4180/repo_camila_uploaded/";
	
	public static final String UPLOADED_PATH_PREFIX_S3 = "D:/factory/ws_sts4_4180/repo_camila_uploaded";
	public static final String UPLOADED_PATH_PREFIX_FOR_VIEW_S3 = "/uploaded";
	
	public static final int COOKIE_MAXAGE_XDM = 60 * 60 * 24 * 30;	//초 * 분 * 시간 * 일 : 30day
	public static final String COOKIE_DOMAIN_XDM = "";
	public static final String COOKIE_PATH_XDM = "/";
	public static final String COOKIE_SEQ_NAME_XDM = "cookieSeqXdm";
	
	public static final String versionUiMain = "v1";
	
	public static final String SESSION_SEQ_NAME_XDM = "sessSeqXdm";
	
	
//	usr
	
	public static final int SESSION_MINUTE_USR = 30;
	
	public static final long PASSWOPRD_CHANGE_INTERVAL_USR = 90;
	
	public static final int COOKIE_MAXAGE_USR = 60 * 60 * 24 * 30;	//초 * 분 * 시간 * 일 : 30day
	public static final String COOKIE_DOMAIN_USR = "";
	public static final String COOKIE_PATH_USR = "/";
	public static final String COOKIE_SEQ_NAME_USR = "cookieSeqUsr";
	
	public static final String SESSION_SEQ_NAME_USR = "sessSeqUsr";
	
	public static final String SESSION_LOGIN_CAPTCHA_USR = "sessLoginCaptchaUsr";
	
	public static final String URL_LOGINUSRFORM = "/v1/infra/member/signinUsrForm";
	
}
