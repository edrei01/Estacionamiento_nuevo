package sample;

import Model.CrearAuto;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    @FXML
    private ImageView caj0, caj1, caj2, caj3, caj4, caj5, caj6, caj7, caj8, caj9, caj10,
            caj11, caj12, caj13, caj14, caj15, caj16, caj17, caj18, caj19;

    @FXML
    ImageView imgEntrando, imgSaliendo;
    private ImageView[] cajones = new ImageView[20];

    public void update(Observable o, Object arg) {
        if (arg.toString().charAt(0) == 'E') {
            entrando(Integer.valueOf(arg.toString().split("E")[1]));
        } else if (arg.toString().equals("esperandoE") || arg.toString().equals("esperandoS")) {
            esperando(arg.toString());
        } else if (arg.toString().equals("pasando") || arg.toString().equals("saliendo")) {
            pasandoSaliendo(arg.toString());
        } else if (arg.toString().equals("Estoy esperaando para entrar pero no puedo porque están saliendo")) {
        } else {
            saliendo(Integer.valueOf(arg.toString().split("S")[1]));
        }
    }

    public void iniciar() {
        config();
        CrearAuto crearAuto = new CrearAuto(this);
        crearAuto.start();
    }

    public void config() {
        cajones[0] = caj0;
        cajones[1] = caj1;
        cajones[2] = caj2;
        cajones[3] = caj3;
        cajones[4] = caj4;
        cajones[5] = caj5;
        cajones[6] = caj6;
        cajones[7] = caj7;
        cajones[8] = caj8;
        cajones[9] = caj9;
        cajones[10] = caj10;
        cajones[11] = caj11;
        cajones[12] = caj12;
        cajones[13] = caj13;
        cajones[14] = caj14;
        cajones[15] = caj15;
        cajones[16] = caj16;
        cajones[17] = caj17;
        cajones[18] = caj18;
        cajones[19] = caj19;

    }

    public void entrando(int numCajon) {
        System.out.println(numCajon + " Entrando");
        Platform.runLater(() -> cajones[numCajon].setVisible(true));

    }

    public void saliendo(int numCajon) {
        System.out.println(numCajon + " Saliendo");
        Platform.runLater(() -> cajones[numCajon].setVisible(false));
    }

    public void esperando(String cadena) {
        if (cadena.equals("esperandoE")) {
            Platform.runLater(() -> imgEntrando.setVisible(true));

        } else {
            Platform.runLater(() -> imgSaliendo.setVisible(true));

        }
    }

    public void pasandoSaliendo(String cadena) {
        if (cadena.equals("pasando")) {
            Platform.runLater(() -> imgEntrando.setVisible(false));
        } else {
            Platform.runLater(() -> imgSaliendo.setVisible(false));
        }
    }

}
