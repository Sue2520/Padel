package Controllers;

import java.sql.*;
import java.util.ArrayList;

import vista.*;
import Models.*;

public class controlador {
    Funciones f = new Funciones();

    public static placeHolder view = new placeHolder();

    public static void main(String[] args){
        inicioAdmin startAdmin = new inicioAdmin();
        view.setContentPane(startAdmin.panel1);
        view.setSize(500,500);
        view.setVisible(true);
    }

    public void addPista(String condicion, String precio, Boolean activo) throws SQLException {

        Float cost = Float.parseFloat(precio);
        if(activo){
            int active = 1;
        }else{
            int active = 0;
        }
        String query = "INSERT INTO `pistas`(`Condicion`, `Precio_por_hora`, `activa`) " +
                "VALUES ('"+condicion+"',"+cost+","+activo+")";
        f.update(query);
    }

    public void updatePista(String id, String condicion, String precio, Boolean activo) throws SQLException {
        String active = "";
        if(activo==true){
            active = "1";
        }else{
            active = "0";
        }
        String query = "UPDATE `pistas` SET `Condicion`='"+condicion+"',`Precio_por_hora`='"+precio+"',`activa`='"+active+"' WHERE ID_pista LIKE '"+id+"';";
        f.update(query);
    }

    public pistas selectPista(String id) throws SQLException {
        String query = "SELECT * FROM pistas WHERE ID_pista = "+id+";";
        ResultSet pista = f.ejecutarQuery(query);
        pista.next();
        Integer ID = pista.getInt(1);
        String condicion = pista.getString(2);
        Float precio = pista.getFloat(3);
        Integer activo = pista.getInt(4);
        pistas placeholder = new pistas(ID,condicion,precio,activo);
        return placeholder;

    }

    public void addUser(String dni, String mail, String nombre, String Apellidos, String passwd){
        String query = "INSERT INTO `usuarios`(`dni`, `Email`, `Nombre`, `Apellidos`, `passwd`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]')";
    }

    public void checkAdmin(String id, String passwd) throws SQLException {
        Boolean correcta = false;
        String query = "SELECT password FROM administradores WHERE id LIKE '" + id + "';";
        ResultSet resultado = f.ejecutarQuery(query);
        resultado.next();
        String pass = resultado.getString(1);
        if (passwd.equals(pass)) {
            correcta = true;
        }

        if (correcta){ openMainAdmin(); }
    }

    public void openMainAdmin(){
        mainAdmin main = new mainAdmin();
        view.setContentPane(main.panel1);
        view.setSize(500,500);
        view.setVisible(true);
    }

    public void openPistas() throws SQLException{
        formPistas form = new formPistas();
        view.setContentPane(form.panel1);
        view.setSize(800,500);
        view.setVisible(true);
    }

    public void openUsers() throws SQLException{
        usersForm form = new usersForm();
        view.setContentPane(form.panel1);
        view.setSize(800,500);
        view.setVisible(true);
    }

    public ArrayList listPistas() throws SQLException{
        ResultSet pistasResult = f.ejecutarQuery("SELECT * FROM pistas");
        ArrayList<String> pista = new ArrayList<>();
        while(pistasResult.next()){
            pistas p = new pistas(pistasResult.getInt(1),pistasResult.getString(2),pistasResult.getFloat(3),pistasResult.getInt(4));
            pista.add(p.toString());
        }
        return pista;
    }


}
