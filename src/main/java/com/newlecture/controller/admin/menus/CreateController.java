package com.newlecture.controller.admin.menus;

import java.io.IOException;
import com.newlecture.entity.Menu;
import com.newlecture.repository.JdbcMenuRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/menus/create")
public class CreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/menus/create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 1. 요청 파라미터 수신 (JSP form의 name 속성 매핑)
        String korName = req.getParameter("kor-name");
        String engName = req.getParameter("eng-name");
        String imgSrc = req.getParameter("img-src");
        String description = req.getParameter("description");
        
        String priceStr = req.getParameter("price");
        Integer price = (priceStr != null && !priceStr.isBlank()) ? Integer.parseInt(priceStr) : 0;

        String categoryIdStr = req.getParameter("category-id");
        Integer categoryId = (categoryIdStr != null && !categoryIdStr.isBlank()) ? Integer.parseInt(categoryIdStr) : null;

        // 2. Menu 객체 생성
        Menu menu = new Menu(korName, engName, imgSrc, description, price, categoryId);

        // 3. Repository를 통한 데이터 저장
        JdbcMenuRepository repository = new JdbcMenuRepository();
        repository.save(menu);

        // 4. 저장 완료 후 목록 페이지로 리다이렉트 (PRG 패턴)
        resp.sendRedirect("/admin/menus/list");
    }
}