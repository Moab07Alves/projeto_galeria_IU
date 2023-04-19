package ui.telasParaRemoverFotos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.GerenciadorUsuarios;
import entities.Foto;
import entities.Usuario;
import ui.telasParaVisualizarFotos.GuiSelecionarGaleriaVerFoto;
import ui.telasParaVisualizarFotos.GuiTelaComFotoVisualizar;

public class GuiSelecionarFotosRemover extends JFrame{
    
//------------------------------ Entidades de Domínio ------------------------------------------
    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private String tituloGaleriaSelecionada;
    private Foto fotoSelecionada;
// --------------------------------------------------------------------------------------------


    private JPanel telaFotos; 
    private JList lsFotos;
    private DefaultListModel dlm;
    private ImageIcon imagem1;
    private JScrollPane sp;
    private JLabel lbImagem;
    private JButton jbexcluirFoto;
    private JButton jbVoltar;

    public GuiSelecionarFotosRemover(GerenciadorUsuarios gerenciador, Usuario usuario, String tituloGaleriaSelecionada) throws Exception {
        this.gerenciador = gerenciador;
        this.usuario = usuario;
        this.tituloGaleriaSelecionada = tituloGaleriaSelecionada;
        incializarComponentes();
        definirEventos();
    }
    
    private void incializarComponentes() throws Exception {
        setTitle("Fotos da Galeria: " + tituloGaleriaSelecionada);
        setBounds(0, 0, 600, 315);
        telaFotos = new JPanel();
        telaFotos.setLayout(null);
        dlm = new DefaultListModel();

        List<Foto> fotosDaGaleria = gerenciador.getUsuario(usuario.getLogin()).procurarGaleriaPorTitulo(tituloGaleriaSelecionada).ListaFotos();
        
        for (int i = 0; i < fotosDaGaleria.size(); i++) {
            dlm.addElement(fotosDaGaleria.get(i).getDescricao());
        }
        
        lsFotos = new JList(dlm);
        sp = new JScrollPane(lsFotos);
        sp.setBounds(10, 20, 200, getHeight() - 75);
        imagem1 = new ImageIcon();
        lbImagem = new JLabel(imagem1);
        lbImagem.setBounds(300, 30, 200,200);
        jbexcluirFoto = new JButton("Excluir foto");
        jbexcluirFoto.setBounds(350, 245, 100, 25);
        jbexcluirFoto.setVisible(false);
        jbexcluirFoto.setBounds(420, 245, 100, 25);
        jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(280, 245, 100, 25);
        telaFotos.add(jbexcluirFoto);
        telaFotos.add(sp);
        telaFotos.add(lbImagem);
        telaFotos.add(jbVoltar);
        add(telaFotos);
    }

    private void definirEventos() {
        lsFotos.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                try {
                    fotoSelecionada = gerenciador.getUsuario(usuario.getLogin()).   procurarGaleriaPorTitulo(tituloGaleriaSelecionada).getFoto(String.valueOf  (lsFotos.getSelectedValue()));
                    imagem1 = new ImageIcon(fotoSelecionada.getPathFoto());
                    lbImagem.setIcon(imagem1);
                    jbexcluirFoto.setVisible(true);
                } catch (Exception x) {
                    //Não irá lançar execessão
                }
            }
        });

        jbexcluirFoto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               GuiTelaComFotoRemover telaComFotoRemover = new GuiTelaComFotoRemover(gerenciador, usuario, tituloGaleriaSelecionada, fotoSelecionada);
               telaComFotoRemover.run();
               dispose();
            }
        });  

        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GuiSelecionarGaleriaRemoverFoto tSelecionarGaleriaRemoverFoto = new GuiSelecionarGaleriaRemoverFoto(gerenciador, usuario);
                    tSelecionarGaleriaRemoverFoto.run();
                    dispose();
                } catch (Exception x) {
                    //Não irá lançar execessão
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
