import java.util.ArrayList;
import java.util.List;

public class Hébergement {
    private int id;
    private String nom;
    private String adresse;
    private String type;
    private int capaciteMax;
    private double prixParNuit;
    private String description;
    private List<String> equipements;
    private double noteMoyenne;

    public Hébergement(int id, String nom, String adresse, String type, int capaciteMax, double prixParNuit) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.capaciteMax = capaciteMax;
        this.prixParNuit = prixParNuit;
        this.equipements = new ArrayList<>();
    }

    public String getNom() {
        return this.nom;
    }

    public double getPrixParNuit() {
        return this.prixParNuit;
    }

    // Méthodes minimales demandées
    public double calculerPrixSejour(int nbNuits) { return prixParNuit * nbNuits; }
    public void ajouterNote(int note) { this.noteMoyenne = (this.noteMoyenne + note) / 2.0; }
}