package vues;


import controllers.Controller;
        import modeles.Modele;
        import javafx.geometry.Insets;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.layout.Background;
        import javafx.scene.layout.BackgroundFill;
        import javafx.scene.layout.CornerRadii;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.stage.Popup;
        import javafx.stage.Stage;


public class MainVue extends Scene {

    private final Stage stage;

    public MainVue(Modele modele, Pane root, Stage stage) {
        super(root, modele.getNbRows() * 40 + 120, modele.getNbCols() * 40);

        this.stage = stage;
        GridVue grilleVue = new GridVue(modele, this);
        Controller controller = grilleVue.getController();
        CommandesVue commandesVue = new CommandesVue(modele, controller);

        root.getChildren().addAll(grilleVue, commandesVue);
    }

    public void showPopUp() {
        Popup popup = new Popup();
        popup.setAutoHide(true);
        popup.setHideOnEscape(true);
        Label label = new Label("+ Key");
        BackgroundFill backgroundFill = new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY);
        label.setBackground(new Background(backgroundFill));

        popup.getContent().add(label);

        popup.setX(stage.getX());
        popup.setY(stage.getY() + 21);
        popup.show(this.stage);
    }

}