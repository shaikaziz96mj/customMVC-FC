package com.ss.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.dispatcher.Dispatcher;
import com.ss.handler.Handler;
import com.ss.handler.HandlerHelper;

public class CustomControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2682037482186282782L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Handler handler = null;
		String lvn = null;

		// Action Management
		try {
			handler = HandlerHelper.getHandler(req.getServletPath());
			lvn = handler.execute(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// view management
		try {
			Dispatcher.render(lvn, req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}// class