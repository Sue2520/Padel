package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Controllers.*;
import Models.usuarios;

public class inicioUsers {
    public JPanel panel1;
    private JTextField dniTxt;
    private JPasswordField passwdTxt;
    private JLabel dniLbl;
    private JLabel passwdLbl;
    private JButton iniciarSesionButton;
    public JLabel errorLbl;
    controlador c = new controlador();



    public inicioUsers() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.checkUser(dniTxt.getText(),passwdTxt.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
