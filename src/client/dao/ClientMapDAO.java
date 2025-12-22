/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.dao;

import client.dao.generic.GenericDAO;
import client.domain.Client;

/**
 *
 * @author lheop
 */
public class ClientMapDAO extends GenericDAO<Client>{

    public ClientMapDAO() {
        super();
    }
    
    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }
}
