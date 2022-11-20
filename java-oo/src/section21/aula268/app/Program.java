package section21.aula268.app;

import java.util.Locale;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import section21.aula268.db.DB;
import util.Screen;


public class Program {

    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Screen.clear();

        Connection conn = null;        
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM DEPARTMENT");

            while (rs.next()){
                System.out.printf("ID: %s, Name: %s\n", rs.getInt("ID"), rs.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection(conn);
        }
    }
}