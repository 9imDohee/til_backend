import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 간단한 이차원 배열로 사용자 데이터 정의
		String[][] users = { 
				{ "홍길동", "hong@email.com", "2023-01-15" },
				{ "김철수", "kim@email.com", "2023-02-20" },
				{ "한영희", "lee@email.com", "2023-03-10" }, 
				{ "박민수", "park@email.com", "2023-04-05" },
				{ "최수정", "choi@email.com", "2023-05-12" } 
		};

		// 출력 코드
		/*
		 * [servelet의 문제점] 
		 * 모든 HTML을 문자열로 작성해야 함
		 * HTML들여쓰기,자동완성 기능, 실수 파악 어려움
		 * -> 자바 코드안에 HTML 코드를 작성해야 함
		 * 
		 * => HTML 코드안에 자바 코드를 넣자! JSP!
		 * 
		 */
		out.println("<!DOCTYPE html>\n");
		out.println("<html>\n");
		out.println("<head>\n");
		out.println("    <title>사용자 목록</title>\n");
		out.println("    <style>\n");
		out.println("        body { font-family: Arial, sans-serif; margin: 40px; }\n");
		out.println("        table { border-collapse: collapse; width: 100%; }\n");
		out.println("        th, td { border: 1px solid #ddd; padding: 12px; text-align: left");
		out.println("        th { background-color: #f2f2f2; }\n");
		out.println("        .header { color: #333; margin-bottom: 20px; }\n");
		out.println("    </style>\n");
		out.println("</head>\n");
		out.println("<body>\n");
		out.println("    <h1 class='header'>사용자 관리 시스템</h1>\n");
		out.println("    <p>총" + users.length +"명의 사용자가 등록되어 있습니다.</p>\n");
		out.println("    <table>\n");
		out.println("        <tr>\n");
		out.println("            <th>번호</th>\n");
		out.println("            <th>이름</th>\n");
		out.println("            <th>이메일</th>\n");
		out.println("            <th>가입일</th>\n");
		out.println("        </tr>\n");
		out.println("        <tr>\n");


		for(int i=0; i<users.length; i++) {
			out.println("        <tr>\n");
			out.println("            <td>"+(i+1)+"</td>\n");
			out.println("            <td>"+users[i][0]+"</td>\n");
			out.println("            <td>"+users[i][1]+"</td>\n");
			out.println("            <td>"+users[i][2]+"</td>\n");
			out.println("        </tr>\n");
		}


		out.println("    </table>\n");
		out.println("    <div style='margin-top: 20px;'>\n");
		out.println("        <a href='/adduser'>새 사용자 추가</a>\n");
		out.println("    </div>\n");
		out.println("</body>\n");
		out.println("</html>");
	}
}
