/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domain;

import javax.swing.JOptionPane;

/**
 *
 * @author lheop
 */
public class ClientFinder extends ClientServices{
    
    protected boolean serviceExecutor() {
        
        cpf = registerInterface.getTxtCpf();
        
        if (clientValidator(cpf)) {
            
            this.cliente = iClienteDAO.consultar(cpf);
            return true;
        } else {
            JOptionPane.showMessageDialog(registerInterface, "Cliente não encontrado.");
        } return false;
    }
}
