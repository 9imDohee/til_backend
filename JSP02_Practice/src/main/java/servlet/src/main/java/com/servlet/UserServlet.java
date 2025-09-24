package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.dto.Person;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 유저 목록 조회: /user?act=getList
 * 회원 등록: /user?act=regist
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	// DB대신 사용하는 임시 저장소
	List<Person> memory = new ArrayList<>();// ArrayList는 메모리 위에서만 동작하므로, 톰캣 서버를 껐다가 켜면 저장했던 모든 회원정보가 사라짐
	
	
//	@Override
//		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			doProcess(req, resp);
//		}
//	@Override
//		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			//회원가입 요청이 왔다!
//			doProcess(req, resp);
//		}
//	private void doProcess(HttpServletRequest req, HttpServletResponse resp) {
//		String act = req.getParameter("act");
//		//act : 등록, 조회, 수정, 삭제, ....
//	}

	// 프론트 컨트롤러 패턴: 하나의 서블릿이 컨트롤 타워처럼 여러 요청을 받아서 내부적으로 처리하는 방식
	// doGet(), doPost() 대신 service() 메소드를 사용해서 모든 요청을 한 곳에서 처리
	// 모든 요청을 받고, 요청을 분석한 후, 실제 업무를 처리하는 별도의 자바 클래스 (핸들러, 커맨드 객체 등)에 일음 넘김
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		// act 파라미터로 기능 구분
		String act = request.getParameter("act");
		
		switch (act) { // 기능 분기
		case "regist":
			doRegist(request, response);
			break;
			
		case "getlist":
			doList(request, response);
			break;

		}

	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>회원정보</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h2>회원 목록</h2>");
		writer.append("<ul>");
		if(memory.size()>0) {
			for(int i = 0; i<memory.size(); i++) {
				writer.append("<li>");
				writer.append(memory.get(i).getName());
				writer.append("</li>");
			}
		}else {
			writer.append("<li>등록된 사람이 없다 (한명도)</li>");
		}
		writer.append("</ul>");
		writer.append("</body>");
		writer.append("</html>");
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 회원 정보를 꺼내기
		// getParameter에는 key 값이 들어온다. (name이라는 속성값)
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");

		Person p = new Person(name, age, gender, hobbies);

		PrintWriter writer = response.getWriter();

		memory.add(p);
		
		writer.append("<html>");
		writer.append("<head>");
		writer.append("<title>등록정보</title>");
		writer.append("</head>");
		writer.append("<body>");
		writer.append("<h2>등록된 사람 정보</h2>");
		writer.append(p.toString());
		writer.append("</body>");
		writer.append("</html>");

	}
}
