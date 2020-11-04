package lib.app;

//JDBC imports
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection{
    //DB connection variables
    private String DBName = "PrimalEnterpriceDB";
    private String user = "root";
    private String password = "4550Niki!";

    private String url = "jdbc:mysql://localhost:3306/"+DBName+"?useUnicode=true&use"+
        "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private Connection conn = null;
    private Statement stat = null;

    //DB Connection getter
    public void getConnection(){
        if (conn != null){
            System.out.println("La conexión ya ha sido establecida");
            return;
        }

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //get connection
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null){
                System.out.println("Conexión exitosa con la DB: " + DBName);
                stat = conn.createStatement();
            }
        }
        catch(ClassNotFoundException e){
            System.out.println("Ha ocurrido una ClassNotFoundException: " + e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Ha ocurrido una SQLExeption: " + e.getMessage());
        }
    }

    //Executing a Query in DB connection
    public ResultSet executeQuery(String query){
        if (stat == null){
            System.out.println("La conexión no ha sido establecida");
            return null;
        }

        try{
            ResultSet result = stat.executeQuery(query);
            return result;
        }
        catch(SQLException e){
            System.out.println("Ha ocurrido una SQLExeption: " + e.getMessage());
            return null;
        }
    }

    //End DB Connection
    public void endCOnnection(){
        if (conn == null){
            System.out.println("No hay ninguna conexión establecida con: " + DBName);
            return;
        }

        conn = null;
        stat = null;
        System.out.println("La conexión ha sido terminada con: " + DBName);
    }
}
