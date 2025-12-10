/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.domain;

import javax.swing.JOptionPane;

/**
 *
 * @author lheop
 */
public class ClientFinder extends ClientServices{
    
    protected Cliente serviceExecutor() {
        
        cpf = interfaceCadastro.getTxtCpf();
        
        if (clientValidator(cpf)) {
            
            cliente = iClienteDAO.consultar(cpf);
        } else {
            JOptionPane.showMessageDialog(interfaceCadastro, "Cliente não encontrado.");
        } return cliente;
    }
}
