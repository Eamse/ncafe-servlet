package com.newlecture.controller.admin.menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.newlecture.entity.Menu;
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
    List<Menu> list = new ArrayList<>();
    list.add(new Menu(1, "에스프레소", "Espresso", null, null, 3800, 1));
    list.add(new Menu(2, "아메리카노", "Americano", null, null, 4500, 1));
    list.add(new Menu(3, "카페라떼", "Cafe Latte", null, null, 5000, 1));
    list.add(new Menu(4, "케이크", "Cake", null, "디쟈쓰", 6000, 2   ));
    list.add(new Menu(5, "참이슬 후레쉬", "Soju", null, "크", 5000, 3));
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/menus/list.jsp");
        dispatcher.forward(req, resp);
        // 이 부분도 이전해 했던 코드를 이용해서 여러분들이 마무리 해주세요
        // 여러분들이 JdbcMenuRepository, ListController, jsp를 모두 연동해주세요
        // 앞으로 배우는 html 페이지는 서블릿으로 반영해서 항상 배포해주셔야해요.
        // 배포 방법은 곧? 내일? 이어서 자료가 나갑니다.

    }
}