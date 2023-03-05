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


                                mutex.acquire();
                                this.setChanged();
                                this.notifyObservers("pasando");
                                numEntrando++;
                                mutex.release();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        System.out.println("Entrando"+Thread.currentThread().getName());
                        try {
                                mutex.acquire();
                                numEntrando--;
                                if(numEntrando == 0){
                                        entrando.release();
                                }

                                mutex.release();
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }

                        int numCajon = 99;
                        try {
                                mutex.acquire();
                                numCajon = estacionamiento.estacionar();
                                this.setChanged();
                                this.notifyObservers("E"+numCajon);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        mutex.release();

                        int num = (int)Math.floor(Math.random()*(5)+1);
                        System.out.println("Estoy adentro un rato"+Thread.currentThread().getName() +" por "+num*1000);

                        try {
                                Thread.sleep(num*2000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                }
        }
}