package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.Foto;
import entities.Galeria;
import entities.Usuario;
import persistence.GravadorDeDados;

public class GerenciadorUsuarios{

    private HashMap<String, Usuario> usuarios;
    private GravadorDeDados gravador;
    private GravadorDeDados gravadorGaleria;
    private GravadorDeDados gravadorFotos;

    public GerenciadorUsuarios() {
        this.usuarios = new HashMap<>();
        gravador = new GravadorDeDados("usuarios.txt");
        gravadorGaleria = new GravadorDeDados("galerias.txt");
        gravadorFotos = new GravadorDeDados("fotos.txt");
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

    public boolean verificarUsuario(String login) {
        if (this.usuarios.containsKey(login)) {
            return true;
        }
        return false;
    }
    
    public boolean verificarSenhaUsuario (String login, String senha) throws Exception {
        if (this.usuarios.get(login).getSenha().equals(senha)){
            return true;
        }
        else {
            throw new Exception("Seha Incorreta");
        }
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
    
    public void salvarPessoas() throws Exception {
        List<String> texto = new ArrayList<>();
        for (String key: this.usuarios.keySet()){
            Usuario usuario = this.usuarios.get(key);
            String linha = usuario.getLogin() + "#" + usuario.getSenha();
            texto.add(linha);
        }
        gravador.gravaTextoEmArquivo(texto);
        salvarGalerias();
    }

    public void recuperarPessoas() throws Exception {
        List<String> texto = gravador.recuperarTextoDeArquivo();
        String[] array = new String[2];
        if(texto.size() >= 1){
            for (String dadosUsuario : texto) {
                array = dadosUsuario.split("#");
                Usuario usuarioRecuperado = new Usuario(array[0], array[1]);
                this.usuarios.put(usuarioRecuperado.getLogin(), usuarioRecuperado);
            }
        }
        recuperarGalerias();
    }

    public void salvarGalerias() throws Exception {
        List<String> galeriasDoSistema = new ArrayList<>();
        for (String key : this.usuarios.keySet()) {
            Usuario usuario = this.usuarios.get(key);
            if(usuario.getQuantidadeGalerias() != 0) {
                List<Galeria> galeriasDoUsuario = usuario.todasGalerias();
                for (Galeria galeria : galeriasDoUsuario) {
                    String linha = galeria.getLoginUsuario() + "#" + galeria.getTituloGaleria();
                    galeriasDoSistema.add(linha);
                }
            }
        }
        gravadorGaleria.gravaTextoEmArquivo(galeriasDoSistema);
        salvarFotos();
    }

    public void recuperarGalerias() throws Exception {
        List<String> galeriasDoSistema = gravadorGaleria.recuperarTextoDeArquivo();
        for (String galeria: galeriasDoSistema) {
            String[] dadosGaleria = galeria.split("#");
            getUsuario(dadosGaleria[0]).criarGaleria(dadosGaleria[1]);
        }
        recuperarFotos();
    }

    public void salvarFotos() throws Exception{
        List<String> fotosDoSistema = new ArrayList<>();
        for (String key : this.usuarios.keySet()) {
            Usuario usuario = this.usuarios.get(key);
            if(usuario.getQuantidadeGalerias() != 0) {
                List<Galeria> galeriasDoUsuario = usuario.todasGalerias();
                for (Galeria galeria : galeriasDoUsuario) {
                    if (galeria.getQuantidadeFotos() != 0) {
                        List<Foto> fotosDoUsuario = galeria.ListaFotos();
                        for (Foto foto: fotosDoUsuario) {
                            String linha = foto.getLoginUsuario() + "#" + foto.getTituloGaleria() + "#" + foto.getDescricao() + "#" + foto.getDataFoto() + "#" + foto.getPathFoto();
                            fotosDoSistema.add(linha);
                        }
                    }
                }
            }
        }
        gravadorFotos.gravaTextoEmArquivo(fotosDoSistema);    
    }

    public void recuperarFotos() throws Exception{
        List<String> fotosDoSistema = gravadorFotos.recuperarTextoDeArquivo();
        for (String foto : fotosDoSistema) {
            String[] dadosFotos = foto.split("#");
            Galeria galeriaDaFoto = this.usuarios.get(dadosFotos[0]).procurarGaleriaPorTitulo(dadosFotos[1]);
            Foto fotoUsuario = new Foto(galeriaDaFoto, dadosFotos[2], dadosFotos[3], dadosFotos[4]);
            this.usuarios.get(dadosFotos[0]).registrarFoto(galeriaDaFoto, fotoUsuario);
        }
    }

}