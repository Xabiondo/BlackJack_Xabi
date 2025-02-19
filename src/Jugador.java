import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int dinero;

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre) {
        this.dinero = 50;
        this.nombre = nombre;
    }




}

