package entities;

public class Foto {
    
    private Galeria galeria;
    private String descricao;
    private String dataFoto;
    private String caminhoFoto;

    public Foto(Galeria galeria, String descrição, String dataFoto, String caminhoFoto) {
        this.galeria = galeria;
        this.descricao = descrição;
        this.dataFoto = dataFoto;
        this.caminhoFoto = caminhoFoto;
    }

    public String getGaleria() {
        return galeria.getTituloGaleria();
    }

    public String getGaleriaUsuario() {
        return galeria.getLoginUsuario();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataFoto() {
        return dataFoto;
    }

    public void setDataFoto(String dataFoto) {
        this.dataFoto = dataFoto;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((galeria == null) ? 0 : galeria.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((dataFoto == null) ? 0 : dataFoto.hashCode());
        result = prime * result + ((caminhoFoto == null) ? 0 : caminhoFoto.hashCode());
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
        if (caminhoFoto == null) {
            if (other.caminhoFoto != null)
                return false;
        } else if (!caminhoFoto.equals(other.caminhoFoto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Foto [galeria=" + galeria + ", descricao=" + descricao + ", dataFoto=" + dataFoto + ", caminhoFoto="
                + caminhoFoto + "]";
    }

}
