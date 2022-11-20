package section21.aula268.app;

import java.util.Locale;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.javafaker.Faker;
import section21.aula268.db.DB;
import util.Screen;


public class Program {
    static final Faker faker = new Faker();
     
    public static void main(String...args){
        Locale.setDefault(Locale.US);
        Screen.clear();

        try(Connection conn = DB.getConnection()){                 
            queryDepartment(conn);
            System.out.println("----------");
            querySeller(conn);
            System.out.println("----------");
            for (int i = 0; i < 3; i++)
                insertSellerWithGeneratedKeys(conn);
            System.out.println("----------");
            queryDepartment(conn);
            System.out.println("----------");
            querySeller(conn);    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void queryDepartment(Connection conn){
        
        Statement st = null;
        ResultSet rs = null;

        try {            
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM DEPARTMENT");

            while (rs.next()){
                System.out.printf("%s, %s\n", rs.getInt("ID"), rs.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    static void querySeller(Connection conn){        
        Statement st = null;
        ResultSet rs = null;

        try {            
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM SELLER");

            while (rs.next()){
                System.out.printf(
                    "%s, %s, %s, %s, %.2f, %d\n", 
                    rs.getInt("ID"), rs.getString("NAME"), rs.getString("EMAIL"),
                    rs.getDate("BIRTHDATE"), rs.getDouble("BASESALARY"),
                    rs.getInt("DEPARTMENTID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);            
        }
    }    

    static void insertSeller(Connection conn){        
        PreparedStatement st = null;

        try {            
            st = conn.prepareStatement(
                "INSERT INTO SELLER "
                + "(NAME, EMAIL, BIRTHDATE, BASESALARY, DEPARTMENTID) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)");

            st.setString(1, faker.name().firstName());
            st.setString(2, faker.internet().emailAddress());
            st.setDate(3, new java.sql.Date(faker.date().birthday(18, 70).getTime()));
            st.setDouble(4, faker.number().randomDouble(2, 1000, 10000));
            st.setInt(5, faker.number().numberBetween(1, 5));

            int rowsAffected = st.executeUpdate();

            System.out.printf("Done: %s rows affected.\n", rowsAffected);

        }catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);            
        }
    }

    static void insertSellerWithGeneratedKeys(Connection conn){        
        PreparedStatement st = null;
        ResultSet rs = null;

        try {            
            st = conn.prepareStatement(
                "INSERT INTO SELLER "
                + "(NAME, EMAIL, BIRTHDATE, BASESALARY, DEPARTMENTID) "
                + "VALUES "
                + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);


            st.setString(1, faker.name().firstName());
            st.setString(2, faker.internet().emailAddress());
            st.setDate(3, new java.sql.Date(faker.date().birthday(18, 70).getTime()));
            st.setDouble(4, faker.number().randomDouble(2, 1000, 10000));
            st.setInt(5, faker.number().numberBetween(1, 5));

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                rs = st.getGeneratedKeys();

                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.printf("Done: Id %d.\n", id);
                }
            } else {
                System.out.printf("no rows affected.\n");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);           
        }
    }    
}