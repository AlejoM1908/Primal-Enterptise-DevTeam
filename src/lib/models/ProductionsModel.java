//Java imports
package lib.models;

import java.util.LinkedList;

public class ProductionsModel {
    private final int id;
    private final String user;
    private final String state;
    private final String startingDate;
    private final String finishingDate;
    private final String type;
    private final LinkedList<Product> products;

    public ProductionsModel(int id, String user, String state, String startingDate, 
            String finishingDate, String type, LinkedList<Product> products) {
        this.id = id;
        this.user = user;
        this.state = state;
        this.startingDate = startingDate;
        this.finishingDate = finishingDate;
        this.type = type;
        this.products = products;
    }
    
    public int getId() {return this.id;}
    public String getUser() {return this.user;}
    public String getState() {return this.state;}
    public String getStartingDate() {return this.startingDate;}
    public String getFinishingDate() {return this.finishingDate;}
    public String getType() {return this.type;}
    public LinkedList<Product> getProducts() {return this.products;}
}
