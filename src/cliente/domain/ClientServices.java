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
    protected Cliente cliente;
    
    String nome;
    String cpf;
    String email;
    String endereco;
    String numero;
    String celular;
    
    public boolean executor() {
        iClienteDAO = ClienteDAOSingleton.getInstance();
        return serviceExecutor();
    }
    
    protected boolean clientValidator(String cpf) {
        
        Cliente cliente = iClienteDAO.consultar(cpf);
        
        if (cliente != null) {
            return true;
        } return false;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    protected abstract boolean serviceExecutor();
}
