package com;

import java.io.IOException;

import javax.servlet.http.*;

import exc.FifthThirdException;

@SuppressWarnings("serial")
public class FifthThirdServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		String sAnswer="qwerty";
		String sGuess=req.getParameter("inputNum1");
		try {
			strEqualCheck(sGuess,sAnswer);
			resp.getWriter().print("Это строка!");
		} catch (FifthThirdException e) {
			resp.getWriter().print(e);
		}
	}

	static void strEqualCheck(String sStr1, String sStr2) throws FifthThirdException {
		if (!(sStr1.equals(sStr2))) {
			FifthThirdException e = new FifthThirdException(
					"Это не строка, попробуйте еще раз.");
			throw e;
		}
	}
}