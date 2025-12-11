/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientstable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lheop
 */
public final class TableModelSingleton {
    
    private static DefaultTableModel defaultTableModel;
    
    public static DefaultTableModel getInstance() {
        
        if (defaultTableModel == null) {
            defaultTableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int colums) {
                return false;
                }
            };
        } return defaultTableModel;
    }
}
