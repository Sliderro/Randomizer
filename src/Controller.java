import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Random;

class Controller {
    Controller(){

    }

    GridPane root(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(20));
        Label[] player = new Label[10];
        TextField[] playerTF = new TextField[10];
        ChoiceBox[] forceAvoid = new ChoiceBox[10];
        ChoiceBox[] role = new ChoiceBox[10];
        int[] forceAvoidValue = new int[10];
        int[] roleValue = new int[10];
        Player[] players = new Player[10];
        for(int i=0; i<10; i++){
            player[i] = new Label("Player "+(i+1));
            gridPane.add(player[i],4*(i/5),i%5);
            playerTF[i] = new TextField(""+(i+1));
            gridPane.add(playerTF[i],4*(i/5)+1,i%5);
            forceAvoid[i] = new ChoiceBox();
            forceAvoid[i].getItems().addAll("Randomize","Force","Avoid");
            forceAvoid[i].getSelectionModel().select(0);
            gridPane.add(forceAvoid[i],4*(i/5)+2,i%5);
            role[i] = new ChoiceBox();
            role[i].getItems().addAll("Top", "Jungle", "Mid", "Bot", "Support");
            gridPane.add(role[i],4*(i/5)+3,i%5);
        }
        Button randomizeBtn = new Button("Randomize");
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.getChildren().add(randomizeBtn);
        gridPane.add(vBox,7,5);
        randomizeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for(int i=0; i<10; i++){
                    if(forceAvoid[i].getValue()=="Randomize"){
                        forceAvoidValue[i]=0;
                    } else if(forceAvoid[i].getValue()=="Force"){
                        forceAvoidValue[i]=1;
                    } else{
                        forceAvoidValue[i]=2;
                    }
                    if(role[i].getValue()=="Top"){
                        roleValue[i]=0;
                    } else if(role[i].getValue()=="Jungle"){
                        roleValue[i]=1;
                    } else if(role[i].getValue()=="Mid"){
                        roleValue[i]=2;
                    } else if(role[i].getValue()=="Bot"){
                        roleValue[i]=3;
                    } else if(role[i].getValue()=="Support"){
                        roleValue[i]=4;
                    } else {
                        roleValue[i]=-1;
                    }
                    players[i] = new Player(forceAvoidValue[i], roleValue[i]);
                }
                Randomizer randomizer = new Randomizer(players);
                String str = randomizer.randomize();
                System.out.println(str);
                for(int i=0; i<10; i++){
                    System.out.println(forceAvoidValue[i] + "-" + players[i].getChoice()+ " | " + roleValue[i] + "-" + players[i].getRole());
                }
                stringDecoder(playerTF,str);
            }
        });
        return gridPane;
    }

    private void stringDecoder(TextField[] playerName, String str){
        Label[] swap = new Label[playerName.length];
        for (int i=0; i<playerName.length; i++){
            swap[i]= new Label();
        }
        if (str.equals("error")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Gratulacje Sztacheta");
            alert.setHeaderText("Jak zwykle spierdoliłeś!!!");
            alert.setContentText("Teraz wylosuj normalnie, OK?");
            alert.showAndWait();
        } else if(playerName.length == 10){
            for (int i=0; i<playerName.length; i++){
                swap[Character.getNumericValue(str.charAt(i))].setText(playerName[i].getText());
            }
            Label[] roles ={
                    new Label("Blue Side:"),
                    new Label("Top Lane:"),
                    new Label("Jungle:"),
                    new Label("Middle Lane:"),
                    new Label("Bottom Lane:"),
                    new Label("Support"),
                    new Label("Red Side:"),
                    new Label("Top Lane:"),
                    new Label("Jungle:"),
                    new Label("Middle Lane:"),
                    new Label("Bottom Lane:"),
                    new Label("Support")
            };
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Teams");
            alert.setHeaderText("Players have been randomized!");
            GridPane alertGridPane = new GridPane();
            alertGridPane.setPadding(new Insets(20));
            alertGridPane.setVgap(20);
            alertGridPane.setHgap(20);
            alertGridPane.setAlignment(Pos.CENTER);
            for(int i=0; i<playerName.length+2; i++){
                if(i<10){
                    alertGridPane.add(swap[i],(i/5)*2 + 1,i%5 +1);
                }
                alertGridPane.add(roles[i], (i/6)*2, i%6);
            }
            alert.getDialogPane().setContent(alertGridPane);
            alert.showAndWait();
        }
    }
}
