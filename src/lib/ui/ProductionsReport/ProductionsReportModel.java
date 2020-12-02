/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.ProductionsReport;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.app.DBConnection;
import lib.ui.MainApp.MainAppController;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author user
 */
public class ProductionsReportModel {
    private ProductionsReportView view;
    
    private MainAppController rootComponent;

    public ProductionsReportModel(ProductionsReportView view) {
        this.view = view;
    }
    
    public void generateGraphic(String graphicType, String filter){
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = null;
        if(graphicType.equals("torta") && filter.equals("estado")){//Por estado
            result = conn.executeQuery("SELECT prd_estado, COUNT(prd_estado) cantidad FROM producciones GROUP BY prd_estado;");
        }else if(graphicType.equals("torta") && filter.equals("tipo")){//Por tipo
            result = conn.executeQuery("SELECT prd_tipo, COUNT(prd_tipo) cantidad FROM producciones GROUP BY prd_tipo;");
        }else if(graphicType.equals("barras") && filter.equals("cantidad")) {//Por cantidad de insumos
            result = conn.executeQuery("SELECT prp_produccion_id, COUNT(prp_producto_id) cantidad FROM produccion_producto GROUP BY prp_produccion_id;");
        }
        conn.endCOnnection();
        
        JFreeChart chart;
        if(graphicType.equals("torta")){//Por estado o tipo(PieChart)
            DefaultPieDataset set = new DefaultPieDataset();
            try {
                while(result.next()){
                    set.setValue(result.getString(1), result.getInt(2));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
            String title = "";
            if(filter.equals("estado")){
                title = "Estado actual de las producciones";
            }else if(filter.equals("tipo")){
                title = "Tipos de producciones";
            }
            chart = ChartFactory.createPieChart3D(title, set);

            ChartPanel chartPanel = new ChartPanel(chart);
            
            this.view.getjPanelGraphic().removeAll();
            this.view.getjPanelGraphic().add(chartPanel);
            this.view.getjPanelGraphic().updateUI();
            
        }else if(graphicType.equals("barras")){//Por cantidad de insumos (BarChart) 
            DefaultCategoryDataset set = new DefaultCategoryDataset();
        
            try {
                while(result.next()){
                    set.setValue(result.getInt(2), "Cantidad de insumos", Integer.toString(result.getInt(1)));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            chart = ChartFactory.createBarChart3D("Cantidad de insumos por producción", 
                    "ID producción", "Cantidad", set, PlotOrientation.VERTICAL, true, true, true);
            CategoryPlot plot = chart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.black);

            ChartPanel chartPanel = new ChartPanel(chart);
            
            this.view.getjPanelGraphic().removeAll();
            this.view.getjPanelGraphic().add(chartPanel);
            this.view.getjPanelGraphic().updateUI();
        }
        
        
        
        
        /*
        jpanelGrafica.removeAll();
        jpanelGrafica.add(chartPanel);
        jpanelGrafica.updateUI();
        */
    }

    public ProductionsReportView getView() {
        return view;
    }

    public void setView(ProductionsReportView view) {
        this.view = view;
    }

    public void setRootComponent(MainAppController rootComponent) {
        this.rootComponent = rootComponent;
    }

    public MainAppController getRootComponent() {
        return rootComponent;
    }
    
    
}
