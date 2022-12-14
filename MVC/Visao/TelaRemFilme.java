package Trabalho.MVC.Visao;

import Trabalho.MVC.Controle.Controle;
import Trabalho.MVC.Visao.AbstractTables.AbstractTableFilme;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRemFilme extends JFrame {
    
    private JLabel TituloNoFrame;
    private JPanel PainelCentral;
    private JPanel PainelTabela;
    private JTable tabelaFilmes;
    private JScrollPane SPtabelaFilmes;
    private JButton BotaoRemover;

    public TelaRemFilme(Controle pControle, AbstractTableFilme Modelo) {
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManager.put("MenuItem.background", Color.BLACK);

        UIManager.put("MenuItem.background", Color.BLACK);

        TituloNoFrame = new JLabel("Remoção de Filmes", SwingConstants.CENTER);
        TituloNoFrame.setFont(new Font(null, Font.BOLD, 30));
        TituloNoFrame.setBorder(new LineBorder(Color.WHITE));
        TituloNoFrame.setLayout(new GridBagLayout());
        TituloNoFrame.setPreferredSize(new Dimension(1, 45));
        TituloNoFrame.setForeground(Color.WHITE);
        TituloNoFrame.setOpaque(true);
        TituloNoFrame.setBackground(Color.BLACK);
        add(TituloNoFrame, BorderLayout.NORTH);

        BotaoRemover = new JButton("Remover");
        BotaoRemover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabelaFilmes.getSelectedRow() != -1) {
                    Modelo.removeRow(tabelaFilmes.getSelectedRow());
                }
            }
        });
        PainelCentral = new JPanel();
        PainelCentral.setLayout(new FlowLayout());
        PainelCentral.setOpaque(true);
        PainelCentral.setBackground(Color.BLACK);

        tabelaFilmes = new JTable();
        tabelaFilmes.setModel(Modelo);
        tabelaFilmes.setOpaque(true);
        tabelaFilmes.setBackground(Color.BLACK);
        tabelaFilmes.setBorder(new LineBorder(Color.BLACK));
        tabelaFilmes.setForeground(Color.WHITE);
        tabelaFilmes.setFillsViewportHeight(true);
        tabelaFilmes.getTableHeader().setResizingAllowed(false);
        tabelaFilmes.getTableHeader().setReorderingAllowed(false);
        JTableHeader tabelaFilmesHeader = tabelaFilmes.getTableHeader();
        tabelaFilmesHeader.setBackground(Color.BLACK);
        tabelaFilmesHeader.setForeground(Color.WHITE);
        tabelaFilmesHeader.setFont(new Font(null, Font.BOLD, 10));

        SPtabelaFilmes = new JScrollPane(tabelaFilmes);

        PainelTabela = new JPanel();
        PainelTabela.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE), "Filmes Cadastrados", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                null, Color.WHITE));
        PainelTabela.setPreferredSize(new Dimension(565, 450));
        PainelTabela.setOpaque(true);
        PainelTabela.setBackground(Color.BLACK);
        PainelTabela.setLayout(new BorderLayout());
        PainelTabela.add(SPtabelaFilmes, BorderLayout.CENTER);

        PainelCentral.add(PainelTabela);
        PainelCentral.add(BotaoRemover);
        add(PainelCentral, BorderLayout.CENTER);
    }
}
