package com;

import java.io.IOException;

import javax.servlet.http.*;

import exc.FifthFirstException;

@SuppressWarnings("serial")
public class FifthFirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		String sStr = req.getParameter("inputNum1");
		try {
			NumberFormatEquality(sStr);
			resp.getWriter().print("Это число!");
		} catch (FifthFirstException exc) {
			resp.getWriter().print(exc);
		}
	}

	static void NumberFormatEquality(String sStr) throws FifthFirstException {
		try {
			double dStr = Double.parseDouble(sStr);
		} catch (NumberFormatException eDef) {
			FifthFirstException e = new FifthFirstException("Это не число, попробуйте еще раз");
			throw e;
		}
	}
}