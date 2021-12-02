package edu.fiuba.algo3.modelo;

public class Policia {
    private String nombre;
    private Rango rango;
    private int cantidadDeArrestos;
    private int cantidadDePunialadas;

    public Policia(String nombre){
        this.nombre = nombre;
        this.rango = new Novato();
        this.cantidadDeArrestos = 0;
        this.cantidadDePunialadas = 0;
    }

    public void ascender(){
        this.rango = this.rango.proximoRango();
    }

    public String policiaEntrarEnEdificioConMision(Edificio unEdificio, Mision unaMision){
        return this.rango.pedirPista(unEdificio, unaMision);

    }

    public double duracionViajeconDistancia(double unaDistancia){
        return (this.rango.calcularTiempoViajeA(unaDistancia));
    }

    public int recibirPunialada(){
        this.cantidadDePunialadas++;
        if (cantidadDePunialadas == 1) {
            return 2;
        }
        return 1;
    }
}