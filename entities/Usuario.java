package entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario{

    private String login;
    private String senha;
    private List<Galeria> galerias;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.galerias = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    /** 
    public void setLogin(String login) {
        this.login = login;
    }
    */

    public String getSenha() {
        return senha;
    }

    /** 
    public void setSenha(String senha) {
        this.senha = senha;
    }
    */

    //public List<Galeria> getGalerias() {
    //    return galerias;
    //}

    public StringBuilder getGaleria() {
        StringBuilder titulosGaleria = new StringBuilder();
        if(!this.galerias.isEmpty()) {
            titulosGaleria.append("\tGalerias do Usuário\n\n");
            for(Galeria gale: this.galerias) {
               titulosGaleria.append(gale.getTituloGaleria() + " ---- QUANTIDADE DE FOTOS:  " + gale.getQuantidadeFotos() + "\n");
            }
            return titulosGaleria;
        }
        else {
            //titulosGaleria.append("O usuário não possui nenhuma galeria");
            return null;
        }
    }

    public void criarGaleria(Galeria galeria) {
        this.galerias.add(galeria);
    }

    public void excluirGaleria(Galeria galeria) {
        this.galerias.remove(galeria);
    }

    public void registrarFoto(Galeria galeria, Foto foto) {
        galeria.adicionarFoto(foto);
    }

    public void excluirFoto(Galeria galeria, Foto foto) {
        galeria.removerFoto(foto);
    }

    public Galeria procurarGaleriaPorTitulo(String nomeGaleria) {
        for (Galeria gale: this.galerias) {
            gale.getTituloGaleria().equals(nomeGaleria);
            return gale;
        }
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [login=" + login + ", senha=" + senha + "]";
    }

}
