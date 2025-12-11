/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientstable;

import client.domain.Client;
import client.domain.ClientRegister;
import clientregisterswing.RegisterInterface;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lheop
 */
public abstract class ClientTable {
    
    public static RegisterInterface registerInterface;
    public static void setClientInterface (RegisterInterface view) {
        registerInterface = view;
    }
    
    public static ClientRegister clientRegister;
    
    public static DefaultTableModel defaultTableModel;
    public JTable tableClient;
    
    public void executor(Client client) {
        tableServicesExecutor(client);
    }
    
    public int nome = 0;
    public int cpf = 1;
    public int email = 2;
    
    protected abstract void tableServicesExecutor(Client client);
    
    public int getClientRow (String cpfSearch) {

        defaultTableModel = registerInterface.getTable();
        tableClient = registerInterface.getClientsTable();
        
        for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
            String cpfTable = (String) tableClient.getValueAt(i, this.cpf);
            if (cpfTable.equals(cpfSearch)) {
                return i;
            }
        }
        return -1;
    }
}
