package br.contatos.view.model;

import br.contatos.model.Contato;
import br.contatos.model.ListaDeContatos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author regina
 */
public class ContatoTableModel extends AbstractTableModel {
    
    private List<Contato> linhas;
    private final String[] colunas;
    private ListaDeContatos contatos;   
    

    private final int ID = 0;
    private final int NOME = 1;
    private final int TELEFONE = 2;
    
    private final int TOTALCOLUNAS = 3;
    
    public ContatoTableModel() {
        linhas = new ArrayList<>();
        colunas = new String[TOTALCOLUNAS];
        
        colunas[ID] = "ID";
        colunas[NOME] = "Nome";
        colunas[TELEFONE] = "Telefone";
    }

    public ContatoTableModel(List<Contato> linhas) {
        this.linhas = linhas;
        colunas = new String[TOTALCOLUNAS];
        
        colunas[ID] = "ID";
        colunas[NOME] = "Nome";
        colunas[TELEFONE] = "Telefone";
    }

    public void adicionarContato(Contato c) {
        contatos.adicionarContato(c);
    }  

    @Override
    public int getRowCount() {
        return contatos.size();
    }

    @Override
    public int getColumnCount() {
        return TOTALCOLUNAS;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex < 0 || rowIndex > getRowCount()) {
            throw new IllegalArgumentException("Índice de linha inválido!");
        }
        if(columnIndex < 0 || columnIndex > getColumnCount()) {
            throw new IllegalArgumentException("Índice de coluna inválido");
        }
        
        Contato contatoSelecionado = linhas.get(rowIndex);
        
        switch(columnIndex) {
            case ID: return contatoSelecionado.getId();
            case NOME: return contatoSelecionado.getNome();
            case TELEFONE: return contatoSelecionado.getTelefone();
        }
        
        throw new IllegalArgumentException();
    }
    
}
