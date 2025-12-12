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
        
        String nome = registerInterface.getTxtNome();
        String cpf = registerInterface.getTxtCpf();
        String email = registerInterface.getTxtEmail();
        String numero = registerInterface.getTxtNumero();
        String endereco = registerInterface.getTxtEndereco();
        String celular = registerInterface.getTxtCelular();
    
        if (clientValidator(cpf)) {
            
          JOptionPane.showMessageDialog(registerInterface, "Cliente ja se encontra cadastrado.");
          return false;
        }
        
        this.cliente = new Client(nome, cpf, email, endereco, numero, celular);
        iClienteDAO.cadastrar(cliente);

        JOptionPane.showMessageDialog(registerInterface, "Cliente cadastrado com sucesso!");
        return true;
    }
}
