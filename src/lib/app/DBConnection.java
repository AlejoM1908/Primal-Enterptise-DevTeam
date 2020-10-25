package lib.app;

//JDBC imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
    //DB connection variables
    private String DBName = "PrimalEnterpriceDB";
    private String user = "root";
    private String password = "2R597%V%vM";
    private String url = "jdbc:mysql://localhost:3306/"+DBName+"?useUnicode=true&use"+
        "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private Connection conn = null;

    //DB connection definition
    public DBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //get connection
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null){
                System.out.println("Conexión exitosa con la DB: " + DBName);
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Ha ocurrido una ClassNotFoundException: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Ha ocurrido una SQLExeption: " + e.getMessage());
        }
    }

    //DB Connection getter
    public Connection getConnection(){
        return conn;
    }

    //End DB Connection
    public void endCOnnection(){
        if (conn == null){
            System.out.println("No hay ninguna conexión establecida con: " + DBName);
            return;
        }

        conn = null;
        System.out.println("La conexión ha sido terminada con: " + DBName);
    }
}