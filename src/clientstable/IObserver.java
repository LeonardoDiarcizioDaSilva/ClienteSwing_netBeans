/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clientstable;

import clientregisterswing.RegisterInterface;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lheop
 */
public interface IObserver<T>{
    
    public void created(T entity);
    
    public void updated(T entity);
    public void deleted(T entity);
}
