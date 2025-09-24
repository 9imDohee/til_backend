// 클라이언트가 보낸 데이터를 서버에서 받는 방법
package com.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


 // ServeletParameter?text=안녕하세요
 
@WebServlet("/ServeletParameter")
public class ServletParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// doGet / doPost 방식으로 들어온 요청에서 text라는 이름을 가진 파라미터를 찾아 콘솔에 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String text= req.getParameter("text");
		System.out.println(text);
	} 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String text= req.getParameter("text");
		System.out.println(text);
	}

}
