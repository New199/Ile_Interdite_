package constantes;



        import javafx.scene.image.Image;

        import java.io.File;
        import java.util.ArrayList;
        import java.util.Arrays;

public class Images {
    public static void init() {
        System.out.println("Init images");
    }
    private static String getPath(String path) {
        return new File(path).toURI().toString();
    }
    public static final Image playerNormal = new Image(getPath("Documents/players/normal.png"));
    public static final Image playerNormalBW = new Image(getPath("Documents/players/normal-b&w.png"));
    public static final Image overlay = new Image(getPath("Documents/etat/submerged.png"));
    public static final Image hover = new Image(getPath("Documents/cases/hover-bis.png"));
    public static final Image normalCase = new Image( getPath("Documents/cases/normal.png"));
    public static final Image airCase = new Image( getPath("Documents/cases/air.png"));
    public static final Image earthCase = new Image( getPath("Documents/cases/earth.png"));
    public static final Image fireCase = new Image( getPath("Documents/cases/fire.png"));
    public static final Image heliportCase = new Image( getPath("Documents/cases/heliport.png"));
    public static final Image waterCase = new Image( getPath("Documents/cases/water.png"));
    public static final Image artefact1 = new Image(getPath("Documents/artefact/artf1.png"));
    public static final Image artefact2 = new Image(getPath("Documents/artefact/artf2.png"));
    public static final Image artefact3 = new Image(getPath("Documents/artefact/artf3.png"));
    public static final Image artefact4 = new Image(getPath("Documents/artefact/artf4.png"));
    public static final ArrayList<Image> artifacts = new ArrayList<>(Arrays.asList(artefact1, artefact2, artefact3, artefact4));
    public static final Image key1 = new Image(getPath("Documents/cle/cle-b.png"));
    public static final Image key2 = new Image(getPath("Documents/cle/cle-bb.png"));
    public static final Image key3 = new Image(getPath("Documents/cle/cle-bbb.png"));
    public static final Image key4 = new Image(getPath("Documents/cle/cle-bbbb.png"));
    public static final ArrayList<Image> keys = new ArrayList<>(Arrays.asList(key1, key2, key3, key4));


}