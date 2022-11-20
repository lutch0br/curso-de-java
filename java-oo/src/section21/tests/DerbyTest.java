package section20.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DerbyTest {
    // private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public DerbyTest() throws Exception {
        try (Connection connect = DriverManager
                    .getConnection("jdbc:derby://localhost//home/luciano/workspace/cursos/curso-de-java/java-oo/db;create=true");
){

            // Class.getDeclaredConstructor("org.apache.derby.jdbc.ClientDriver").newInstance();
            PreparedStatement statement = connect
                    .prepareStatement("SELECT * from USERS");

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String user = resultSet.getString("name");
                String number = resultSet.getString("number");
                System.out.println("User: " + user);
                System.out.println("ID: " + number);
            }
            connect.close();
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println();
        }

    }

    // private void close() {
    //     try {
    //         if (resultSet != null) {
    //             resultSet.close();
    //         }
    //         if (statement != null) {
    //             statement.close();
    //         }
    //         if (connect != null) {
    //             connect.close();
    //         }
    //     } catch (Exception e) {

    //     }
    // }

    public static void main(String[] args) throws Exception {
        DerbyTest dao = new DerbyTest();
    }

}