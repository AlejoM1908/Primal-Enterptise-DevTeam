/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.ui.AssetsReport;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.app.DBConnection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author user
 */
public class AssetsReportModel {
    private AssetsReportView view;

    public AssetsReportModel(AssetsReportView view) {
        this.view = view;
    }
    
    public void generateGraphic(){
        DBConnection conn = new DBConnection();
        conn.getConnection();
        ResultSet result = conn.executeQuery("SELECT act_estado, COUNT(act_estado) cantidad FROM activos GROUP BY act_estado;");
        conn.endCOnnection();
        DefaultPieDataset set = new DefaultPieDataset();
        try {
            while(result.next()){
                set.setValue(result.getString(1), result.getInt(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        JFreeChart chart = ChartFactory.createPieChart3D("Estado actual de los activos", set);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        /*
        jpanelGrafica.removeAll();
        jpanelGrafica.add(chartPanel);
        jpanelGrafica.updateUI();
        */
    }

    public AssetsReportView getView() {
        return view;
    }

    public void setView(AssetsReportView view) {
        this.view = view;
    }
    
    
}
