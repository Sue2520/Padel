package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Controllers.*;
import Models.usuarios;

public class perfilUser {
    public JPanel panel1;
    public JLabel dniTxt;
    public JLabel nameTxt;
    public JLabel mailTxt;
    private JButton editarButton;
    private JButton button2;
    private JTextField editDni;
    private JTextField editName;
    private JTextField editMail;
    private JButton saveBtn;
    public JLabel passwdTxt;
    private JPasswordField editPass;

    controlador c = new controlador();



    public void hideTxts(){
        editDni.setVisible(false);
        editMail.setVisible(false);
        editName.setVisible(false);
        editPass.setVisible(false);
        saveBtn.setVisible(false);
        dniTxt.setVisible(true);
        nameTxt.setVisible(true);
        mailTxt.setVisible(true);
        passwdTxt.setVisible(true);
        editarButton.setVisible(true);
    }

    public void editMode(){
        editarButton.setVisible(false);
        saveBtn.setVisible(true);
        editDni.setVisible(true);
        editMail.setVisible(true);
        editName.setVisible(true);
        editPass.setVisible(true);
        dniTxt.setVisible(false);
        nameTxt.setVisible(false);
        mailTxt.setVisible(false);
        passwdTxt.setVisible(false);
        editDni.setText(dniTxt.getText());
        editMail.setText(mailTxt.getText());
        editName.setText(nameTxt.getText());
        String passwd = (String) passwdTxt.getClientProperty("passwd");
        editPass.setText(passwd);
    }

    public perfilUser() {
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editMode();
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] nombre = editName.getText().split(" ");
                try {
                    c.updateUser(editDni.getText(),editMail.getText(),nombre[0],nombre[1],editPass.getText(),true);
                    hideTxts();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                usuarios user = new usuarios();
                try{
                    String[] nombre = editName.getText().split(" ");
                    user = new usuarios(editDni.getText(),editMail.getText(),nombre[0],nombre[1],editPass.getText());
                }catch (ArrayIndexOutOfBoundsException ex){
                    String[] nombre = nameTxt.getText().split(" ");
                    String passwd = (String) passwdTxt.getClientProperty("passwd");
                    user = new usuarios(dniTxt.getText(),mailTxt.getText(),nombre[0],nombre[1],passwd);
                }
                c.openMainUser(user);
            }
        });
    }
}
