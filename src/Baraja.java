import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Baraja {
    ArrayList<Carta> baraja;
    private Jugador jugador;
    private ArrayList<Carta> manoJugador;
    private ArrayList<Carta> dealer;
    private int contador;
    private int contadorDealer;
    private boolean tieneAs;
    private boolean partidaEnJuego;


    public Baraja() {
        this.baraja = new ArrayList<>();
        inicializarBaraja();
        this.jugador = new Jugador("xabi");
        this.manoJugador =  new ArrayList<>();
        this.dealer =  new ArrayList<>();
        this.tieneAs = false;
        this.partidaEnJuego = true;




    }
    public void inicializarBaraja(){
        for (int palos = 0 ; palos < 4 ; palos++){
            for (int valores = 0 ; valores < 13 ; valores++){
                Carta cartaAux = new Carta(Carta.palos[palos],   Carta.valores[valores] , Carta.puntos[valores]);
                baraja.add(cartaAux);

            }
        }

    }



    public void mostrarBaraja(){
        for (Carta cartita : baraja){
            System.out.println(cartita.getPaloInd() + " " +   cartita.getValorInd());

        }

    }


    public void repartirCartas(){
        for (int i  =0 ; i < 2 ; i++){
            int sorteo = (int)(Math.random()*baraja.size());
            manoJugador.add(baraja.get(sorteo));
            baraja.remove(sorteo);

            int sorteo2 = (int)(Math.random()*baraja.size());
            dealer.add(baraja.get(sorteo2));
            baraja.remove(sorteo2);

        }

    }
    public void calcularPuntuacion(){
        contador = 0;
        contadorDealer = 0;
        for (Carta carta : manoJugador){
            contador = contador+ carta.getPuntoInd();

        }
        for (Carta carta : dealer){
            contadorDealer = contadorDealer + carta.getPuntoInd();
        }






    }
    public void mostrarManos(){
        System.out.println("Tu mano es ...");
        for (Carta cartita : manoJugador){

            System.out.println(cartita.getPaloInd() + " " +   cartita.getValorInd());

        }
        System.out.println("tu puntuacion es  " + contador);

        System.out.println();
        System.out.println("La mano del rival es");
        for (Carta cartita : dealer){
            System.out.println(cartita.getPaloInd() + " " +   cartita.getValorInd());

        }
        System.out.println("la puntaucion del dealer es  "  + contadorDealer);
    }
    public void darCarta(){
        int sorteo = (int)(Math.random()*baraja.size());
        manoJugador.add(baraja.get(sorteo));
        baraja.remove(sorteo);

    }
    public void revisarRonda(){
        if (contador > 21 && tieneAs == false ){

            for (Carta carta : manoJugador){
                if (carta.getValorInd().equals("As")){
                    tieneAs = true;
                }
                if (tieneAs == true){
                    contador = contador - 10 ;
                }else {
                    System.out.println("Has perdido");
                    partidaEnJuego = false;
                    return;
                }

            }
        }

        if (contadorDealer < 17 ){
            int sorteo = (int)(Math.random()*baraja.size());
            dealer.add(baraja.get(sorteo));
            baraja.remove(sorteo);


        } else {
            System.out.println("el dealer no pide mas cartas");
            return; }



        if (contadorDealer > 21 ){
            System.out.println("el dealer ha perdido");
            partidaEnJuego = false;



        }


    }


    public void ronda(){
        repartirCartas();
        int decision = 0;
        do {
            calcularPuntuacion();
            mostrarManos();
            System.out.println("Quieres pedir carta , si quieres pedir pon 1 , si no otra cosa");
            Scanner sc = new Scanner(System.in);


            do {
                 decision = sc.nextInt();
                if (decision == 1) {
                    darCarta();
                    calcularPuntuacion();
                    mostrarManos();
                    revisarRonda();
                }

            }while (decision ==1);

            revisarRonda();
            calcularPuntuacion();
            mostrarManos();



        }while (partidaEnJuego == true && decision != 1);
    }



}

