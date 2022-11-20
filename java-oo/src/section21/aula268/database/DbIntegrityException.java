package section21.aula268.database;

import java.io.IOException;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DbIntegrityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DbIntegrityException (String msg){
        super(msg);
    }
}