package Model;

import java.util.Observable;
import java.util.concurrent.Semaphore;

public class Auto extends Observable {
        Estacionamiento estacionamiento;
        Semaphore numEspacios;
        Semaphore entrando;
        Semaphore saliendo;
        Semaphore mutex;
        static int numEntrando = 0;
        static int numSaliendo = 0;

    public Auto(Estacionamiento estacionamiento,Semaphore numEspacios, Semaphore entrando, Semaphore saliendo, Semaphore mutex){
            this.estacionamiento = estacionamiento;
            this.numEspacios = numEspacios;
            this.entrando = entrando;
            this.saliendo = saliendo;
            this.mutex = mutex;
        }

}
