/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientstable;

import client.domain.Client;
import clientstable.Singleton.TableModelSingleton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lheop
 */
public class ClientTable implements IObserver<Client>{
    
    private static DefaultTableModel defaultTableModel;
    JTable jTable;
    //    Responsável por settar o visual da tabela que aparece na interface.
    public ClientTable(JTable jTable) {
        defaultTableModel = TableModelSingleton.getInstance();
        
        defaultTableModel.addColumn("NOME");
        defaultTableModel.addColumn("CPF");
        defaultTableModel.addColumn("EMAIL");
        
        this.jTable = jTable;
        jTable.setModel(defaultTableModel);
    }
    /*
    *    Recebe um aviso sempre que um novo cliente for criado, então adiciona ele em uma nova linha automaticamente.
    */
    @Override
    public void created(Client client) {
        defaultTableModel.addRow(new Object[]{client.getNome(), client.getCpf(), client.getEmail()});
    }
    /*
    *    Recebe um aviso sempre que um cliente for alterado, então passa os novos valores para a linha automaticamente.
    */
    @Override
    public void updated(Client client) {
        
        jTable.setValueAt(client.getNome(), getRow(client), 0);
        jTable.setValueAt(client.getCpf(), getRow(client), 1);
        jTable.setValueAt(client.getEmail(), getRow(client), 2);
    }
    /*
    *    Recebe um aviso sempre que um cliente for excluído, então tira ele da linha automaticamente.
    */
    @Override
    public void deleted(Client client) {
        defaultTableModel.removeRow(getRow(client));
    }
    
    private int getRow(Client client) {
        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (client.getCpf().equals(jTable.getValueAt(i, 1))) return i;
        } return -1;
    }
}
