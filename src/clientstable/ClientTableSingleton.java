/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientstable;

/**
 *
 * @author lheop
 */
public final class ClientTableSingleton {
    
    private static AddClientTable addClientTable;
    private static ChangeClientTable changeClienteTable;
    private static ClientFinderTable clientFinderTable;
    private static ClientDeletorTable clientDeletorTable;
    
    public static AddClientTable addTableInstance () {
        if (addClientTable == null) {
             addClientTable = new AddClientTable();
        } return addClientTable;
    }
    
    public static ChangeClientTable changeTableInstance () {
        if (changeClienteTable == null) {
             changeClienteTable = new ChangeClientTable();
        } return changeClienteTable;
    }
    
    public static ClientFinderTable finderTableInstance () {
        if (clientFinderTable == null) {
             clientFinderTable = new ClientFinderTable();
        } return clientFinderTable;
    }
    
    public static ClientDeletorTable deletorTableInstance () {
        if (clientDeletorTable == null) {
             clientDeletorTable = new ClientDeletorTable();
        } return clientDeletorTable;
    }
}
