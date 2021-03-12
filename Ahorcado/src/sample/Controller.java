package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.Random;

public class Controller {
    @FXML HBox contenedor;
    @FXML AnchorPane padre;
    String[] palabras = {"PELOTA", "MICROFONO","LIBRO", "CUCHARA", "SALSA", "CHICHARRON", "MOUSE"};
    TextField[] arrayTxt = null;
    
    @FXML protected void initialize(){
        Random random = new Random();
        int aleatorio = random.nextInt(6);
        String palabra = palabras[aleatorio].toLowerCase();
        System.out.println(palabra);
        arrayTxt = new TextField[palabra.length()];
        int ayuda = 1;//Estas son las letras de ayuda


        for(int x=0; x<palabra.length(); x++){
            arrayTxt[x] = new TextField();
            arrayTxt[x].setPrefWidth(50);
            arrayTxt[x].setPrefHeight(50);
            arrayTxt[x].setId("txt-" + x + "-" + palabra.charAt(x));
            arrayTxt[x].setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    TextField textField = (TextField) event.getTarget();//Obtner lo que dispara el evento
                    String[] nombre = textField.getId().split("-");
                    if(nombre[2].equals(textField.getText().toLowerCase())){
                        System.out.println("Correcto" + textField.getId());
                        textField.setDisable(true);
                    }else{
                        System.out.println("Incorrecto" + textField.getId());
                        textField.setText("");
                        pintarCuerpo();

                    }
                }
            });
            contenedor.getChildren().add( arrayTxt[x]);
        }
    }
    public void pintarCuerpo(){
        for(int x=0; x<6; x++){
            if (x==0){
                ImageView cabeza = new ImageView(new Image("sample/img/Cabeza.png"));
                cabeza.setFitWidth(150);
                cabeza.setFitHeight(150);
                cabeza.setLayoutX(200);
                cabeza.setLayoutY(150);
                padre.getChildren().addAll(cabeza);
            }if (x==1){
                ImageView cuerpo = new ImageView(new Image("sample/img/Cuerpo.png"));
                cuerpo.setFitWidth(150);
                cuerpo.setFitHeight(150);
                cuerpo.setLayoutX(200);
                cuerpo.setLayoutY(150);
                padre.getChildren().addAll(cuerpo);
            }if (x==2){
                ImageView brazoD = new ImageView(new Image("sample/img/Brazo D.png"));
                brazoD.setFitWidth(150);
                brazoD.setFitHeight(150);
                brazoD.setLayoutX(200);
                brazoD.setLayoutY(150);
                padre.getChildren().addAll(brazoD);
            }if (x==3){
                ImageView brazoI = new ImageView(new Image("sample/img/Brazo I.png"));
                brazoI.setFitWidth(150);
                brazoI.setFitHeight(150);
                brazoI.setLayoutX(200);
                brazoI.setLayoutY(150);
                padre.getChildren().addAll(brazoI);
            }if (x==4){
                ImageView piernaI = new ImageView(new Image("sample/img/Pierna I.png"));
                piernaI.setFitWidth(150);
                piernaI.setFitHeight(150);
                piernaI.setLayoutX(200);
                piernaI.setLayoutY(150);
                padre.getChildren().addAll(piernaI);
            }if (x==5){
                ImageView piernaD = new ImageView(new Image("sample/img/Pierna D.png"));
                piernaD.setFitWidth(150);
                piernaD.setFitHeight(150);
                piernaD.setLayoutX(200);
                piernaD.setLayoutY(150);
                padre.getChildren().addAll(piernaD);
            }
        }

    }
}
