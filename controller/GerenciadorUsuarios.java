package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Usuario;
import persistence.GravadorDeDados;

public class GerenciadorUsuarios{

    private List<Usuario> usuarios;
    private GravadorDeDados gravador;

    public GerenciadorUsuarios() {
        this.usuarios = new ArrayList<>();
        gravador = new GravadorDeDados("usuarios.txt");
    }
    
    public void cadastarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public boolean verificarPessoa(Usuario usuarioCadstrado) {
        if (this.usuarios.contains(usuarioCadstrado)) {
            return true;
        }
        return false;
    }

    public void salvarPessoas() throws IOException {
        List<String> texto = new ArrayList<>();
        for (Usuario a : this.usuarios){
            String linha = a.getLogin() + "#" + a.getSenha();
            texto.add(linha);
        }
        gravador.gravaTextoEmArquivo(texto);
    }

    public void recuperarPessoas() throws IOException {
        List<String> texto = gravador.recuperarTextoDeArquivo();
        String[] array = new String[3];
        if(texto.size() > 1)
            for (String a : texto) {
                array = a.split("#");
                usuarios.add(new Usuario(array[0], array[1]));
            }
    }
    
}