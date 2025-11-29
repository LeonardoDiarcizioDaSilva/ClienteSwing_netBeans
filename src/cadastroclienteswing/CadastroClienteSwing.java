/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroclienteswing;

import cadastroclienteswing.InterfaceCadastro;
import cliente.dao.ClienteMapDAO;
import cliente.dao.IClienteDAO;

/**
 *
 * @author lheop
 */
public class CadastroClienteSwing {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        InterfaceCadastro tela = new InterfaceCadastro();
        tela.setVisible(true);
        
        iClienteDAO = new ClienteMapDAO();
    }
}
    
