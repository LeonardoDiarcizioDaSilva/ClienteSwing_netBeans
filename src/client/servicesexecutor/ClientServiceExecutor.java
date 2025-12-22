/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.servicesexecutor;

import client.dao.ClientMapDAO;
import client.dao.MapDAOSingleton;
import client.dao.generic.IGenericDAO;
import client.domain.Client;
import clientregisterswing.RegisterInterface;
import clientregisterswing.RegisterInterface.ClientDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author lheop
 */
public class ClientServiceExecutor extends ServiceExecutor<Client> {

    private static MapDAOSingleton mapDAOSingleotn;
    
    public ClientServiceExecutor(IGenericDAO dao) {
        super(dao);
    }

    
    @Override
    public boolean create(Client client) {
        
        if(validator(client.getCpf())) return false;
        
        iGenericDAO.mapCreate(this.entity = client);
        return true;
    }
    
    @Override
    public Client read(String cpf) {
        
        if(!validator(cpf)) return null;
        return this.entity = iGenericDAO.getEntity(cpf);
    }
    
    @Override
    public boolean update(Client client) {
        
        if(!validator(client.getCpf())) return false;
        
        iGenericDAO.mapUpdate(this.entity = client);
        return true;
    }
    
    @Override
    public boolean delete(String cpf) {
        
        if(!validator(cpf)) return false;
        
        int resposta = JOptionPane.showConfirmDialog(registerInterface, "Deseje excluir o cliente: " + this.entity.toString() + "?", "Excluir cliente", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(resposta == JOptionPane.NO_OPTION) return false;
        iGenericDAO.mapDelete(this.entity);
        return true;
    }
}
