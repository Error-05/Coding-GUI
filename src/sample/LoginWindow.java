package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;


public class LoginWindow extends Window{

    private GridPane loginWindow;
    private TextField benutzernameEingabe;
    private TextField passwortEingabe;
    private Button loginBtn;
    private boolean datenEingabe;

    //Constructor
    public LoginWindow(String titel) {
        super(titel);
    }

    // -> Getter und Setter
    @Override
    public GridPane getWindow() {
        return loginWindow;
    }

    public Button getLoginBtn() {
        return (loginBtn);
    }
    // <- bis hier

    @Override
    public void initWindow() {
        loginWindow = new GridPane();
        loginWindow.setAlignment(Pos.CENTER);
        loginWindow.setPadding(new Insets(5, 5, 5, 5));
        loginWindow.setHgap(5);
        loginWindow.setVgap(5);
    }

    @Override
    public void initMemberVariablen() {
        benutzernameEingabe = new TextField();
        passwortEingabe = new TextField();
        loginBtn = new Button("Anmelden");
        datenEingabe = false;
    }

    @Override
    public void buildWindow() {
        Text ueberschrift = new Text("Geben sie ihre Daten ein");
        ueberschrift.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        loginWindow.add(ueberschrift, 0, 0, 2 ,1);
        loginWindow.add(new Label("Benutzername:"), 0, 1);
        loginWindow.add(benutzernameEingabe, 1, 1);
        loginWindow.add(new Label("Passwort:"), 0, 2);
        loginWindow.add(passwortEingabe, 1, 2);
        loginWindow.add(loginBtn, 1, 3);
    }

    public boolean datenUeberpruefung() {
        if (getBenutzerPasswort().containsKey(benutzernameEingabe.getText())
                && getBenutzerPasswort().containsValue(passwortEingabe.getText())) {
            return (datenEingabe = true);
        } else {
            return datenEingabe;
        }
    }
}
