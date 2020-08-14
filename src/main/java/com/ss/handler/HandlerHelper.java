package com.ss.handler;

import java.util.ResourceBundle;

public class HandlerHelper {

	private static ResourceBundle bundle;
	
	static {
		try {
			//locate configuration properties file
			bundle=ResourceBundle.getBundle("com/ss/commons/config");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//static
	
	@SuppressWarnings("deprecation")
	public static Handler getHandler(String uri)throws Exception{
		
		String handlerName=null;
		Handler handler=null;
		
		//get handler class name
		handlerName=bundle.getString(uri);
		//create handler class obj
		handler=(Handler)Class.forName(handlerName).newInstance();
		return handler;
	}
}
