
package br.contatos.model;

import java.util.List;

/**
 *
 * @author regina
 */
public class ListaDeContatos {
    
    private List<Contato> contatos;
    private static ListaDeContatos instance = new ListaDeContatos();
    
    private ListaDeContatos() {
        contatos = GerenciadorDeArquivos.lerContatos();
    }
    
    public void adicionarContato(Contato c) {
        contatos.add(c);
    }
    
    public static ListaDeContatos getInstance() {
        return (instance == null ? new ListaDeContatos() : instance);
    }
    
    public List<Contato> getContatos() {
        return contatos;
    }
    
    public int size() {
        return contatos.size();
    }
}
