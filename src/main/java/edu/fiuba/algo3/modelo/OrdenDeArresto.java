package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrdenDeArresto {
    private String vehiculo;
    private String hobby;
    private String sexo;
    private String cabello;
    private String senia;
    private Ladron ladron;

    public OrdenDeArresto() {
        this.vehiculo = "???";
        this.hobby = "???";
        this.sexo = "???";
        this.cabello = "???";
        this.senia = "???";
        this.ladron = null;
    }

    public void actualizarVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void actualizarHobby(String hobby) {
        this.hobby = hobby;
    }

    public void actualizarSexo(String sexo) {
        this.sexo = sexo;
    }

    public void actualizarCabello(String cabello) {
        this.cabello = cabello;
    }

    public void actualizarSenia(String senia) {
        this.senia = senia;
    }

    public ArrayList<Ladron> posiblesLadrones(RegistroLadrones registroLadrones) {
        LadronModelo modeloLadron = new LadronModelo(this.sexo, this.hobby, this.cabello, this.senia, this.vehiculo);

        ArrayList<Ladron> ladronesCoincidentes = registroLadrones.posiblesLadrones(modeloLadron);

        if (ladronesCoincidentes.size() == 1) {
            this.ladron = ladronesCoincidentes.get(0);
        } else {
            this.ladron = null;
        }
        return ladronesCoincidentes;
    }

    public void atraparLadron(Juego juego, Mision mision) {
        if (this.ladron == null){
            juego.ladronEscapa();
            return;
        }
        if (mision.compararLadron(this.ladron)) {
            juego.ladronAtrapado();
        }
        else {
            juego.ladronEscapa();
        }
    }

}
