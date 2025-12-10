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
public class ClientDelete extends ClientServices {
    
    @Override
    protected boolean serviceExecutor() {
        
        cpf = interfaceCadastro.getTxtCpf();
        
        if (clientValidator(cpf)) {

            this.cliente = iClienteDAO.consultar(cpf);
            int resposta = JOptionPane.showConfirmDialog(interfaceCadastro, "Deseja excluir o cliente: " + this.cliente.toString() + " ?", "EXCLUIR CLIENTE", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            
            if (resposta == JOptionPane.YES_OPTION) {
                
                iClienteDAO.excluir(cpf);
                JOptionPane.showMessageDialog(interfaceCadastro, "Cliente excluido com sucesso!");
            } return true;
        } return false;
    }
}
