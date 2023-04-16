package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Foto;
import entities.Galeria;
import entities.Usuario;

public class GuiTelaPreencherDadoFoto extends JFrame{

    private Usuario usuario;
    private JTextField tfDescricao;
    private JLabel lbDescricao;
    private JTextField tfData;
    private JLabel lbData;
    private JButton jbSalvar;
    private ImageIcon image;
    private String pathFotoSelecionada;
    private Galeria galeriaSelecionada;
    private JLabel lbimage;
    private JPanel painel;

    public GuiTelaPreencherDadoFoto(String pathFotoSelecionada, Galeria galeriaSelecionada, Usuario usuario) {
        this.pathFotoSelecionada = pathFotoSelecionada;
        this.galeriaSelecionada = galeriaSelecionada;
        this.usuario = usuario;
        inicializarComponentes();
        definirEventos();
    }

    public void inicializarComponentes() {
        setTitle("Tela para preencher dados da foto");
        setBounds(0, 0, 400, 500);
        setLayout(null);
        painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 400, 500);
        lbDescricao = new JLabel("Descrição:");
        lbDescricao.setBounds(80, 295, 80, 30);
        tfDescricao = new JTextField(10);
        tfDescricao.setBounds(150, 300, 200, 25);
        lbData = new JLabel("Data:");
        lbData.setBounds(115, 340, 80, 25);
        tfData = new JTextField(10);
        tfData.setBounds(150, 340, 100, 25);
        jbSalvar = new JButton("Salvar");
        jbSalvar.setBounds(150, 400, 100, 25);
        image = new ImageIcon(pathFotoSelecionada);
        lbimage = new JLabel(image);
        lbimage.setBounds(0, 0, 400, 300);
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
                String descricao = String.valueOf(tfDescricao.getText());
                String data = String.valueOf(tfData.getText());
                usuario.registrarFoto(galeriaSelecionada,(new Foto(galeriaSelecionada, descricao, data, pathFotoSelecionada)));
                GuiMenuPrincipal menu = new GuiMenuPrincipal(usuario);
                menu.run();
                dispose();
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
