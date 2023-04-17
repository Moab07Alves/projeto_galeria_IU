package entities;

public class Foto {
    
    private Galeria galeria;
    private String descricao;
    private String dataFoto;
    private String pathFoto;

    public Foto(Galeria galeria, String descrição, String dataFoto, String pathFoto) {
        this.galeria = galeria;
        this.descricao = descrição;
        this.dataFoto = dataFoto;
        this.pathFoto = pathFoto;
    }

    public String getTituloGaleria() {
        return this.galeria.getTituloGaleria();
    }

    public String getLoginUsuario() {
        return this.galeria.getLoginUsuario();
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getDataFoto() {
        return this.dataFoto;
    }
    
    public String getPathFoto() {
        return pathFoto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((galeria == null) ? 0 : galeria.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((dataFoto == null) ? 0 : dataFoto.hashCode());
        result = prime * result + ((pathFoto == null) ? 0 : pathFoto.hashCode());
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
        Foto other = (Foto) obj;
        if (galeria == null) {
            if (other.galeria != null)
                return false;
        } else if (!galeria.equals(other.galeria))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (dataFoto == null) {
            if (other.dataFoto != null)
                return false;
        } else if (!dataFoto.equals(other.dataFoto))
            return false;
        if (pathFoto == null) {
            if (other.pathFoto != null)
                return false;
        } else if (!pathFoto.equals(other.pathFoto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Foto" + "\n" +
               "Descrição: " + descricao + "\n" + 
               "Data da foto: " + dataFoto + "\n" + 
               "Path foto: "  + pathFoto + "\n" + 
               galeria;
    }

}
