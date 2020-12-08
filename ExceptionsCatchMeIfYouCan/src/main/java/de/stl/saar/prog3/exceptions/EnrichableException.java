package de.stl.saar.prog3.exceptions;

import java.util.ArrayList;
import java.util.List;

public class EnrichableException extends RuntimeException {
    public static final long serialVersionUID = -1;

    private List<ErrorInfo> infoItems =
            new ArrayList<ErrorInfo>();

    public EnrichableException(String errorContext, String errorCode,
            String errorMessage, String i18nKey){

    	addInfo(errorContext, errorCode, errorMessage, i18nKey);
	}
	
	public EnrichableException(String errorContext, String errorCode,
	            String errorMessage, String i18nKey, Throwable cause){
		super(cause);
		addInfo(errorContext, errorCode, errorMessage, i18nKey);
	}
	
	public EnrichableException addInfo(
		String errorContext, String errorCode, String errorText, String i18nKey){
		
		this.infoItems.add(
		new ErrorInfo(errorContext, errorCode, errorText, i18nKey));
		return this;
	}
	
	public class ErrorInfo {
	    private final String errorContext;
	    private final String errorCode;
	    private final String errorText;
	    private final String i18nKey;
	    
	    private ErrorInfo(String contextCode, 
	    				  String errorCode,
	                      String errorText,
	                      String i18nKey){
	
	        this.errorContext = contextCode;
	        this.errorCode = errorCode;
	        this.errorText = errorText;
	        this.i18nKey = i18nKey;
	    }
    }  
}
