package entities;

import java.util.ArrayList;
import java.util.List;

public class Galeria {
    
    private Usuario usuario;
    private String tituloGaleria;
    private int quantidadeFotos;
    private List<Foto> fotos;

    public Galeria(Usuario usuario, String tituloGaleria) {
        this.usuario = usuario;
        this.tituloGaleria = tituloGaleria;
        this.quantidadeFotos = 0;
        this.fotos = new ArrayList<>();
    }

    public String getLoginUsuario() {
        return usuario.getLogin();
    }

    public String getTituloGaleria() {
        return tituloGaleria;
    }

    public int getQuantidadeFotos() {
        this.quantidadeFotos = this.fotos.size();
        return this.quantidadeFotos;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void adicionarFoto(Foto foto) {
        this.fotos.add(foto);
    }

    public void removerFoto(Foto foto) {
        this.fotos.remove(foto);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
        result = prime * result + ((tituloGaleria == null) ? 0 : tituloGaleria.hashCode());
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
        Galeria other = (Galeria) obj;
        if (usuario == null) {
            if (other.usuario != null)
                return false;
        } else if (!usuario.equals(other.usuario))
            return false;
        if (tituloGaleria == null) {
            if (other.tituloGaleria != null)
                return false;
        } else if (!tituloGaleria.equals(other.tituloGaleria))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Galeria [usuario=" + usuario + ", tituloGaleria=" + tituloGaleria + "]";
    }

}
