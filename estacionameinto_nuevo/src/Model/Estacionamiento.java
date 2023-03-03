package Model;

public class Estacionamiento {
    private int[] cajones;


    public Estacionamiento(int[] cajones) {
        this.cajones = cajones;
    }

    public int estacionar() {
        int index = 0;
        while (cajones[index] != 0) {
            index++;
        }
        cajones[index] = 1;
        return index;
    }
}
