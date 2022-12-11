package Trabalho.MVC.Visao;

import Trabalho.MVC.Controle.Controle;
import Trabalho.MVC.Modelo.Cliente;
import Trabalho.MVC.Visao.AbstractTables.AbstractTableCliente;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaInsCliente extends JFrame {

    private JLabel TituloNoFrame;
    private JPanel PainelCentral;
    private JPanel PainelDadosPessoais;
    private JPanel PainelTabela;
    private JLabel LabelNome, LabelCPF, LabelIdade;
    private JTextField TFNome, TFIdade;
    private JFormattedTextField TFCPF;
    private JButton BotaoSalvar, BotaoCancelar;
    private JTable tabelaCliente;
    private JScrollPane SPtabelaCliente;

    public TelaInsCliente(Controle pControle, JFrame frame, AbstractTableCliente Modelo) {
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TituloNoFrame = new JLabel("Cadastro de Cliente", SwingConstants.CENTER);
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

        PainelDadosPessoais = new JPanel();
        PainelDadosPessoais.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.WHITE), "Dados Pessoais", TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
                null, Color.WHITE));
        PainelDadosPessoais.setPreferredSize(new Dimension(565, 200));
        PainelDadosPessoais.setOpaque(true);
        PainelDadosPessoais.setBackground(Color.BLACK);

        LabelNome = new JLabel("Nome:");
        LabelNome.setForeground(Color.WHITE);
        TFNome = new JTextField(15);
        TFNome.setOpaque(true);
        TFNome.setBackground(Color.BLACK);
        TFNome.setForeground(Color.WHITE);
        TFNome.setBorder(new LineBorder(Color.WHITE));

        LabelCPF = new JLabel("CPF:");
        LabelCPF.setForeground(Color.WHITE);
        TFCPF = new JFormattedTextField();
        TFCPF.setOpaque(true);
        TFCPF.setBackground(Color.BLACK);
        TFCPF.setBorder(new LineBorder(Color.WHITE));

        try {
            MaskFormatter MascaraCPF = new MaskFormatter("###.###.###-##");
            MascaraCPF.install(TFCPF);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro formato campo de texto", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        TFCPF.setForeground(Color.WHITE);

        LabelIdade = new JLabel("Idade:");
        LabelIdade.setForeground(Color.WHITE);
        TFIdade = new JTextField(15);
        TFIdade.setOpaque(true);
        TFIdade.setBackground(Color.BLACK);
        TFIdade.setForeground(Color.WHITE);
        TFIdade.setBorder(new LineBorder(Color.WHITE));

        BotaoSalvar = new JButton("Salvar");
        BotaoSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (TFNome.getText().isEmpty() || TFCPF.getText().equals("   .   .   -  ") || TFIdade.getText().isEmpty()
                    || TFCPF.getText().length() != 14){
                    JOptionPane.showMessageDialog(null, "Algum dos campos não foram preenchidos corretamente!",
                                                    "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
                else if (pControle.BuscarString(TFCPF.getText()) != null){
                    JOptionPane.showMessageDialog(null, "Usuário com o CPF já cadastrado!",
                            "ERRO!", JOptionPane.ERROR_MESSAGE);
                    TFCPF.setText("");
                }
                else {
                    Cliente cliente = new Cliente();
                    cliente.setNome(TFNome.getText());
                    cliente.setCpf(TFCPF.getText());
                    cliente.setIdade(Integer.parseInt(TFIdade.getText()));
                    Modelo.addRow(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                            "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    TFNome.setText("");
                    TFIdade.setText("");
                    TFCPF.setText("");
                }
            }
        });

        BotaoCancelar = new JButton("Cancelar");
        BotaoCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (TFNome.getText().isEmpty() && TFCPF.getText().equals("   .   .   -  ") && TFIdade.getText().isEmpty()){
                    dispose();
                    frame.setVisible(true);
                }
                if (!TFNome.getText().isEmpty() || !TFCPF.getText().equals("   .   .   -  ") || !TFIdade.getText().isEmpty()){
                    String[] opcoes = {"SIM", "NÃO"};
                    int aux = JOptionPane.showOptionDialog(null, "Deseja realmente descartar o cadastro atual?",
                            "ATENÇÃO!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
                    if (aux == 0) {
                        dispose();
                        TFNome.setText("");
                        TFCPF.setText("");
                        TFIdade.setText("");
                        frame.setVisible(true);
                    }
                }
            }
        });

        GroupLayout layoutDP = new GroupLayout(PainelDadosPessoais);
        PainelDadosPessoais.setLayout(layoutDP);
        layoutDP.setAutoCreateContainerGaps(true);
        layoutDP.setHorizontalGroup(
                layoutDP
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layoutDP.createSequentialGroup()
                                        .addComponent(LabelNome, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFNome, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(layoutDP.createSequentialGroup()
                                        .addComponent(LabelCPF, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFCPF, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(layoutDP.createSequentialGroup()
                                        .addComponent(LabelIdade, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFIdade, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(LabelNome, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFNome, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(15)
                                .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelCPF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFCPF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(15)
                                .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(LabelIdade, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TFIdade, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(25)
                                .addGroup(layoutDP.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(BotaoSalvar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotaoCancelar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                )
                        )
        );

        tabelaCliente = new JTable();
        tabelaCliente.setModel(Modelo);
        tabelaCliente.setOpaque(true);
        tabelaCliente.setBackground(Color.BLACK);
        tabelaCliente.setBorder(new LineBorder(Color.BLACK));
        tabelaCliente.setForeground(Color.WHITE);
        tabelaCliente.setFillsViewportHeight(true);
        tabelaCliente.setRowSelectionAllowed(false);
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
        PainelTabela.setPreferredSize(new Dimension(565, 300));
        PainelTabela.setOpaque(true);
        PainelTabela.setBackground(Color.BLACK);
        PainelTabela.setLayout(new BorderLayout());
        PainelTabela.add(SPtabelaCliente, BorderLayout.CENTER);

        PainelCentral.add(PainelDadosPessoais);
        PainelCentral.add(PainelTabela);
        add(PainelCentral, BorderLayout.CENTER);
    }

}
