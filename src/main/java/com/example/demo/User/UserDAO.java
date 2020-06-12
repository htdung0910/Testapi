package com.example.demo.User;

import java.sql.*;

public class UserDAO {
    public static Connection makeConnection() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://htd0910.ddns.net;databaseName=BookApp_Manager";
            con = DriverManager.getConnection(url, "htd0910", "123456");
        }  catch (ClassNotFoundException | SQLException e)   {
            e.printStackTrace();
        }


        return con;
    }

    public User checkLogin(String username, String password) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM [dbo].[User] Where [username] = ? AND [password] = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()){
                    return new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(rs != null){
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

}
