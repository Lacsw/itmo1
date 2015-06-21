package com;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.http.*;

import claz.ClazzCoff;

@SuppressWarnings("serial")
public class ClazzServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html; charset=cp1251");
		ClazzCoff cappuccino = new ClazzCoff();
		cappuccino.setName("Капуччино");
		cappuccino.setCost(275.0);
		cappuccino.setVolume(350.0);
		ClazzCoff latte = new ClazzCoff();
		latte.setName("Латте");
		latte.setCost(255.0);
		latte.setVolume(300.0);
		ClazzCoff espresso = new ClazzCoff();
		espresso.setName("Эспрессо");
		espresso.setCost(159.0);
		espresso.setVolume(60.0);
		ClazzCoff icecoffee = new ClazzCoff();
		icecoffee.setName("Глясе");
		icecoffee.setCost(225.0);
		icecoffee.setVolume(230.0);
		ClazzCoff mocco = new ClazzCoff();
		mocco.setName("Мокко");
		mocco.setCost(260.0);
		mocco.setVolume(275.0);

		double dMin = Double.parseDouble(req.getParameter("inputNum1"));
		double dMax = Double.parseDouble(req.getParameter("inputNum2"));
		ClazzCoff[] coffeeList = new ClazzCoff[] { cappuccino, latte, espresso, icecoffee, mocco };
		resp.getWriter().print("<table>");
		resp.getWriter().print("<tr>");
		resp.getWriter().print(
				"<th>Наименование</th><th>Стоимость</th><th>Объем</th>");
		resp.getWriter().print("</tr>");
		for (int i = 0; i < coffeeList.length; i++) {
			resp.getWriter().print("<tr>");
			for (Field field : coffeeList[i].getClass().getDeclaredFields()) {
				try {
					if (coffeeList[i].getCost() > dMin && coffeeList[i].getCost() < dMax) {
						resp.getWriter().print(
								"<td>" + field.get(coffeeList[i]) + "</td>");
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			resp.getWriter().print("</tr>");
		}
		resp.getWriter().print("</table>");
	}
}