package sample;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML
    private ImageView caj0, caj1, caj2, caj3, caj4, caj5, caj6, caj7, caj8, caj9, caj10,
                        caj11, caj12, caj13, caj14, caj15, caj16, caj17, caj18, caj19;

    private ImageView[] cajones = new ImageView[20];
    int[] cajonesEstacionamiento = {0, 0, 0, 0, 0,};



    public void iniciar(){
        config();

    }
    public void auto(){

    }

    public void config(){
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


}
