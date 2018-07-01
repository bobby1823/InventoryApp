package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.ModifyProductService;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/Modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = session.getAttribute("userName").toString();
		
		//Fetch product data from UI
		int productId = Integer.valueOf(request.getParameter("productId"));
		int storeId = Integer.valueOf(request.getParameter("storeId"));
		int deptId = Integer.valueOf(request.getParameter("deptId"));
		String productName = (request.getParameter("productName"));
		String vendor = request.getParameter("vendor");
		double mrp = Double.parseDouble(request.getParameter("mrp"));
		String batchNum = request.getParameter("batchNumber");
		Date batchDate = null;
		try {
			String[] date = request.getParameter("batchDate").split("-");
			String year = date[0];
			String month = date[1];
			String day = date[2];
			batchDate = new SimpleDateFormat("dd/MM/yy").parse(day+"/"+month+"/"+year);
			System.out.println("Date: "+batchNum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		
		ModifyProductService modify = new ModifyProductService();
		modify.modifyProduct(userName, productId, storeId, deptId, productName, vendor, mrp, batchNum, batchDate, quantity);
	}

}
