package sample;

import javafx.scene.layout.GridPane;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public abstract class Window {

    private String titel;
    private BufferedWriter benutzer;
    private HashMap<String, String> benutzerPasswort = new HashMap<>();

    //Constructor
    public Window(String titel) {
        this.titel = titel;
    }

    // -> Getter und Setter
    public String getTitel() {
        return titel;
    }

    public HashMap getBenutzerPasswort() {
        return benutzerPasswort;
    }

    public abstract GridPane getWindow();
    // <- bis hier

    public void initBenutzer() throws IOException{
        benutzer = new BufferedWriter(new FileWriter("benutzer.txt", true));
    }

    public void addBenutzer(String benutzername, String passwort) throws IOException {
        benutzer.write(benutzername + ";" + passwort);
        benutzer.newLine();
        benutzer.close();
    }

    public void readBenutzer() throws IOException{
        FileInputStream fis = new FileInputStream("benutzer.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String eingelesen = br.readLine();
        StringTokenizer defaultTokenizer;

        while (eingelesen != null) {
            defaultTokenizer = new StringTokenizer(eingelesen, ";");
            benutzerPasswort.put(defaultTokenizer.nextToken(), defaultTokenizer.nextToken());
            eingelesen = br.readLine();
        }
    }

    public abstract void initWindow();

    public abstract void initMemberVariablen();

    public abstract void buildWindow();
}
