/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.domain;

/**
 *
 * @author lheop
 */
public final class ClientServicesSingleton {
    
    private static ClientRegister clientRegister;
    private static ChangeClient changeClient;
    private static ClientDelete clientDelete;
    private static ClientFinder clientFinder;
    
    public static ClientRegister clientRegisterInstance() {
        if (clientRegister == null) {
            clientRegister = new ClientRegister();
        } return clientRegister;
    }
    
    public static ChangeClient changeClientInstance() {
        if (changeClient == null) {
            changeClient = new ChangeClient();
        } return changeClient;
    }
    
    public static ClientDelete clienteDeleteInstance() {
        if (clientDelete == null) {
            clientDelete = new ClientDelete();
        } return clientDelete;
    }
    
    public static ClientFinder clientFinderInstance() {
        if (clientFinder == null) {
            clientFinder = new ClientFinder();
        } return clientFinder;
    }
}
