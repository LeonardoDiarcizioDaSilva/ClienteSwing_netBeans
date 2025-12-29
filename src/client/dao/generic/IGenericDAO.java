/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package client.dao.generic;

/**
 *
 * @author lheop
 */
public interface IGenericDAO<T> {

    public void mapCreate(T entity);
    public T mapRead(String code);
    public void mapUpdate(String code, T entity);
    public void mapDelete(T entity);
}