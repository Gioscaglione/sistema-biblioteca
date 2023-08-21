package br.com.biblioteca.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=db_Biblioteca;user=sa;password=TecInfo;" + 
            									"encrypt=true;trustServerCertificate=true");
            
            
        }catch(SQLException e){
        	
           System.out.println(e.getMessage());
        }
        return con;
        
    }
    
}