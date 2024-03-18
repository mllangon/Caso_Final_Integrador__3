package Usuarios_Sim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    private JButton botonIniciar;
    private JTextField campoParametro;

    public Interfaz() {
        setTitle("Simulación de Ecosistema");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        botonIniciar = new JButton("Iniciar Simulación");
        botonIniciar.setBounds(50, 50, 200, 30);
        add(botonIniciar);

        campoParametro = new JTextField("Ingrese un parámetro");
        campoParametro.setBounds(50, 100, 200, 30);
        add(campoParametro);

        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSimulacion();
            }
        });
    }

    private void iniciarSimulacion() {
        String parametro = campoParametro.getText();
        // Aquí puedes iniciar tu simulación con el parámetro ingresado
        System.out.println("Iniciando simulación con parámetro: " + parametro);
    }

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }
}