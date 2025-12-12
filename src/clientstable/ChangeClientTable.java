/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientstable;

import client.domain.Client;

/**
 *
 * @author lheop
 */
public class ChangeClientTable extends ClientTable{

    @Override
    protected void tableServicesExecutor(Client client) {
        
        String cpfSearch = client.getCpf();
        
        int clientRow = getClientRow(cpfSearch);
        
        if (clientRow == -1) return;
        
        tableClient.setRowSelectionInterval(clientRow, clientRow);
        defaultTableModel.setValueAt(client.getNome(), clientRow, nome);
        defaultTableModel.setValueAt(client.getEmail(), clientRow,email);
    }
    
}
