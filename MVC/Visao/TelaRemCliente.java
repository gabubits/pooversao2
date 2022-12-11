package Trabalho.MVC.Visao;

import Trabalho.MVC.Controle.Controle;
import Trabalho.MVC.Visao.AbstractTables.AbstractTableCliente;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRemCliente extends JFrame {

    private JLabel TituloNoFrame;
    private JPanel PainelCentral;
    private JPanel PainelTabela;
    private JTable tabelaCliente;
    private JScrollPane SPtabelaCliente;
    private AbstractTableCliente ModeloTabelaCliente1;
    private JButton BotaoRemover;

    public TelaRemCliente(Controle pControle) {
        ModeloTabelaCliente1 = new AbstractTableCliente(pControle);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManager.put("MenuItem.background", Color.BLACK);

        TituloNoFrame = new JLabel("Remoção de Cliente", SwingConstants.CENTER);
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
                if (tabelaCliente.getSelectedRow() != -1){
                    ModeloTabelaCliente1.removeRow(tabelaCliente.getSelectedRow());
                }
            }
        });

        PainelCentral = new JPanel();
        PainelCentral.setLayout(new FlowLayout());
        PainelCentral.setOpaque(true);
        PainelCentral.setBackground(Color.BLACK);

        tabelaCliente = new JTable();
        tabelaCliente.setModel(ModeloTabelaCliente1);
        tabelaCliente.setOpaque(true);
        tabelaCliente.setBackground(Color.BLACK);
        tabelaCliente.setBorder(new LineBorder(Color.BLACK));
        tabelaCliente.setForeground(Color.WHITE);
        tabelaCliente.setFillsViewportHeight(true);
        tabelaCliente.getTableHeader().setResizingAllowed(false);
        tabelaCliente.getTableHeader().setReorderingAllowed(false);
        JTableHeader tabelaClienteHeader = tabelaCliente.getTableHeader();
        tabelaClienteHeader.setBackground(Color.BLACK);
        tabelaClienteHeader.setForeground(Color.WHITE);
        tabelaClienteHeader.setFont(new Font(null, Font.BOLD, 10));

        SPtabelaCliente = new JScrollPane(tabelaCliente);

        PainelTabela = new JPanel();
        PainelTabela.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE), "Clientes Cadastrados", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                null, Color.WHITE));
        PainelTabela.setPreferredSize(new Dimension(565, 450));
        PainelTabela.setOpaque(true);
        PainelTabela.setBackground(Color.BLACK);
        PainelTabela.setLayout(new BorderLayout());
        PainelTabela.add(SPtabelaCliente, BorderLayout.CENTER);

        PainelCentral.add(PainelTabela);
        PainelCentral.add(BotaoRemover);
        add(PainelCentral, BorderLayout.CENTER);
    }

}
