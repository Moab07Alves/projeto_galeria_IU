import javax.swing.JFrame;

import entities.Foto;
import entities.Galeria;
import entities.Usuario;
import ui.GuiCriarGaleria;
import ui.GuiLogin;
import ui.GuiMenuPrincipal;
import ui.GuiSelecionarFotos;
import ui.GuiSelecionarGaleria;
import ui.GuiTelaComFoto;

public class Sistema {
    
    GerenciadorUsuarios gerenciador = new GerenciadorUsuarios();

    public static void main(String[] args) {

        
        Usuario usuario = new Usuario("java8", "java8");
        Galeria galeria = new Galeria(usuario, "Simbolos de Galeria");
        Foto foto1 = new Foto(galeria, "Foto azul de uma galeria", "23/12/2010", "/C:/Users/moab7/OneDrive/Área de Trabalho/imagens/Foto1.png");
        Foto foto2 = new Foto(galeria, "Foto minimalista de uma galeria", "24/02/2025", "/C:/Users/moab7/OneDrive/Área de Trabalho/imagens/Foto2.png");
        Foto foto3 = new Foto(galeria, "Foto de uma galeria preta e pequena", "07/04/2004", "/C:/Users/moab7/OneDrive/Área de Trabalho/imagens/Foto3.png" );
        Foto foto4 = new Foto(galeria, "Paisagem com um barco", "15/04/2023","/C:/Users/moab7/OneDrive/Área de Trabalho/imagens/Foto4.png" );
        galeria.adicionarFoto(foto1);
        galeria.adicionarFoto(foto2);
        galeria.adicionarFoto(foto3);
        galeria.adicionarFoto(foto4);

        GuiSelecionarFotos telaFotos = new GuiSelecionarFotos(galeria);
        telaFotos.run();
    

    }
        
}
