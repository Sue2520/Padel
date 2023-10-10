package Models;

import java.awt.*;

public class pistas {

    public pistas(){};

    @Override
    public String toString() {
        return
                "ID:" + id +
                "|| Condicion: " + condicion +
                "|| Precio por hora: " + precioHora;
    }

    public pistas(int id, String condicion, float precioHora, int activo){
        this.id = id;
        this.condicion = condicion;
        this.precioHora = precioHora;
        this.activo = activo;
    };
    private int id;
    private String condicion;
    private float precioHora;
    private int activo;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getCondicion() {return condicion;}

    public void setCondicion(String condicion){this.condicion = condicion;}

    public float getPrecioHora() {return precioHora;}

    public void setPrecioHora(int precioHora) {this.precioHora = precioHora;}

    public int getActivo() {return activo;}

    public void setActivo(int Activo) {this.activo = Activo;}


}
