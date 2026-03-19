import java.util.ArrayList;
import java.util.List;

public abstract class Hébergement {
    protected int id;
    protected String nom;
    protected String adresse;
    protected String type;
    protected int capaciteMax;
    protected double prixParNuit;
    protected List<String> equipements;
    protected double noteMoyenne;

    public Hébergement(int id, String nom, String adresse, String type, int capaciteMax, double prixParNuit) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.capaciteMax = capaciteMax;
        this.prixParNuit = prixParNuit;
        this.equipements = new ArrayList<>();
    }

    // Méthode abstraite pour le calcul du prix
    public abstract double calculerPrixSejour(int nbNuits);

    // Méthodes existantes
    public String getNom() {
        return nom;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }

    public void ajouterNote(int note) {
        this.noteMoyenne = (this.noteMoyenne + note) / 2.0;
    }

    // Méthode pour afficher les informations de l'hébergement
    public void afficher() {
        System.out.println("ID: " + id + ", Nom: " + nom + ", Adresse: " + adresse + ", Type: " + type +
                ", Prix/Nuit: " + prixParNuit + "€");
    }

    // Méthode toString pour faciliter le débogage
    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Adresse: " + adresse + ", Type: " + type +
                ", Prix/Nuit: " + prixParNuit + "€";
    }
}
