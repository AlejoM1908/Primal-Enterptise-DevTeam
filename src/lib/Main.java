package lib;

import lib.app.DBConnection;

public class Main {
    public static void main(String[] args) {
        DBConnection dbconecction = new DBConnection();
        dbconecction.getConnection();
        dbconecction.endCOnnection();
    }
    
}
