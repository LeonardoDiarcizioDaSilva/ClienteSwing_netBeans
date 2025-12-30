/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.dao.generic;

import client.domain.GetCode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author lheop
 */
public abstract class GenericDAO<T> implements IGenericDAO<T> {
    
    protected Map<Class, Map<String, T>> map;
    /*
    *    Inicializador, para que o "map" não seja null, assim que o arquivo é compilado ele cria um "new HashMap"
    *        para poder guardar o "Map<String, T>", ele é o map que busca por classe, o "armário"
    *    O internal map é a "gaveta" que busca o objeto "entity" pela etiqueta "String"
    *        ele recebe "map.get(getClassType())" para saber a qual armário a gaveta pertence.
    *    Então ele verifica, se a haveta existir, ele não faz nada, caso a gaveta não exista ele cria uma.
    */
    public GenericDAO() {
        
        this.map = new HashMap();
        
        Map<String, T> internalMap = this.map.get(getClassType());
        if(internalMap == null) {
            internalMap = new HashMap();
            this.map.put(getClassType(), internalMap);
        }
    }
    /*
    *    Serve para buscar a annotation "GetCode", ele recebe "T entity" para poder buscar e saber em qual classe deve olhar
    *        ele recebe todos os campos dessa classe, ex: "cpf" - e depois faz uma busca em todos os campos
    *        para vereficar qual tem a annotation da classe "GetCode".
    *    Então dentro da classe da entity, ele irá tentar achar um método com o mesmo nome da annotation recebeida
    *        caso exista, ele executa o método, que recebe um entity, passando o entity que seu próprio método recebe
    *        caso não exista, ele dispara um erro, no qual pode ser caso o banco de dados tenha caído
    *        ou caso o programador não tenha passado a annotation no campo da entity, então
    *        diz a quem esta chamando o método que o erro é interno, para chamar alguem para resolver.
    */
    public String getCode(T entity) {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field: fields) {
            if(field.isAnnotationPresent(GetCode.class)) {
                GetCode getId = field.getAnnotation(GetCode.class);
                try {
                    Method method = entity.getClass().getDeclaredMethod(getId.value());   
                    return (String) method.invoke(entity);
                } catch(NoSuchMethodException e) {
                    JOptionPane.showMessageDialog(null, "Erro para buscar, por favor contate o suporte.");
                    return null;
                } catch(IllegalAccessException | InvocationTargetException e) {
                    return null;
                }
            }
        }
        return null;
    }
    /*
    *    Método abstrato, implementa mais de uma classe (caso tenha) para buscar a classe desejada para executar
    *        os métodos desejados, ex: crie um objeto do tipo Produto, ou crie um objeto do tipo Cliente.
    */
    public abstract Class<T> getClassType();
    /*
    *    Responsável por adicionar o cliente no banco de dados (map)
    *        recebe um objeto e o coloca dentro da gaveta
    *    internalMap recebe this.map.get(getClassType()), ex: (armário, do tipo cliente)
    *    internalMap.put(getCode(entity), entity) cria um gaveta com "getCode" (caso não exista)
    *        e ponha o objeto "entity" dentro da gaveta.
    */
    @Override
    public void mapCreate(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        internalMap.put(getCode(entity), entity);
    }
    /*
    *    Responsável por buscar dentro do banco de dados o objeto que foi pedido
    *        busca dentro do armário se existe alguma gaveta com o "code" pedido, se tiver, retorna o object.
    */
    @Override
    public T mapRead(String code) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        return internalMap.containsKey(code) ? internalMap.get(code) : null;
    }
    /*
    *    Recebe o código da gaveta que irá buscar dentro do armário, e troca o objeto pelo objeto novo "entity"
    */
    @Override
    public void mapUpdate(String code, T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        internalMap.replace(code, entity);
    }
    /*
    *    Recebe o objeto que deve remover, faz a busca no armário pelo objeto, e remove ele "entity "e a gaveta "getCode"
    */
    @Override
    public void mapDelete(T entity) {
        
        Map<String, T> internalMap = this.map.get(getClassType());
        
        internalMap.remove(getCode(entity), entity);
    }
}
