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
public class ClientDelete extends ClientServices {
    
    @Override
    protected boolean serviceExecutor() {
        
        String cpf = registerInterface.getTxtCpf();
        
        if (!clientValidator(cpf)) return false;
        
        int resposta = JOptionPane.showConfirmDialog(registerInterface, "Deseja excluir o cliente: " + this.cliente.toString() + " ?", "EXCLUIR CLIENTE", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
        if (resposta == JOptionPane.YES_OPTION) {
                
            iClienteDAO.excluir(cpf);
            JOptionPane.showMessageDialog(registerInterface, "Cliente excluido com sucesso!");
        } return true;
    }
}
