package vues;

import controllers.Controller;
        import modeles.Modele;
        import modeles.Player;
        import modeles.Zone;
        import observer.Observer;
        import javafx.scene.layout.GridPane;

        import java.util.ArrayList;

public class GridVue extends GridPane implements Observer {

    private final Modele modele;
    private final Controller controller;
    private final int ROWS;
    private final int COLS;
    private final MainVue mainVue;
    ArrayList<Zone> zones;
    ArrayList<Player> players;
    ArrayList<ZoneVue> zoneVues = new ArrayList<>();

    public GridVue(Modele modele, MainVue mainVue) {
        this.modele = modele;
        this.controller = new Controller(modele, this);
        this.mainVue = mainVue;
        this.ROWS = modele.getNbRows();
        this.COLS = modele.getNbCols();
        this.zones = modele.getCases();
        this.players = modele.getPlayers();

        modele.addObserver(this);

        generateGrid();
    }

    public Controller getController() {
        return controller;
    }

    private void generateGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Zone zone = zones.get(i * COLS + j);

                ZoneVue newZone = new ZoneVue(modele, zone, this.mainVue);

                newZone.setOnMouseClicked(mouseEvent -> controller.zoneClicked(zone, mouseEvent));
                newZone.setOnMouseEntered(mouseEvent -> controller.mouseEnteredZone(newZone));
                newZone.setOnMouseExited(mouseEvent -> controller.mouseExitedZone(newZone));

                zoneVues.add(newZone);

                this.add(newZone, i, j);
            }
        }
    }

    public MainVue getMainVue() {
        return mainVue;
    }

    @Override
    public void update() {

    }
}