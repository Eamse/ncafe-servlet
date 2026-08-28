package com.newlecture.controller.admin.menus;

import java.io.IOException;
import java.util.List;
import com.newlecture.entity.Menu;
import com.newlecture.repository.JdbcMenuRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/menus/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JdbcMenuRepository repository = new JdbcMenuRepository();
        List<Menu> list = repository.findAll();

        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/menus/list.jsp");
        dispatcher.forward(req, resp);
    }
}