package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecurityManager {

    public boolean getAllUsersList(String username,String password) throws Exception {
        boolean st =false;
        try {           
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Kumar@94");
            PreparedStatement ps =connection.prepareStatement("select * from login where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
        } catch (Exception e) {
            throw e;
        }
        return st;
    }

}
