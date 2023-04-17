package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.Usuario;
import persistence.GravadorDeDados;

public class GerenciadorUsuarios{

    private HashMap<String, Usuario> usuarios;
    private GravadorDeDados gravador;

    public GerenciadorUsuarios() {
        this.usuarios = new HashMap<>();
        gravador = new GravadorDeDados("usuarios.txt");
    }
    
    public Usuario getUsuario(String login) {
        if (this.usuarios.containsKey(login)) {
            return this.usuarios.get(login);
        }
        return null;
    }

    public void cadastarUsuario(Usuario usuario) throws Exception{
        if (this.usuarios.containsKey(usuario.getLogin())) {
            throw new Exception("O Login passado já esta sendo utilizado por outro usuario");
        }
        else {
            this.usuarios.put(usuario.getLogin(), usuario);
        }
    }

    public boolean verificarPessoa(String login) {
        if (this.usuarios.containsKey(login)) {
            return true;
        }
        return false;
    }

    public StringBuilder usuariosDoSistema() {
        StringBuilder texto = new StringBuilder();
        if(!this.usuarios.isEmpty()) {
            texto.append("USUÁRIOS DO SISTEMA\n\n");
            for (String key : this.usuarios.keySet()) {
                Usuario usuario = this.usuarios.get(key);
                texto.append("Login: " + usuario.getLogin() + "  Senha: " + usuario.getSenha() + "\n");
            }
        }
        else {
            texto.append("Não há usuarios cadastrados\n");
        }
        return texto;
    }
    
    public void salvarPessoas() throws IOException {
        List<String> texto = new ArrayList<>();
        for (String key: this.usuarios.keySet()){
            Usuario usuario = this.usuarios.get(key);
            String linha = usuario.getLogin() + "#" + usuario.getSenha();
            texto.add(linha);
        }
        gravador.gravaTextoEmArquivo(texto);
    }

    public void recuperarPessoas() throws IOException {
        List<String> texto = gravador.recuperarTextoDeArquivo();
        String[] array = new String[2];
        if(texto.size() > 1){
            for (String dadosUsuario : texto) {
                array = dadosUsuario.split("#");
                Usuario usuarioRecuperado = new Usuario(array[0], array[1]);
                this.usuarios.put(usuarioRecuperado.getLogin(), usuarioRecuperado);
            }
        }
    }

}