//Java imports
package lib.ui.SingleProduction;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import lib.app.DBConnection;
import lib.models.ProductionsModel;
import lib.ui.MainApp.MainAppController;

public class SingleProductionModel {
    private SingleProductionView view;
    private MainAppController rootComponent;
    private DBConnection conn = new DBConnection();
    private ProductionsModel productionModel;
    private String[] yearsList, monthsList, daysList, typesList;
    private int id;

    public SingleProductionModel(SingleProductionView singleProductionView) {
        this.view = singleProductionView;
    }
    
    public void setRootComponent(MainAppController rootComponent){
        this.rootComponent = rootComponent;
        
        initialize();
    }
    
    public void setId(int id){
        this.id = id;
        getInfo();
        initialize();
        setTypes();
        
        this.view.setProductionModel(this.productionModel);
        this.view.setTypes(typesList);
    }
    
    private void initialize(){
        String maxYear = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));
        int amount = Integer.parseInt(maxYear) - 1990 + 11;
        
        yearsList = new String[amount];
        
        for (int i=0; i<amount; i++){
            yearsList[i] = "" + (1990 + i);
        }
        
        this.monthsList = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        
        daysList = new String[31];
        
        for (int i=0; i<31; i++){
            daysList[i] = "" + (i+1);
        }
    }
    
    private void getInfo(){
        conn.getConnection();
        
        try{
            ResultSet result = conn.executeQuery("select * from vw_getProductions");

            if (result.next()){
                String user = result.getString("usuario");
                String state = result.getString("estado");
                String startingDate = result.getString("fecha_comienzo");
                String finishingDate = result.getString("fecha_finalizacion");
                String type = result.getString("tipo");
                
                this.productionModel = new ProductionsModel(this.id, user, state, startingDate, finishingDate, type, null);
            }
        }
        catch(Exception e){
            
        }
    }
    
    private void setTypes(){
        conn.getConnection();
        ArrayList<String> types = new ArrayList<>();
        types.add("");
        
        try{
            ResultSet result = conn.executeQuery("select * from vw_productionsType");
            
            while(result.next()){
                String type = result.getString("tipo");
                
                types.add(type);
            }
            
            typesList = new String[types.size()];
            
            for (int i=0; i<typesList.length; i++){
                typesList[i] = types.get(i);
            }
        }
        catch(Exception e){
            
        }
    }
    
    public void updateInfo(){
        conn.getConnection();
        
        try{
            String id = this.view.getIdText().getText();
            String state = this.view.getStateText().getText();
            String type = (String) this.view.getTypeComboBox().getSelectedItem();
            String startingDate = this.view.getStatringDate().getText();
            String finishingDate = this.view.getFinishingDate().getText();
            
            if (id.isEmpty() || state.isEmpty() || type.isEmpty() || startingDate.isEmpty() || finishingDate.isEmpty())
                this.view.showErrorMessage();
            
            String query = "call update_production(" + id + ",\"" + state + "\","
                    + "\"" + type + "\",\"" + startingDate + "\",\"" + finishingDate + "\");";
            conn.executeQuery(query);
            
            System.out.println(query);
        }
        catch(Exception e){
            
        }
        
        conn.endCOnnection();
    }
    
    public MainAppController getRootComponent() {return this.rootComponent;}
    public ProductionsModel getProductionModel() {return this.productionModel;}
    public String[] getYears() {return this.yearsList;}
    public String[] getMonths() {return this.monthsList;}
    public String[] getDays() {return this.daysList;}
    public int getId() {return this.id;}
}
