
package com.mycompany.proyecto2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proyecto2 {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String usuario = "root";
        String password = "";
        String url ="jdbc:mysql://localhost:3306/java1";
        Connection conexion;
        ResultSet rs;
        Statement statement; 
         try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id") + " usuario:" + rs.getString("usuario"));
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Proyecto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
