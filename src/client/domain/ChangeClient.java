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
        
        String nome = registerInterface.getTxtNome();
        String cpf = registerInterface.getTxtCpf();
        String email = registerInterface.getTxtEmail();
        String endereco = registerInterface.getTxtEndereco();
        String numero = registerInterface.getTxtNumero();
        String celular = registerInterface.getTxtCelular();
        
        if (!clientValidator(cpf)) {
            
            JOptionPane.showMessageDialog(registerInterface, "Cliente não encontrado.");
            return false;
        }
        
        iClienteDAO.alterar(this.cliente = new Client (nome, cpf, email, endereco, numero, celular));
        JOptionPane.showMessageDialog(registerInterface, "Cliente alterado com sucesso!");
        return true;
    }
}
