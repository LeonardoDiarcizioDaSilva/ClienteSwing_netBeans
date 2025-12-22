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
    public void create() {
        
        ClientDTO dto = registerInterface.getClientDTO();
        
        iGenericDAO.mapCreate(this.entity = new Client(dto.nome, dto.cpf, dto.email, dto.endereco, dto.numero, dto.celular));
    }
    
    @Override
    public Client read(String cpf) {
        
        if(!validator(cpf)) return null;
        return this.entity = iGenericDAO.getEntity(cpf);
    }
    
    @Override
    public void update(Client client) {
        
        ClientDTO dto = registerInterface.getClientDTO();
        
        iGenericDAO.mapUpdate(this.entity = new Client(dto.nome, dto.cpf, dto.email, dto.endereco, dto.numero, dto.celular));
    }
    
    @Override
    public void delete(Client client) {
        
        if(!validator(client.getCpf())) return;
        
        iGenericDAO.mapDelete(this.entity);
    }
}
