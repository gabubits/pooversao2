package Trabalho.MVC.Visao;

import Trabalho.MVC.Controle.Controle;
import Trabalho.MVC.Modelo.Filme;
import Trabalho.MVC.Visao.AbstractTables.AbstractTableFilme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInsFilme extends JFrame {

    private JLabel TituloNoFrame;
    private JPanel PainelCentral;
    private JPanel PainelDadosFilme;
    private JPanel PainelTabela;
    private JLabel LabelTitulo, LabelFaixaEtaria, LabelGenero;
    private JTextField TFTitulo, TFfaixaEtaria, TFGenero;
    private JButton BotaoSalvar, BotaoCancelar;
    private JTable tabelaFilme;
    private JScrollPane SPtabelaFilme;

    public TelaInsFilme(Controle pControle, JFrame frame, AbstractTableFilme Modelo) {
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TituloNoFrame = new JLabel("Cadastro de Filmes", SwingConstants.CENTER);
        TituloNoFrame.setFont(new Font(null, Font.BOLD, 30));
        TituloNoFrame.setBorder(new LineBorder(Color.WHITE));
        TituloNoFrame.setLayout(new GridBagLayout());
        TituloNoFrame.setPreferredSize(new Dimension(1, 45));
        TituloNoFrame.setForeground(Color.WHITE);
        TituloNoFrame.setOpaque(true);
        TituloNoFrame.setBackground(Color.BLACK);
        add(TituloNoFrame, BorderLayout.NORTH);

        PainelCentral = new JPanel();
        PainelCentral.setLayout(new FlowLayout());
        PainelCentral.setOpaque(true);
        PainelCentral.setBackground(Color.BLACK);

        PainelDadosFilme = new JPanel();
        PainelDadosFilme.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE), "Dados do Filme", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                null, Color.WHITE));
        PainelDadosFilme.setPreferredSize(new Dimension(565, 200));
        PainelDadosFilme.setOpaque(true);
        PainelDadosFilme.setBackground(Color.BLACK);

        LabelTitulo = new JLabel("Titulo do Filme:");
        LabelTitulo.setForeground(Color.WHITE);
        TFTitulo = new JTextField(15);
        TFTitulo.setOpaque(true);
        TFTitulo.setBackground(Color.BLACK);
        TFTitulo.setForeground(Color.WHITE);
        TFTitulo.setBorder(new LineBorder(Color.WHITE));

        LabelFaixaEtaria = new JLabel("Faixa Etária:");
        LabelFaixaEtaria.setForeground(Color.WHITE);
        TFfaixaEtaria = new JTextField(15);
        TFfaixaEtaria.setOpaque(true);
        TFfaixaEtaria.setBackground(Color.BLACK);
        TFfaixaEtaria.setForeground(Color.WHITE);
        TFfaixaEtaria.setBorder(new LineBorder(Color.WHITE));

        LabelGenero = new JLabel("Genero do Filme:");
        LabelGenero.setForeground(Color.WHITE);
        TFGenero = new JTextField(15);
        TFGenero.setOpaque(true);
        TFGenero.setBackground(Color.BLACK);
        TFGenero.setForeground(Color.WHITE);
        TFGenero.setBorder(new LineBorder(Color.WHITE));

        BotaoSalvar = new JButton("Salvar");

        BotaoSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (TFTitulo.getText().isEmpty() || TFGenero.getText().isEmpty() || TFfaixaEtaria.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Algum dos campos não foram preenchidos corretamente!",
                            "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
                else if (pControle.BuscarString(TFTitulo.getText()) != null){
                    JOptionPane.showMessageDialog(null, "Titulo do filme já cadastrado!",
                            "ERRO!", JOptionPane.ERROR_MESSAGE);
                    TFTitulo.setText("");
                }
                else {
                    Filme filme = new Filme();
                    filme.setTitulo(TFTitulo.getText());
                    filme.setGenero(TFGenero.getText());
                    filme.setFaixaEtaria(Integer.parseInt(TFfaixaEtaria.getText()));
                    Modelo.addRow(filme);
                    JOptionPane.showMessageDialog(null, "Filme cadastrado com sucesso!",
                            "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    TFTitulo.setText("");
                    TFfaixaEtaria.setText("");
                    TFGenero.setText("");
                }
            }
        });



        BotaoCancelar = new JButton("Cancelar");

        BotaoCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (TFTitulo.getText().isEmpty() && TFfaixaEtaria.getText().isEmpty() && TFGenero.getText().isEmpty()){
                    dispose();
                    frame.setVisible(true);
                }
                if (!TFTitulo.getText().isEmpty() || !TFfaixaEtaria.getText().isEmpty() || !TFGenero.getText().isEmpty()){
                    String[] opcoes = {"SIM", "NÃO"};
                    int aux = JOptionPane.showOptionDialog(null, "Deseja realmente descartar o cadastro atual?",
                            "ATENÇÃO!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
                    if (aux == 0) {
                        dispose();
                        TFTitulo.setText("");
                        TFfaixaEtaria.setText("");
                        TFGenero.setText("");
                        frame.setVisible(true);
                    }
                }
            }
        });


        GroupLayout layoutDP = new GroupLayout(PainelDadosFilme);
        PainelDadosFilme.setLayout(layoutDP);
        layoutDP.setAutoCreateContainerGaps(true);
        layoutDP.setHorizontalGroup(
                layoutDP
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layoutDP.createSequentialGroup()
                                        .addComponent(LabelTitulo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFTitulo, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(layoutDP.createSequentialGroup()
                                        .addComponent(LabelFaixaEtaria, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFfaixaEtaria, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(layoutDP.createSequentialGroup()
                                        .addComponent(LabelGenero, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFGenero, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(layoutDP.createSequentialGroup()
                                        .addComponent(BotaoSalvar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGap(25)
                                        .addComponent(BotaoCancelar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                )
                        )
        );
        layoutDP.setVerticalGroup(
                layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutDP.createSequentialGroup()
                                .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelTitulo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFTitulo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(15)
                                .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelFaixaEtaria, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFfaixaEtaria, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(15)
                                .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelGenero, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFGenero, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(25)
                                .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(BotaoSalvar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotaoCancelar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                        )
        );

        tabelaFilme = new JTable();
        tabelaFilme.setModel(Modelo);
        tabelaFilme.setOpaque(true);
        tabelaFilme.setBackground(Color.BLACK);
        tabelaFilme.setBorder(new LineBorder(Color.BLACK));
        tabelaFilme.setForeground(Color.WHITE);
        tabelaFilme.setFillsViewportHeight(true);
        tabelaFilme.setRowSelectionAllowed(false);
        tabelaFilme.getTableHeader().setResizingAllowed(false);
        tabelaFilme.getTableHeader().setReorderingAllowed(false);
        JTableHeader tabelaFilmeHeader = tabelaFilme.getTableHeader();
        tabelaFilmeHeader.setBackground(Color.BLACK);
        tabelaFilmeHeader.setForeground(Color.WHITE);
        tabelaFilmeHeader.setFont(new Font(null, Font.BOLD, 10));

        SPtabelaFilme = new JScrollPane(tabelaFilme);

        PainelTabela = new JPanel();
        PainelTabela.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE), "Filmes Cadastrados", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                null, Color.WHITE));
        PainelTabela.setPreferredSize(new Dimension(565, 300));
        PainelTabela.setOpaque(true);
        PainelTabela.setBackground(Color.BLACK);
        PainelTabela.setLayout(new BorderLayout());
        PainelTabela.add(SPtabelaFilme, BorderLayout.CENTER);

        PainelCentral.add(PainelDadosFilme);
        PainelCentral.add(PainelTabela);
        add(PainelCentral, BorderLayout.CENTER);


    }


}