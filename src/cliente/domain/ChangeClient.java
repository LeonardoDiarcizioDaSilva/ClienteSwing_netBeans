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
public class ChangeClient extends ClientServices{

    @Override
    protected boolean serviceExecutor() {
        
        nome = interfaceCadastro.getTxtNome();
        cpf = interfaceCadastro.getTxtCpf();
        email = interfaceCadastro.getTxtEmail();
        endereco = interfaceCadastro.getTxtEndereco();
        numero = interfaceCadastro.getTxtNumero();
        celular = interfaceCadastro.getTxtCelular();
        
        if (clientValidator(cpf)) {
            
            this.cliente = new Cliente (nome, cpf, email, endereco, numero, celular);
            iClienteDAO.alterar(this.cliente);
            JOptionPane.showMessageDialog(interfaceCadastro, "Cliente alterado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(interfaceCadastro, "Cliente não encontrado.");
        } return false;
    }
}
