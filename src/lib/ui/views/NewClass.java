package lib.ui.views;

//Proyect imports
import lib.app.DBConnection;

//JDBC imports
import java.sql.ResultSet;

public class NewClass {
    DBConnection conn = new DBConnection();
    ResultSet result = null;

    private void connect(){
        String query = "call userList('None','None')";

        try{
            conn.getConnection();
            result = conn.executeQuery(query);
            conn.endCOnnection();

            while(result.next()){
                String name = result.getString("nombre");
                System.out.println(name);
            }
        }
        catch(Exception e){
            System.out.println("Ha ocurrido un problema" + e.getClass());
        }
    }

    public static void main(String[] args) {
        NewClass test = new NewClass();
        test.connect();
    }
}
