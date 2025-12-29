/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.dao;

import client.servicesexecutor.ClientServiceExecutor;

/**
 *
 * @author lheop
 */
public final class MapDAOSingleton {
    
    private static ClientServiceExecutor clientServiceExecutor;
    
    public static ClientServiceExecutor getClientMapDAO() {
        if(clientServiceExecutor == null) {
            clientServiceExecutor = new ClientServiceExecutor();
        }
        return clientServiceExecutor;
    }
}
