package com.newlecture.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.entity.Menu;
import com.newlecture.util.Env;

public class JdbcMenuRepository {
    private static final String URL = Env.get("NCAFE_DB_URL");
    private static final String UID = Env.get("NCAFE_DB_USERNAME");
    private static final String PWD = Env.get("NCAFE_DB_PASSWORD");

    public List<Menu> findAll() {
        String sql = "SELECT id, kor_name, eng_name, img_src, description, price, category_id, create_time "
                   + "FROM menus ORDER BY id";
        List<Menu> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, UID, PWD);
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Menu menu = new Menu(
                        rs.getInt("id"),
                        rs.getString("kor_name"),
                        rs.getString("eng_name"),
                        rs.getString("img_src"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("category_id"),
                        rs.getTimestamp("create_time"));
                list.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

       // 기존 코드 하단에 save 메서드 추가
    public int save(Menu menu) {
        String sql = "INSERT INTO menus (kor_name, eng_name, img_src, description, price, category_id) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        int result = 0;

        try (Connection conn = DriverManager.getConnection(URL, UID, PWD);
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, menu.getKorName());
            pst.setString(2, menu.getEngName());
            pst.setString(3, menu.getImgSrc());
            pst.setString(4, menu.getDescription());
            pst.setInt(5, menu.getPrice());
            pst.setInt(6, menu.getCategoryId());

            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
