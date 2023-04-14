import entities.Usuario;
import ui.GuiCriarGaleria;
import ui.GuiLogin;
import ui.GuiMenuPrincipal;

public class Sistema {
    
    GerenciadorUsuarios gerenciador = new GerenciadorUsuarios();

    public static void main(String[] args) {


        Usuario usuario = new Usuario("java8", "java8");

       //GuiLogin telaLogin = new GuiLogin();
       //telaLogin.run();
        
        GuiCriarGaleria criarGaleria = new GuiCriarGaleria(usuario);
        criarGaleria.run();

    }
        
}
