package controllers;


import modeles.Modele;
        import modeles.Zone;
        import vues.Actvue;
import vues.GridVue;
        import vues.ZoneVue;
        import javafx.scene.input.MouseEvent;

        import java.util.ArrayList;

public class Controller {
    private final Modele modele;
    private final GridVue grilleVue;
    private Actvue actionsVue = null;

    public Controller(Modele modele, GridVue grilleVue) {
        this.modele = modele;
        this.grilleVue = grilleVue;
    }

    public void finDeTour() {
        modele.inondeCases();
        if (modele.dropCles()){
            gotKey();
        }
        modele.incrementeTour();
    }


    /*
     * la case  atteignable ou asséchable: modele.deplace(zone) ou modele.asseche(zone)
     * la case atteignable et asséchable: modele.deplace(zone) et modele.asseche(zone): création de new actVue
     */
    public void zoneClicked(Zone zone, MouseEvent mouseEvent) {

        if (actionsVue != null)
            actionsVue.hide();
        ArrayList<String> actions = new ArrayList<>();

        if (this.modele.atteignable(zone)) {
            actions.add("move");
        }
        if (this.modele.assechable(zone)) {
            if (actionsVue != null) {
                actionsVue.hide();
            }
            actions.add("dry");
        }
        if (this.modele.recuperable(zone)) {
            actions.add("get");
        }
        if (!actions.isEmpty())
            actionsVue = new Actvue(zone, mouseEvent, this.grilleVue, this.modele, actions);
    }


    /*
     * La zone peut être atteinte, asséchée, récupérée: zoneVue.setGoodCursor()
     * sinon: zoneVue.setBadCursor()
     * */
    public void mouseEnteredZone(ZoneVue zoneVue) {

        Zone.setHover(zoneVue.getZone());
        zoneVue.setHover();
        if (this.modele.atteignable(zoneVue.getZone()) || this.modele.assechable(zoneVue.getZone()) ||
                this.modele.recuperable(zoneVue.getZone()))
            zoneVue.setGoodCursor();
        else
            zoneVue.setBadCursor();
    }
    public void mouseExitedZone(ZoneVue zoneVue) {
        zoneVue.deleteHover();
        zoneVue.setGoodCursor();
    }

    public void gotKey() {
        grilleVue.getMainVue().showPopUp();
    }
}