package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controllers.*;

public class index {
    controlador c = new controlador();
    private JButton incioDeUsuariosButton;
    public JPanel panel1;
    private JButton inicioDeAdministradoresButton;

    public index() {
        incioDeUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.openInicioUsers(false);

            }
        });
        inicioDeAdministradoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.openInicioAdmin();
            }
        });
    }
}
