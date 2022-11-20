package section21.aula268.database;

import java.io.IOException;
import java.io.FileInputStream;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Properties;


public class DB {

    private static Connection conn = null;

    public static Connection getConnection(){

        if (conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url);  
                System.setProperty("derby.language.sequence.preallocator", "1");              
            }catch(SQLException e) {
                throw new DbException(e.getMessage());
            }
        }

        return conn;
    }

    public static Properties loadProperties(){

        //TODO: review FileInputStream
        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            // TODO: review Properties
            props.load(fs);
            return props;

        } catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if (conn != null){
            try {
                conn.close();
            } catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st){

        if (st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }    
}