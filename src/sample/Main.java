package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {

    @Override
    public void start(Stage stage){
        LoginWindow loginWindow = new LoginWindow("Login");
        loginWindow.initWindow();
        loginWindow.configMemberVariablen();
        loginWindow.createWindow();

        MenueWindow menueWindow = new MenueWindow("Menue");
        menueWindow.initWindow();
        menueWindow.configMemberVariablen();
        menueWindow.createWindow();

        stage.setTitle(loginWindow.getTitel());
        Scene login = new Scene(loginWindow.getWindow(), 500, 400);
        Scene menue = new Scene(menueWindow.getWindow(), 700, 600);
        stage.setScene(login);

        loginWindow.addBenutzer("user1", "123");

        loginWindow.getLoginBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (loginWindow.datenUeberpruefung()) {
                    stage.setTitle(menueWindow.getTitel());
                    stage.setScene(menue);
                } else {

                }
            }
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
