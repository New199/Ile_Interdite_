package vues;

import modeles.Modele;
        import modeles.Zone;
        import javafx.scene.control.ContextMenu;
        import javafx.scene.control.MenuItem;
        import javafx.scene.input.MouseEvent;

        import java.util.ArrayList;

public class Actvue extends ContextMenu {

    public Actvue(Zone zone, MouseEvent mouseEvent, GridVue grilleVue, Modele modele, ArrayList<String> actions) {
        super();

        if (actions.size() < 1) {
            throw new IllegalArgumentException("Action must contains at least one action");
        }
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        for (String action :
                actions) {
            if (action.equals("move")) {
                MenuItem moveItem = new MenuItem("move");
                moveItem.setOnAction(actionEvent -> modele.deplace(zone));
                menuItems.add(moveItem);
            }

            if (action.equals("dry")) {
                MenuItem dryItem = new MenuItem("dry");
                dryItem.setOnAction(actionEvent -> modele.asseche(zone));
                menuItems.add(dryItem);
            }

            if (action.equals("get")) {
                MenuItem getItem = new MenuItem("get");
                getItem.setOnAction(actionEvent -> modele.recupere(zone));
                menuItems.add(getItem);
            }
        }
        this.getItems().addAll(menuItems);
        this.show(grilleVue, mouseEvent.getScreenX(), mouseEvent.getScreenY());
    }
}