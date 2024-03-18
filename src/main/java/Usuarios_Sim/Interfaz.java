package Usuarios_Sim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    private JButton botonIniciar;
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private Autenticacion autenticacion = new Autenticacion();

    public Interfaz() {
        setTitle("Simulación de Ecosistema");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        botonIniciar = new JButton("Iniciar Sesión");
        botonIniciar.setBounds(50, 200, 200, 30);
        add(botonIniciar);

        campoUsuario = new JTextField("Usuario");
        campoUsuario.setBounds(50, 50, 200, 30);
        add(campoUsuario);

        campoContrasena = new JPasswordField("Contraseña");
        campoContrasena.setBounds(50, 100, 200, 30);
        add(campoContrasena);

        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });
    }

    private void iniciarSesion() {
        String usuario = campoUsuario.getText();
        String contrasena = new String(campoContrasena.getPassword());
        if (autenticacion.verificarCredenciales(usuario, contrasena)) {
            System.out.println("Inicio de sesión exitoso");
            // Aquí puedes iniciar tu simulación
        } else {
            System.out.println("Inicio de sesión fallido");
        }
    }

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setVisible(true);
    }
}