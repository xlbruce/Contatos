package br.contatos.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author regina
 */
public class GerenciadorDeArquivos {

    private static final String PATH = "./db/";
    private static final String FILENAME = "contatos.dat";

    private GerenciadorDeArquivos() {
    }

    /**
     * Salva em arquivo uma lista de contatos. O conteúdo anterior do arquivo
     * será sobrescrito. O arquivo será criado caso não exista.
     *
     * @param contatos A lista de contatos a ser gravada
     * @throws IOException
     */
    public static void salvar(List<Contato> contatos) throws IOException {
        File destino = new File(PATH + FILENAME);

        if (!destino.exists()) {
            destino.createNewFile();
        }

        //Faz a gravação em arquivo
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(destino));
        os.writeObject(contatos);
        os.flush();
        os.close();

    }

    /**
     * Retorna uma lista com todos os contatos salvos em arquivo, ou uma lista
     * vazia caso o arquivo não exista.
     *
     * @return Contatos salvos em arquivo
     */
    public static List<Contato> lerContatos() {
        File origem = new File(PATH + FILENAME);
        List<Contato> contatos = new ArrayList<>();

        //Retorna uma lista vazia o arquivo não existir
        if (!origem.exists()) {
            return contatos;
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(origem));
            contatos = (ArrayList<Contato>) in.readObject();
            in.close();
        } catch (ClassNotFoundException ex) {
            System.err.println("Arquivo inválido");
        } catch (FileNotFoundException ex) {
            System.err.println("Arquivo não encontrado");
        } catch (IOException ex) {
            System.err.println("IOException: " + ex.getMessage());
        }

        return contatos;
    }

}
