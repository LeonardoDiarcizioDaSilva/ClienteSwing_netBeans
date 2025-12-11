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
public class ChangeClient extends ClientServices{

    @Override
    protected boolean serviceExecutor() {
        
        nome = registerInterface.getTxtNome();
        cpf = registerInterface.getTxtCpf();
        email = registerInterface.getTxtEmail();
        endereco = registerInterface.getTxtEndereco();
        numero = registerInterface.getTxtNumero();
        celular = registerInterface.getTxtCelular();
        
        if (clientValidator(cpf)) {
            
            this.cliente = new Client (nome, cpf, email, endereco, numero, celular);
            iClienteDAO.alterar(this.cliente);
            JOptionPane.showMessageDialog(registerInterface, "Cliente alterado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(registerInterface, "Cliente não encontrado.");
        } return false;
    }
}
