package Trabalho.MVC.Visao;

import Trabalho.MVC.Controle.Controle;

import java.util.Scanner;

import javax.swing.*;
import java.awt.*;


public class ClienteVisao extends Visao {

    public ClienteVisao(Controle pControle, Scanner pScanner) { super(pControle, pScanner); }

    @Override
    public void TelaInserir() {
        JFrame TelaClienteInserir = new JFrame();
        TelaClienteInserir.setSize(600, 500);
        TelaClienteInserir.setResizable(false);
        TelaClienteInserir.setLocationRelativeTo(null);
        JLabel TituloNoFrame = new JLabel("Cadastro de Cliente");
        TituloNoFrame.setBorder(BorderFactory.createRaisedBevelBorder());
        TelaClienteInserir.add(TituloNoFrame, BorderLayout.NORTH);

    }

    @Override
    public void TelaExcluir() {

    }
}
