
import modeles.Modele;
        import vues.MainVue;
        import javafx.application.Application;
        import javafx.scene.layout.FlowPane;
        import javafx.stage.Stage;

public class Main extends Application {
    private Modele modele;
    private FlowPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Modele modele = new Modele(10, 10, 2);
        FlowPane root = new FlowPane();
        stage.setTitle("Ile Interdite - POGL - Guillaume A.");
        stage.setScene(new MainVue(modele, root, stage));
        stage.show();
    }
}