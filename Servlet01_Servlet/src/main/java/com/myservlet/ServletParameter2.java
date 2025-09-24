package com.myservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletParameter2")
public class ServletParameter2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. 단일 값 파라미터 받기 (input, select, textarea 등)
        String text = request.getParameter("text");
        String campus = request.getParameter("campus");
        String programmingLanguage = request.getParameter("programming-language");
        String content = request.getParameter("content");
        String hidden = request.getParameter("action");
        
        // 2. 숫자로 된 파라미터는 타입 변환이 필요
        int num = Integer.parseInt(request.getParameter("number"));
        
        // 3. 여러 개의 값을 가진 파라미터 받기 (checkbox 등)
        String[] fruits = request.getParameterValues("fruit");

        System.out.println("Text: " + text);
        System.out.println("Number: " + num);
        System.out.println("Campus: " + campus);
        
        // 배열이므로 반복문으로 출력
        if (fruits != null) {
            for (String fruit : fruits) {
                System.out.println("Fruit: " + fruit);
            }
        }
        
        System.out.println("Language: " + programmingLanguage);
        System.out.println("Content: " + content);
        System.out.println("Hidden: " + hidden);
    }
}