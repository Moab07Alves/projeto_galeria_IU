package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Usuario{

    private String login; // É O NOME DO USUÁRIO NO SISTEMA
    private String senha;
    private HashMap<String, Galeria> galerias;
    private int quantidadeGalerias;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.quantidadeGalerias = 0;
        this.galerias = new HashMap<>();
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getQuantidadeGalerias() {
        return this.quantidadeGalerias;
    }

    public StringBuilder getGaleria() {
        StringBuilder textoGalerias = new StringBuilder();
        if(!this.galerias.isEmpty()) {
            textoGalerias.append("\tGalerias do Usuário\n\n");
            for(String key: this.galerias.keySet()) {
                Galeria galeria = this.galerias.get(key);
               textoGalerias.append(galeria.getTituloGaleria() + "\n");
            }
        }
        else {
            textoGalerias.append("O usuário não possui nenhuma galeria");
        }
        return textoGalerias;
    }

    public void criarGaleria(String tituloGaleria) throws Exception {
        if (this.galerias.containsKey(tituloGaleria)) {
            throw new Exception("Não é possivel criar a galeria com o nome " + tituloGaleria + ", pois o usuário possui outra galeria cadastrada com essa nomeação");
        }
        else {
            Galeria novaGaleria = new Galeria(this, tituloGaleria);
            this.galerias.put(novaGaleria.getTituloGaleria(), novaGaleria);
            this.quantidadeGalerias++;
        }
    }

    /* 
    //Essa função não é utilizada no programa foi criada para se fazer teste e ver o comportamento do sistema na persistência de dados com arquivos .txt.

    public void excluirGaleria(Galeria galeria) throws Exception{
        if (this.galerias.containsKey(galeria.getTituloGaleria())) {
            this.galerias.remove(galeria.getTituloGaleria(), galeria);
        }
        else {
            throw new Exception("Não é possivel remover essa galeria, pois ela não existe na lista de galerias do usuário");
        }
    }

    */

    public void registrarFoto(Galeria galeria, Foto foto) throws Exception{
        //if (this.galerias.containsKey(galeria.getTituloGaleria())) {
        this.galerias.get(galeria.getTituloGaleria()).adicionarFoto(foto);
        //}
        //else {
        //    throw new Exception("Não é possivel adicionar uma foto a galeria " + galeria.getTituloGaleria() + ", pois ela não existe na lista de galerias do usuário");
        //}
    }

    public void excluirFoto(Galeria galeria, Foto foto) {
        //if (this.galerias.containsKey(galeria.getTituloGaleria())) {
        this.galerias.get(galeria.getTituloGaleria()).removerFoto(foto);
        //}
        //else {
        //    throw new Exception("Não é possivel adicionar uma foto a galeria " + galeria.getTituloGaleria() + ", pois ela não existe na lista de galerias do usuário");
        //}
    }

    public Galeria procurarGaleriaPorTitulo(String tituloGaleria) throws Exception{
        if (this.galerias.isEmpty()) {
            throw new Exception("O usuário não possui galerias");
        }
        else if (this.galerias.containsKey(tituloGaleria)) {
            return this.galerias.get(tituloGaleria);
        }
        else {
            throw new Exception("O usuário não possui entre suas galerias uma galeria com o nome '" + tituloGaleria + "'");
        }
    }

    public List<Galeria> todasGalerias() throws Exception {
        if (this.galerias.isEmpty()) {
            throw new Exception("O usuário não possui galerias");
        }
        else {
        List<Galeria> galeriasUsuario = new ArrayList<>();        
            for (String key : this.galerias.keySet()) {
                Galeria galeria = this.galerias.get(key);
                galeriasUsuario.add(galeria);
            }
            return galeriasUsuario;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario" + "\n" +
               "Login = " + login + "\n" + 
               "Senha = " + senha + "\n";
    }

}
