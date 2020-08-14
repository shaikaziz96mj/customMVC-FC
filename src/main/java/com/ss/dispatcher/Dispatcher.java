package com.ss.dispatcher;

import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dispatcher {

	private static ResourceBundle bundle;

	static {
		try {
			// locate configuration properties file
			bundle = ResourceBundle.getBundle("com/ss/commons/config");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// static

	public static void render(String lvn, HttpServletRequest req, HttpServletResponse res) throws Exception {

		String physicalView = null;
		RequestDispatcher rd = null;

		// get phy view name based on the given logical view name(lvn)
		physicalView = bundle.getString(lvn);
		// forward to phy view
		rd = req.getRequestDispatcher(physicalView);
		rd.forward(req, res);
	}
}