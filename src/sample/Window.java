package sample;

import javafx.scene.layout.GridPane;

import java.util.HashMap;


public abstract class Window {

    private String titel;
    private HashMap<String, String> benutzer = new HashMap<>();

    public Window(String titel) {
        this.titel = titel;
    }

    // -> Getter und Setter
    public String getTitel() {
        return titel;
    }

    public HashMap<String, String> getBenutzer() {
        return benutzer;
    }

    public abstract GridPane getWindow();
    // <- bis hier

    public void addBenutzer(String benutzername, String passwort) {
        benutzer.put(benutzername, passwort);
    }

    public abstract void initWindow();

    public abstract void configMemberVariablen();

    public abstract void createWindow();
}
