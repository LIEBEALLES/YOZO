package com.yozo.goods.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yozo.goods.biz.GoodsBiz;
import com.yozo.goods.dto.GoodsDto;

/**
 * Servlet implementation class GoodsController
 */
@WebServlet("/goods.do")
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public GoodsController() {
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		GoodsBiz biz = new GoodsBiz();
		
		//굿즈 상품 등독
		if(command.equals("goodsinsertres")) {
			System.out.println("goodsinsertres왔음");
			String goods_title = request.getParameter("goods_title");
			int goods_quantity = Integer.parseInt(request.getParameter("goods_quantity"));
			int goods_price = Integer.parseInt(request.getParameter("goods_price"));
			String goods_content = request.getParameter("goods_content");
			String goods_main_photo=request.getParameter("goods_main_photo");
			int res=0;
			System.out.println(goods_content);
			
			
			 res = biz.insert(new GoodsDto(1,"session값",goods_title,goods_main_photo,goods_price,goods_quantity,"사진", goods_content,null));
			 
			 if(res>0) {
				 dispatch("goods_list.jsp", request, response);
			 }else {
				 jsResponse("작성 실패","유정쓰가만든 goods_insertform", response);
			 }
			 
			 

		}else if(command.equals("goodsinsertform")) {
			response.sendRedirect(request.getContextPath()+"/view/goods/goods_insert.jsp");
		}else if(command.equals("goodslist")) {
			response.sendRedirect(request.getContextPath()+"/view/goods/goods_list.jsp");
		}
		
		
	}
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
		
	}
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String s = "<script type='text/javascript'>" +
					"alert('"+msg+"');" +
					"location.href='" + url + "';" +
					"</script>";
		response.getWriter().append(s);
	}
	
	

}
