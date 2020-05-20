package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MenueWindow extends Window{

    private GridPane menueWindow;
    private Button lol;
    private Button verschlüsselungsprogramm;

    //Constructor
    public MenueWindow(String titel) {
        super(titel);
    }

    @Override
    public GridPane getWindow() {
        return menueWindow;
    }

    @Override
    public void initWindow() {
        menueWindow = new GridPane();
        menueWindow.setAlignment(Pos.CENTER);
        menueWindow.setPadding(new Insets(5, 5, 5, 5));
        menueWindow.setHgap(5);
        menueWindow.setVgap(5);
    }

    @Override
    public void configMemberVariablen() {
        lol = new Button("jaaa");
        verschlüsselungsprogramm = new Button("Verschlüsselungsprogramm");
    }

    @Override
    public void createWindow() {
        menueWindow.add(lol, 0, 0);
        menueWindow.add(verschlüsselungsprogramm, 0, 1);
    }


}
