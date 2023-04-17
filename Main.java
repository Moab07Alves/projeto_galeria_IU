import javax.swing.JOptionPane;

import controller.GerenciadorUsuarios;
import entities.Foto;
import entities.Galeria;
import entities.Usuario;

public class Main {
    
    static GerenciadorUsuarios gerenciador = new GerenciadorUsuarios();
    public static void main(String[] args){
       
        Usuario usuario1 = new Usuario("java8", "java8");
        Usuario usuario2 = new Usuario("Moab", "moab07");
        Usuario usuario3 = new Usuario("Moab", "desouza04");
        Usuario usuario4 = new Usuario("Moany", "moab07");

        try {
            gerenciador.recuperarPessoas();
            JOptionPane.showMessageDialog(null, gerenciador.usuariosDoSistema());
            gerenciador.cadastarUsuario(usuario1);
            gerenciador.cadastarUsuario(usuario2);
            JOptionPane.showMessageDialog(null, gerenciador.getUsuario("java8"));
            JOptionPane.showMessageDialog(null, gerenciador.getUsuario("Moab"));
            JOptionPane.showMessageDialog(null, "" + gerenciador.verificarPessoa("java8"));
            JOptionPane.showMessageDialog(null, "" + gerenciador.verificarPessoa("Moany"));
            gerenciador.salvarPessoas();
            gerenciador.recuperarPessoas();
            JOptionPane.showMessageDialog(null, gerenciador.usuariosDoSistema());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    

    }
    
}
