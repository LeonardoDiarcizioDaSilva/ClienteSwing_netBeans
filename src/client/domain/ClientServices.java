/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.domain;

import clientregisterswing.RegisterInterface;
import cliente.dao.ClienteDAOSingleton;
import cliente.dao.IClienteDAO;

/**
 *
 * @author lheop
 */
public abstract class ClientServices {
    
    protected static IClienteDAO iClienteDAO;
    public static RegisterInterface registerInterface;
    public static void setRegisterInterface (RegisterInterface view) {
        registerInterface = view;
    }
    protected Client cliente;
    
    public boolean executor() {
        iClienteDAO = ClienteDAOSingleton.getInstance();
        return serviceExecutor();
    }
    
    protected boolean clientValidator(String cpf) {
        
        this.cliente = iClienteDAO.consultar(cpf);
        
        return cliente != null;
    }
    
    public Client getCliente() {
        return this.cliente;
    }
    
    protected abstract boolean serviceExecutor();
}
