package ui.telasParaAdiconarFotos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Foto;
import entities.Galeria;
import entities.Usuario;
import ui.telasDeMenu.GuiMenuPrincipal;

public class GuiTelaPreencherDadoFoto extends JFrame{

//------------------------------ Entidades de Domínio ------------------------------------------
    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private String tituloGaleriaSelecionada;
    private Foto fotoSelecionada;
    private String pathFotoSelecionada;
// --------------------------------------------------------------------------------------------
    
    private JTextField tfDescricao;
    private JLabel lbDescricao;
    private JTextField tfData;
    private JLabel lbData;
    private JButton jbSalvar;
    private ImageIcon image;
    private JLabel lbimage;
    private JPanel painel;

    public GuiTelaPreencherDadoFoto(GerenciadorUsuarios gerenciador, Usuario usuario, String tituloGaleriaSelecionada, String pathFotoSelecionada) {
        this.gerenciador = gerenciador;
        this.usuario = usuario;
        this.tituloGaleriaSelecionada = tituloGaleriaSelecionada;
        this.pathFotoSelecionada =pathFotoSelecionada;
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setTitle("Tela para preencher dados da foto");
        setBounds(0, 0, 800, 600);
        setLayout(null);
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 800, 600);
        lbDescricao = new JLabel("Descrição:");
        lbDescricao.setBounds(235, 425, 80, 30);
        tfDescricao = new JTextField(10);
        tfDescricao.setBounds(300, 430, 200, 25);
        lbData = new JLabel("Data:");
        lbData.setBounds(260, 460, 80, 25);
        tfData = new JTextField(10);
        tfData.setBounds(300, 460, 100, 25);
        jbSalvar = new JButton("Salvar");
        jbSalvar.setBounds(300, 510, 100, 25);
        image = new ImageIcon(pathFotoSelecionada);
        image.setImage(image.getImage().getScaledInstance(650, 400, 1));
        lbimage = new JLabel(image);
        lbimage.setBounds(75, 10, 650, 400);
        painel.add(lbimage);
        painel.add(lbDescricao);
        painel.add(tfDescricao);
        painel.add(lbData);
        painel.add(tfData);
        painel.add(jbSalvar);
        add(painel);
    }

    public void definirEventos() {
        jbSalvar.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                //Implementar a função do botão Salvar
                try {
                    String descricao = String.valueOf(tfDescricao.getText());
                    String data = String.valueOf(tfData.getText());
                    fotoSelecionada = new Foto(gerenciador.getUsuario(usuario.getLogin()).procurarGaleriaPorTitulo(tituloGaleriaSelecionada), descricao, data, pathFotoSelecionada);
                    gerenciador.getUsuario(usuario.getLogin()).registrarFoto(gerenciador.getUsuario(usuario.getLogin()).procurarGaleriaPorTitulo(tituloGaleriaSelecionada), fotoSelecionada);
                    JOptionPane.showMessageDialog(null, "Foto foi adicionada a galeria " + tituloGaleriaSelecionada + " com sucesso");
                    gerenciador.salvarPessoas();
                    dispose();
                    GuiMenuPrincipal telaMenu = new GuiMenuPrincipal(gerenciador, usuario);
                    telaMenu.run();
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null, x.getMessage());
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
