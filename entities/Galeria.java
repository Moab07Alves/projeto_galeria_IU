package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Galeria {
    
    private Usuario usuario;
    private String tituloGaleria;
    private int quantidadeFotos;
    private HashMap<String, Foto> fotos;

    public Galeria(Usuario usuario, String tituloGaleria) {
        this.usuario = usuario;
        this.tituloGaleria = tituloGaleria;
        this.quantidadeFotos = 0;
        fotos = new HashMap<>();
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

    public HashMap<String, Foto> getFotos() {
        return this.fotos;
    }

    public void adicionarFoto(Foto foto) throws Exception{
        if (this.fotos.containsKey(foto.getPathFoto())) {
            throw new Exception("A galeria já possui essa foto");
        }
        else {
            this.fotos.put(foto.getPathFoto(), foto);
        }
    }

    public void removerFoto(Foto foto) {
        //if (this.fotos.containsKey(foto.getPathFoto())) {
        this.fotos.remove(foto.getPathFoto(), foto);
        //}
        //else {
        //    throw new Exception("A foto escolhida não está na galeria");
        //}
    }

    public List<Foto> ListaFotos() throws Exception{
        if (this.fotos.isEmpty()) {
            throw new Exception("A galeria não possui fotos");
        }
        else {
            List<Foto> fotosDaGaleria = new ArrayList<>();
            for (String key: this.fotos.keySet()) {
                Foto foto = this.fotos.get(key);
                fotosDaGaleria.add(foto);
            }
            return fotosDaGaleria;
        }
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
    return "Galeria" + "\n" + 
           "Título da Galeria = " + tituloGaleria + "\n" + 
           usuario + "\n";
    }

}
