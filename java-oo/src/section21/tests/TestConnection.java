package section21.tests;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager
            .getConnection("jdbc:derby:/home/luciano/workspace/cursos/curso-de-java/java-oo/db/db;create=true");
		System.out.println("Connected To Derby Database!");
		con.close();
	}
}