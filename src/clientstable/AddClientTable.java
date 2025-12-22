/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientstable;

import client.domain.Client;
import clientregisterswing.RegisterInterface.ClientDTO;

/**
 *
 * @author lheop
 */
public class AddClientTable extends ClientTable{
    
    @Override
    protected void tableServicesExecutor(Client client) {
        
        if (getClientRow(client.getCpf()) == -1) {
            defaultTableModel.addRow(new Object[]{client.getNome(), client.getCpf(), client.getEmail()});
        }
    }
}
