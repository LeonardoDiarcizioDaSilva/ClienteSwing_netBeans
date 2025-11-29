/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.dao;

/**
 *
 * @author lheop
 */
public final class ClienteDAOSingleton{
    
    private static IClienteDAO iClienteDAO;
    
    public static IClienteDAO getInstance() {
        if (iClienteDAO == null) {
            iClienteDAO = new ClienteMapDAO();
        } return iClienteDAO;
    }
}
