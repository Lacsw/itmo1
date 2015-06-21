package com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.*;

import exc.FifthSecondException;

@SuppressWarnings("serial")
public class FifthSecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		String sStr = req.getParameter("inputNum1");
		try {
			DateFormatEquality(sStr);
			resp.getWriter().print("Это дата!");
		} catch (FifthSecondException e) {
			resp.getWriter().print(e);
		}
	}

	static void DateFormatEquality(String sStr) throws FifthSecondException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(sStr.trim());
		} catch (ParseException eDef) {
			FifthSecondException e = new FifthSecondException("Это не дата, попробуйте еще раз.");
			throw e;
		}
	}
}