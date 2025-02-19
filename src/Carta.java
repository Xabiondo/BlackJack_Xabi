


public class Carta {
    private String paloInd ;
    private String valorInd;
    private int puntoInd;

    static final String[] valores =  {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static final int[] puntos = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    static final String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};;



    public Carta( String paloInd,String valorInd , int puntoInd ) {

        this.valorInd = valorInd;
        this.puntoInd = puntoInd;
        this.paloInd = paloInd;
    }

    public String getPaloInd() {
        return paloInd;
    }

    public void setPaloInd(String paloInd) {
        this.paloInd = paloInd;
    }

    public String[] getPalos() {
        return palos;
    }

    public int getPuntoInd() {
        return puntoInd;
    }

    public void setPuntoInd(int puntoInd) {
        this.puntoInd = puntoInd;
    }

    public int[] getPuntos() {
        return puntos;
    }

    public String[] getValores() {
        return valores;
    }

    public String getValorInd() {
        return valorInd;
    }

    public void setValorInd(String valorInd) {
        this.valorInd = valorInd;
    }
}

