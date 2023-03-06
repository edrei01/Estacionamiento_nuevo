package Model;

import sample.Controller;

import java.util.concurrent.Semaphore;

public class CrearAuto extends Thread {
    Controller controller;
    public CrearAuto(Controller controller){
        this.controller = controller;
    }

    int[] cajonesEstacionamiento = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    Estacionamiento estacionamiento = new Estacionamiento(cajonesEstacionamiento);
    Semaphore numEspacios = new Semaphore(20);
    Semaphore entrando = new Semaphore(0);
    Semaphore saliendo = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);

    Auto auto;
    Thread hilo;
    int numAutos = 100;
    @Override
    public void run() {
        for (int x = 1; x <= numAutos; x++) {
            auto = new Auto(estacionamiento, numEspacios, entrando, saliendo, mutex);
            auto.addObserver(controller);
            hilo = new Thread(auto,"Auto" + x);
            hilo.start();
            try {
                int num = (int) Math.floor(Math.random() * (5 ) + 1);
                Thread.sleep(num * 100 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
