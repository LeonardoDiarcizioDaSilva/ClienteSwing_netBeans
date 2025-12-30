/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientstable.Singleton;

import clientstable.ClientTable;
import javax.swing.JTable;

/**
 *
 * @author lheop
 */
public final class ClientTableSingleton {
    
    private static ClientTable clientTable;
    
    public static ClientTable getInstance(JTable jTable) {
        
        if (clientTable == null) clientTable = new ClientTable(jTable);
        
        return clientTable;
    }
}
