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
public class ClientDeletorTable extends ClientTable{
    
    @Override
    protected void tableServicesExecutor (Client client) {
        
        String cpfSearch = registerInterface.getTxtCpf();
        
        if (getClientRow(cpfSearch) != -1) {
            defaultTableModel.removeRow(getClientRow(cpfSearch));
        }
    }
}
