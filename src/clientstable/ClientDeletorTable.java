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
public class ClientDeletorTable extends ClientTable{
    
    @Override
    protected void tableServicesExecutor (Client client) {
        
        ClientDTO dto = registerInterface.getClientDTO();
        
        int clientRow = getClientRow(dto.cpf);
        
        if (clientRow != -1) defaultTableModel.removeRow(clientRow);
    }
}
