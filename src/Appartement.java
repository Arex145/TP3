public class Appartement extends Hébergement {
    private int nombreDePieces;

    // Constructeur par défaut
    public Appartement() {
        super(0, "Inconnu", "Inconnu", "Appartement", 1, 0.0);
        this.nombreDePieces = 1;
    }

    // Constructeur avec paramètres
    public Appartement(int id, String nom, String adresse, int capaciteMax, double prixParNuit, int nombreDePieces) {
        super(id, nom, adresse, "Appartement", capaciteMax, prixParNuit);
        this.nombreDePieces = nombreDePieces;
    }

    // Constructeur par copie
    public Appartement(Appartement autre) {
        super(autre.id, autre.nom, autre.adresse, autre.type, autre.capaciteMax, autre.prixParNuit);
        this.nombreDePieces = autre.nombreDePieces;
    }

    @Override
    public double calculerPrixSejour(int nbNuits) {
        return prixParNuit * nbNuits * 0.9; // Réduction de 10% pour un appartement
    }

    // Getter
    public int getNombreDePieces() {
        return nombreDePieces;
    }

    // Méthode pour afficher les informations de l'appartement
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Nombre de pièces: " + nombreDePieces);
    }

    // Méthode toString pour faciliter le débogage
    @Override
    public String toString() {
        return super.toString() + ", Nombre de pièces: " + nombreDePieces;
    }
}
