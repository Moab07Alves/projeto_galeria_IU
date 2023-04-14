package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.Foto;
import entities.Galeria;
import entities.Usuario;

public class GuiMenuPrincipal extends JFrame{
    
    private Usuario usuario;
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao;
    private JPanel jpOpcoes;
    private JButton[] botoesOpcoes = new JButton[6];

    public GuiMenuPrincipal () {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes (){
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic('A');
        mnExemplos = new JMenu("Exemplos");
        mnExemplos.setMnemonic('E');
        miSair = new JMenuItem("Sair", new ImageIcon("sair.png"));
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        miBotao = new JMenuItem("Botao");
        mnArquivo.add(miSair);
        mnExemplos.add(miBotao);
        mnBarra.add(mnArquivo);
        mnBarra.add(mnExemplos);
        jpOpcoes = new JPanel();
        int x = getX() + 200;
        int y = getY();
        jpOpcoes.setLayout(null);
        botoesOpcoes[0] = new JButton("1- Criar galeria");
        botoesOpcoes[0].setBounds(x, y+40, 400, 35);
        botoesOpcoes[1] = new JButton("2- Adicionar foto");
        botoesOpcoes[1].setBounds(x, y+100, 400, 35);
        botoesOpcoes[2] = new JButton("3- Remover foto");
        botoesOpcoes[2].setBounds(x, y+160, 400, 35);
        botoesOpcoes[3] = new JButton("4- Ver fotos");
        botoesOpcoes[3].setBounds(x, y+220, 400, 35);
        botoesOpcoes[4] = new JButton("5- Procurar foto por data");
        botoesOpcoes[4].setBounds(x, y+280, 400, 35);
        botoesOpcoes[5] = new JButton("6- Procurar foto por filho");
        botoesOpcoes[5].setBounds(x, y+340, 400, 35);
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

        miBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        }); 

        botoesOpcoes[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiCriarGaleria guiCriarGaleria = new GuiCriarGaleria(usuario);
                guiCriarGaleria.run();
                setVisible(false);
            }
        });

        botoesOpcoes[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(usuario.getGaleria() != null) {
                    String nomeGaleria = JOptionPane.showInputDialog(null, usuario.getGaleria() + "Qual galeria você escolhe para adicionar a foto: ");
                    Galeria gale = usuario.procurarGaleriaPorTitulo(nomeGaleria);
                    File fotoEscolhida = mostrarEscolhaFoto();
                    String descricao = JOptionPane.showInputDialog(null, "Digite qual a descrição da foto");
                    String data = JOptionPane.showInputDialog(null, "Digite qual a data que a foto foi tirada?");
                    JOptionPane.showMessageDialog(null, "", "Descrição: " + descricao  + " Data: " + data, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(fotoEscolhida.getAbsolutePath()));
                    Foto novaFoto = new Foto(gale, descricao, data, fotoEscolhida.getAbsolutePath());
                    gale.adicionarFoto(novaFoto);
                }
                else {
                    JOptionPane.showMessageDialog(null, "O usuário não possui nenhuma galeria");
                }
            }
        });

        botoesOpcoes[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botoesOpcoes[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botoesOpcoes[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botoesOpcoes[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public void run() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((tela.width - getSize().width) / 2, (tela.height - getSize().height) / 2);
        setVisible(true);  
    }

    public static File mostrarEscolhaFoto() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivos de Imagem", "jpg", "jpeg", "png", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = chooser.getSelectedFile();
            return arquivoSelecionado;
        }
        return null;
    }

}
