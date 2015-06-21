package com;

import java.io.IOException;

import javax.servlet.http.*;

import exc.FifthFourthException;

@SuppressWarnings("serial")
public class FifthFourthServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		String sSubStr=req.getParameter("inputNum1");
		String sStr="Just a simple string of 7 words.";
		try {
			substringEqualCheck(sStr, sSubStr);
			resp.getWriter().print("Присутствует.");
		} catch (FifthFourthException e) {
			resp.getWriter().print(e);
		}
	}

	static void substringEqualCheck(String sStr1, String sStr2)
			throws FifthFourthException {
		if (!(sStr1.contains(sStr2))) {
			FifthFourthException e = new FifthFourthException("Не присутсвует.");
			throw e;
		}
	}
}