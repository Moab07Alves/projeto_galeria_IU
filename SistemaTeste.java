import java.util.List;

import javax.swing.JOptionPane;

import controller.GerenciadorUsuarios;
import entities.Foto;
import entities.Galeria;
import entities.Usuario;

public class SistemaTeste {
    
    static GerenciadorUsuarios gerenciador = new GerenciadorUsuarios();
    public static void main(String[] args){
       
        //Usuario usuario1 = new Usuario("java8", "java8");
        //Usuario usuario2 = new Usuario("Moab", "moab07");
        
        /* 
        Usuario usuario2 = new Usuario("Moab", "moab07");
        Usuario usuario3 = new Usuario("Moab", "desouza04");
        Usuario usuario4 = new Usuario("Moany", "moab07");
        
----------------------------------------------------------------------------------------------
        Testando as funções do gerenciador de usuários e a persistenceias dos dados sobra o usuario

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

----------------------------------------------------------------------------------------------                     Testes das funcionalidades da classe usuário

        JOptionPane.showMessageDialog(null, usuario1.getQuantidadeGalerias());
        try {
            JOptionPane.showMessageDialog(null, usuario1.getGaleria());
            usuario1.criarGaleria("Meus aniversarios");
            usuario1.criarGaleria("Minhas Viagens");
            //usuario1.criarGaleria("Meus aniversarios");
            JOptionPane.showMessageDialog(null, usuario1.getGaleria());
            //JOptionPane.showMessageDialog(null, usuario1.procurarGaleriaPorTitulo("to com fome"));
            List<Galeria> listaGalerias = usuario1.todasGalerias();
            for (Galeria galeria: listaGalerias) {
                JOptionPane.showMessageDialog(null, galeria);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

----------------------------------------------------------------------------------------------        Teste das funções salvar e recuperar galerias do sistema do arquivo .txt em paralelo com a persistência de dados do usuário

        try {
            JOptionPane.showMessageDialog(null, gerenciador.usuariosDoSistema());
            gerenciador.cadastarUsuario(usuario1);
            gerenciador.cadastarUsuario(usuario2);
            JOptionPane.showMessageDialog(null, gerenciador.getUsuario("java8"));
            JOptionPane.showMessageDialog(null, gerenciador.getUsuario("Moab"));
            JOptionPane.showMessageDialog(null, "" + gerenciador.verificarPessoa("java8"));
            JOptionPane.showMessageDialog(null, "" + gerenciador.verificarPessoa("Moany"));
            gerenciador.getUsuario("java8").criarGaleria("Meus aniversários");
            gerenciador.getUsuario("java8").criarGaleria("Minha Viagens");
            gerenciador.salvarPessoas();
            gerenciador.recuperarPessoas();
            JOptionPane.showMessageDialog(null, gerenciador.getUsuario("java8").getGaleria());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
----------------------------------------------------------------------------------------------
        Testando a função de salvar dados de Gerenciador de usuários gravando em paralelo os usuários do sistema, as galerias desses usuários e as fotos das galerias desses usuários.        

        try {
            gerenciador.cadastarUsuario(usuario1);
            usuario1.criarGaleria("Meus Simbolos");
            Galeria galeria = usuario1.procurarGaleriaPorTitulo("Meus Simbolos");
            Foto foto1 = new Foto(galeria, "Foto azul de uma galeria", "23/12/2010", "/C:/Users/moab7/OneDrive/Área de Trabalho/imagens/Foto1.png");
            Foto foto2 = new Foto(galeria, "Foto minimalista de uma galeria", "24/02/2025", "/C:/Users/moab7/OneDrive/Área de Trabalho/imagens/Foto2.png");
            Foto foto3 = new Foto(galeria, "Foto de uma galeria preta e pequena", "07/04/2004", "/C:/Users/moab7/OneDrive/Área de Trabalho/imagens/Foto3.png" );
            galeria.adicionarFoto(foto1);
            galeria.adicionarFoto(foto2);
            galeria.adicionarFoto(foto3);
            gerenciador.salvarPessoas();
            List<Foto> fotos = gerenciador.getUsuario("java8").procurarGaleriaPorTitulo("Meus Simbolos").ListaFotos();
            
            for (Foto foto: fotos) {
                JOptionPane.showMessageDialog(null, foto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

----------------------------------------------------------------------------------------------
        Testando a função de recuperar dados de Gerenciador de usuários recuerando em paralelo dados gravados dos usuários do sistema, das galerias desses usuários e das fotos das galerias desses usuários.

         try {
            gerenciador.recuperarPessoas();
            gerenciador.cadastarUsuario(usuario2);
            List<Foto> fotos = gerenciador.getUsuario("java8").procurarGaleriaPorTitulo("Meus Simbolos").ListaFotos();
            
            for (Foto foto: fotos) {
                JOptionPane.showMessageDialog(null, foto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        */


    }
    
}
