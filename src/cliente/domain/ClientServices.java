/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.domain;

import cadastroclienteswing.InterfaceCadastro;
import cliente.dao.ClienteDAOSingleton;
import cliente.dao.IClienteDAO;

/**
 *
 * @author lheop
 */
public abstract class ClientServices {
    
    protected static IClienteDAO iClienteDAO;
    public static InterfaceCadastro interfaceCadastro;
    public static void setInterfaceCadastro (InterfaceCadastro view) {
        interfaceCadastro = view;
    }
    
    String nome;
    String cpf;
    String email;
    String endereco;
    String numero;
    String celular;
    
    public void executor() {
        iClienteDAO = ClienteDAOSingleton.getInstance();
        serviceExecutor();
    }
    
    protected boolean clientValidator(String cpf) {
        
        Cliente cliente = iClienteDAO.consultar(cpf);
        
        if (cliente != null) {
            return true;
        } return false;
    }
    
    protected abstract Cliente serviceExecutor();
    public Cliente cliente;
}
