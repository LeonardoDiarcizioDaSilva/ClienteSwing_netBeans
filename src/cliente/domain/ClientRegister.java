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
    protected Cliente serviceExecutor() {
        
        nome = interfaceCadastro.getTxtNome();
        cpf = interfaceCadastro.getTxtCpf();
        email = interfaceCadastro.getTxtEmail();
        numero = interfaceCadastro.getTxtNumero();
        endereco = interfaceCadastro.getTxtEndereco();
        celular = interfaceCadastro.getTxtCelular();
    
        if (!clientValidator(cpf)) {
            
            cliente = new Cliente(nome, cpf, email, endereco, numero, celular);
            iClienteDAO.cadastrar(cliente);
            JOptionPane.showMessageDialog(interfaceCadastro, "Cliente cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(interfaceCadastro, "Cliente ja se encontra cadastrado.");
        } return cliente;
    }
}
