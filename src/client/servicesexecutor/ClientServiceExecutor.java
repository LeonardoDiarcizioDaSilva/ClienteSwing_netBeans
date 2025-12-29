/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.servicesexecutor;

import client.dao.generic.GenericDAO;
import client.domain.Client;

/**
 *
 * @author lheop
 */
public class ClientServiceExecutor extends GenericDAO<Client>{

    public ClientServiceExecutor() {
        super();
    }
    
    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }
    
    public void create(Client client) {mapCreate(client);}
    
    public Client read(String cpf) {return  mapRead(cpf);}

    public void update(String cpf, Client client) {
        
        Client oldClient = mapRead(cpf);
        oldClient.setNome(client.getNome());
        oldClient.setEmail(client.getEmail());
        oldClient.setEnd(client.getEnd());
        oldClient.setNum(client.getNum());
        oldClient.setCel(client.getCel());
        
        mapUpdate(cpf, client);
    }
    
    public void delete(String cpf) {mapDelete(mapRead(cpf));}
}
