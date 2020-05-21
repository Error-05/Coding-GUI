package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        LoginWindow loginWindow = new LoginWindow("Login");
        loginWindow.initWindow();
        loginWindow.initMemberVariablen();
        loginWindow.initBenutzer();
        loginWindow.buildWindow();

        MenueWindow menueWindow = new MenueWindow("Menue");
        menueWindow.initWindow();
        menueWindow.initMemberVariablen();
        menueWindow.buildWindow();

        //Hier könte ein Benutzer hinzugefügt werden

        try {
            loginWindow.readBenutzer();
        } catch (Exception e) {
            System.out.println("Fehler beim einlesen der Datei");
        }

        stage.setTitle(loginWindow.getTitel());
        Scene login = new Scene(loginWindow.getWindow(), 500, 400);
        Scene menue = new Scene(menueWindow.getWindow(), 700, 600);
        stage.setScene(login);

        loginWindow.getLoginBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                if (loginWindow.datenUeberpruefung()) {
                    stage.setTitle(menueWindow.getTitel());
                    stage.setScene(menue);
                } else {
                    System.out.println("Falsche Daten");
                }
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
