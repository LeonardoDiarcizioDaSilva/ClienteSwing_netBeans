/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client.dao.generic;

import client.domain.Persistent;

/**
 *
 * @author lheop
 */
public interface IGenericDAO<T extends Persistent> {

    public boolean mapCreate(T entity);
    public T mapRead(T entity);
    public boolean mapUpdate(T entity);
    public void mapDelete(T entity);
    
    public T getEntity(String code);
}