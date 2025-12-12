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
public class ClientFinderTable extends ClientTable{
    
    @Override
    protected void tableServicesExecutor (Client client) {
        
        String cpfSearch = client.getCpf();
        
        var clientRow = getClientRow(cpfSearch);
        
        if (clientRow != -1) tableClient.setRowSelectionInterval(clientRow, clientRow);
    }
}
