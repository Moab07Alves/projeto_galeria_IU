package ui.telasParaRemoverFotos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Foto;
import entities.Usuario;

public class GuiTelaComFotoRemover extends JFrame{    
      
//------------------------------ Entidades de Domínio ------------------------------------------
    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private String tituloGaleriaSelecionada;
    private Foto fotoSelecionada;
//----------------------------------------------------------------------------------------------

    private JPanel painel;
    private JLabel lbDescricao;
    private JLabel lbData;
    private JLabel lbimagem;
    private ImageIcon imagem;
    private JButton jbvoltar;
    private JButton jbExcluir;

    public GuiTelaComFotoRemover(GerenciadorUsuarios gerenciador, Usuario usuario, String tituloGaleriaSelecionada, Foto fotoSelecionada) {
        this.gerenciador = gerenciador;
        this.usuario = usuario;
        this.tituloGaleriaSelecionada = tituloGaleriaSelecionada;
        this.fotoSelecionada = fotoSelecionada;
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setTitle("Foto selecionada");
        setBounds(0, 0, 800, 600);
        setLayout(null);
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 800, 600);
        lbDescricao = new JLabel("Descrição: " + fotoSelecionada.getDescricao());
        lbDescricao.setBounds(10, 5, 600, 100);
        lbDescricao.setFont(new Font("Arial", Font.BOLD, 15));
        lbData = new JLabel("Data: " + fotoSelecionada.getDataFoto());
        lbData.setBounds(10, 20, 300, 100);
        lbData.setFont(new Font("Arial", Font.BOLD, 15));
        jbvoltar = new JButton("Voltar");
        jbvoltar.setBounds(290, 525, 100, 25);
        jbExcluir = new JButton("Excluir");
        jbExcluir.setBounds(430, 525, 100, 25);
        imagem = new ImageIcon(fotoSelecionada.getPathFoto());
        imagem.setImage(imagem.getImage().getScaledInstance(650, 425, 1));
        lbimagem = new JLabel(imagem);
        lbimagem.setBounds(75, 90, 650, 425);
        painel.add(lbimagem);
        painel.add(jbvoltar);
        painel.add(jbExcluir);
        painel.add(lbDescricao);
        painel.add(lbData);
        add(painel);
    }

    public void definirEventos() {
        jbExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    gerenciador.getUsuario(usuario.getLogin()).excluirFoto(gerenciador.getUsuario(usuario.getLogin()).procurarGaleriaPorTitulo(tituloGaleriaSelecionada), fotoSelecionada);
                    gerenciador.salvarPessoas();

                   if (gerenciador.getUsuario(usuario.getLogin()).procurarGaleriaPorTitulo(tituloGaleriaSelecionada).getQuantidadeFotos() == 0) {
                        GuiSelecionarGaleriaRemoverFoto tSelecionarGaleriaRemoverFoto = new GuiSelecionarGaleriaRemoverFoto(gerenciador, usuario);
                        tSelecionarGaleriaRemoverFoto.run();
                        dispose();
                    }
                    else {
                        GuiSelecionarFotosRemover tSelecionarFotosRemover = new         GuiSelecionarFotosRemover(gerenciador, usuario, tituloGaleriaSelecionada);
                        tSelecionarFotosRemover.run();
                        dispose();
                    }
                } catch (Exception x) {
                    //não irá lançar execessão
                }
            }
        });

        jbvoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //Implementar a função do botão Voltar
               try {
                if (gerenciador.getUsuario(usuario.getLogin()).procurarGaleriaPorTitulo(tituloGaleriaSelecionada).getQuantidadeFotos() == 0) {
                    GuiSelecionarGaleriaRemoverFoto tSelecionarGaleriaRemoverFoto = new GuiSelecionarGaleriaRemoverFoto(gerenciador, usuario);
                    tSelecionarGaleriaRemoverFoto.run();
                    dispose();
                }
                else {
                    GuiSelecionarFotosRemover tSelecionarFotosRemover = new     GuiSelecionarFotosRemover(gerenciador, usuario, tituloGaleriaSelecionada);
                    tSelecionarFotosRemover.run();
                    dispose();
                }
               } catch (Exception x) {
                 // Não vai lançar execesssão
               }
            }
        });
    }

    public void run() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }


}
