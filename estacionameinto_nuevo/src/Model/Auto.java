package Model;

import java.util.Observable;
import java.util.concurrent.Semaphore;

public class Auto extends Observable  implements Runnable {
        Estacionamiento estacionamiento;
        Semaphore numEspacios;
        Semaphore entrando;
        Semaphore saliendo;
        Semaphore mutex;

        static int numEntrando = 0;
        static int numSaliendo = 0;

        public Auto(Estacionamiento estacionamiento, Semaphore numEspacios, Semaphore entrando, Semaphore saliendo, Semaphore mutex) {
                this.estacionamiento = estacionamiento;
                this.numEspacios = numEspacios;
                this.entrando = entrando;
                this.saliendo = saliendo;
                this.mutex = mutex;
        }

        @Override
        public void run() {
                while (true) {
                        try {
                                numEspacios.acquire();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        try {
                                this.setChanged();
                                this.notifyObservers("esperandoE");

                                Thread.sleep(10);
                                mutex.acquire();
                                this.setChanged();
                                this.notifyObservers("pasando");
                                numEntrando++;
                                mutex.release();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        System.out.println("Entrando"+Thread.currentThread().getName());

                }
        }
}