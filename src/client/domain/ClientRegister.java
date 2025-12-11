/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domain;

import static client.domain.ClientServices.iClienteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author lheop
 */
public class ClientRegister extends ClientServices {
    
    @Override
    protected boolean serviceExecutor() {
        
        nome = registerInterface.getTxtNome();
        cpf = registerInterface.getTxtCpf();
        email = registerInterface.getTxtEmail();
        numero = registerInterface.getTxtNumero();
        endereco = registerInterface.getTxtEndereco();
        celular = registerInterface.getTxtCelular();
    
        if (!clientValidator(cpf)) {
            
            this.cliente = new Client(nome, cpf, email, endereco, numero, celular);
            iClienteDAO.cadastrar(this.cliente);
            JOptionPane.showMessageDialog(registerInterface, "Cliente cadastrado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(registerInterface, "Cliente ja se encontra cadastrado.");
        } return false;
    }
}
