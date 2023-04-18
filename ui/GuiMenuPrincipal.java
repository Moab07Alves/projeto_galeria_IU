package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.GerenciadorUsuarios;
import entities.Usuario;

public class GuiMenuPrincipal extends JFrame{
    
    private GerenciadorUsuarios gerenciador;
    private Usuario usuario;
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnConfig;
    private JMenuItem miSair;
    private JPanel jpOpcoes;
    private JButton[] botoesOpcoes = new JButton[6];

    public GuiMenuPrincipal (GerenciadorUsuarios gerenciador, Usuario usuario) {
        this.gerenciador = gerenciador;
        this.usuario = usuario;
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes (){
        setTitle("Menu Principal");
        setBounds(0, 0, 425, 315);
        contentPane = getContentPane();
        mnBarra = new JMenuBar();
        mnConfig = new JMenu("Opções");
        mnConfig.setMnemonic('O');
        miSair = new JMenuItem("Sair");
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));

        mnConfig.add(miSair);
        mnBarra.add(mnConfig);
        jpOpcoes = new JPanel();
        int x = getX() + 5;
        int y = getY();
        jpOpcoes.setLayout(null);
        botoesOpcoes[0] = new JButton("1- Criar galeria");
        botoesOpcoes[0].setBounds(x, y+10, 400, 35);
        botoesOpcoes[1] = new JButton("2- Adicionar foto");
        botoesOpcoes[1].setBounds(x, y+50, 400, 35);
        botoesOpcoes[2] = new JButton("3- Remover foto");
        botoesOpcoes[2].setBounds(x, y+90, 400, 35);
        botoesOpcoes[3] = new JButton("4- Ver fotos");
        botoesOpcoes[3].setBounds(x, y+130, 400, 35);
        botoesOpcoes[4] = new JButton("5- Procurar foto por data");
        botoesOpcoes[4].setBounds(x, y+170, 400, 35);
        botoesOpcoes[5] = new JButton("6- Procurar foto por filho");
        botoesOpcoes[5].setBounds(x, y+210, 400, 35);
        jpOpcoes.add(botoesOpcoes[0]);
        jpOpcoes.add(botoesOpcoes[1]);
        jpOpcoes.add(botoesOpcoes[2]);
        jpOpcoes.add(botoesOpcoes[3]);
        jpOpcoes.add(botoesOpcoes[4]);
        jpOpcoes.add(botoesOpcoes[5]);
        add(jpOpcoes);
        setJMenuBar(mnBarra);
    }

    private void definirEventos () {
        miSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botoesOpcoes[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //implementar Função do Botão de Criar galeria
                GuiCriarGaleria telaCriarGaleria = new GuiCriarGaleria(gerenciador, usuario);
                telaCriarGaleria.run();
                dispose();
            }
        });

        botoesOpcoes[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 //implementar função do botão de Adicionar foto
                 if (gerenciador.getUsuario(usuario.getLogin()).getQuantidadeGalerias() == 0) {
                    JOptionPane.showMessageDialog(null, "O usuário não possui galerias, por isso ainda não pode adicionar fotos, é necessário que crie pelo menos uma galeria");
                 } 
                 else {
                    try {
                        GuiSelecionarGaleriaAdiconarFoto telaAdicionarFoto = new GuiSelecionarGaleriaAdiconarFoto(gerenciador, usuario);
                        telaAdicionarFoto.run();
                        dispose();
                    } catch (Exception x) {
                        // A excessão foi tratada de outra forma então nunca irá lançar a execessão para qual esse try catch foi criado.
                    }
                 }
            }
        });

        botoesOpcoes[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 //implementar função do botão de Remover foto
            }
        });

        botoesOpcoes[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //implementar função do botão de Ver fotos
                if (gerenciador.getUsuario(usuario.getLogin()).getQuantidadeGalerias() == 0) {
                    JOptionPane.showMessageDialog(null, "O usuário não possui galerias");
                } 
                else {
                    try {
                        GuiSelecionarGaleriaVerFoto telaSelecionarGaleriaVerFoto = new GuiSelecionarGaleriaVerFoto(gerenciador, usuario);
                       telaSelecionarGaleriaVerFoto.run();
                      dispose();
                    } catch (Exception x) {
                       // A excessão foi tratada de outra forma então nunca irá lançar a execessão para qual esse try catch foi criado.
                    }
                }
            }
        });

        botoesOpcoes[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //implementar função do botão de Procurar foto por data
            }
        });

        botoesOpcoes[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 //implementar função do botão  de Procurar foto por filho
            }
        });

    }

    public void run() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);  
    }

}
