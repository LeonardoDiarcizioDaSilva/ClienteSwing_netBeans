/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.domain;

import static cliente.domain.ClientServices.iClienteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author lheop
 */
public class ClientRegister extends ClientServices {
    
    @Override
    protected boolean serviceExecutor() {
        
        nome = interfaceCadastro.getTxtNome();
        cpf = interfaceCadastro.getTxtCpf();
        email = interfaceCadastro.getTxtEmail();
        numero = interfaceCadastro.getTxtNumero();
        endereco = interfaceCadastro.getTxtEndereco();
        celular = interfaceCadastro.getTxtCelular();
    
        if (!clientValidator(cpf)) {
            
            this.cliente = new Cliente(nome, cpf, email, endereco, numero, celular);
            iClienteDAO.cadastrar(this.cliente);
            JOptionPane.showMessageDialog(interfaceCadastro, "Cliente cadastrado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(interfaceCadastro, "Cliente ja se encontra cadastrado.");
            return false;
        }
    }
}
