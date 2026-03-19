import java.util.ArrayList;
import java.util.Collections;

public class ListeHebergement {
    private ArrayList<Hébergement> hebergements;

    public ListeHebergement() {
        this.hebergements = new ArrayList<>();
    }

    public void ajouter(Hébergement h) {
        hebergements.add(h);
    }

    public void trier(Tri tri) {
        Collections.sort(hebergements, (h1, h2) -> tri.comparer(h1, h2));
    }

    public void afficher() {
        for (Hébergement h : hebergements) {
            h.afficher();
        }
    }

    public ArrayList<Hébergement> getHebergements() {
        return hebergements;
    }
}
