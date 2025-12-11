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
        
        if (getClientRow(cpfSearch) != -1) {
            
            defaultTableModel.setValueAt(client.getNome(), getClientRow(cpfSearch), nome);
            defaultTableModel.setValueAt(client.getEmail(), getClientRow(cpfSearch), email);
            tableClient.setSelectionMode(getClientRow(cpfSearch));
        }
    }
    
}
