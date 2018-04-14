package com.senac.pi.floricultura.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://senacpi3.mysql.dbaas.com.br/senacpi3?useSSL=false";
    private static final String USER = "senacpi3";
    private static final String PASS = "TADS1801@pi3";
//    private static final String USER = "root";
//    private static final String PASS = "rom08_01";
    
//by Andre, é a senha do meu server
//    private static final String PASS = "admin";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro De Conexão!");
        }
    }

    public static void closeConnection(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeConnection(Connection cn, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        closeConnection(cn);
    }

    public static void closeConnection(Connection cn, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        closeConnection(cn, stmt);
    }
}
