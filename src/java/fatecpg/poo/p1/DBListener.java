/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatecpg.poo.p1;

import java.sql.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Vinic
 */
public class DBListener implements ServletContextListener {
    private static final String CLASS_NAME = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:p2vinicius.db";
    
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DB_URL);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection con = null;
        Statement stmt = null;
        
        try{
            Class.forName(CLASS_NAME);
            con = getConnection();
            stmt = con.createStatement();
            stmt.execute(Disciplina.getCreateStatement());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
