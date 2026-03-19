public class Chambre extends Hébergement {
    private int nombreDeLits;
    private boolean petitDejeunerInclus;

    // Constructeur par défaut
    public Chambre() {
        super(0, "Inconnu", "Inconnu", "Chambre", 1, 0.0);
        this.nombreDeLits = 1;
        this.petitDejeunerInclus = false;
    }

    // Constructeur avec paramètres
    public Chambre(int id, String nom, String adresse, int capaciteMax, double prixParNuit, int nombreDeLits, boolean petitDejeunerInclus) {
        super(id, nom, adresse, "Chambre", capaciteMax, prixParNuit);
        this.nombreDeLits = nombreDeLits;
        this.petitDejeunerInclus = petitDejeunerInclus;
    }

    // Constructeur par copie
    public Chambre(Chambre autre) {
        super(autre.id, autre.nom, autre.adresse, autre.type, autre.capaciteMax, autre.prixParNuit);
        this.nombreDeLits = autre.nombreDeLits;
        this.petitDejeunerInclus = autre.petitDejeunerInclus;
    }

    @Override
    public double calculerPrixSejour(int nbNuits) {
        return prixParNuit * nbNuits * (petitDejeunerInclus ? 1.1 : 1.0);
    }

    // Getters
    public int getNombreDeLits() {
        return nombreDeLits;
    }

    public boolean isPetitDejeunerInclus() {
        return petitDejeunerInclus;
    }

    // Méthode pour afficher les informations de la chambre
    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Nombre de lits: " + nombreDeLits + ", Petit-déjeuner inclus: " + petitDejeunerInclus);
    }

    // Méthode toString pour faciliter le débogage
    @Override
    public String toString() {
        return super.toString() + ", Nombre de lits: " + nombreDeLits + ", Petit-déjeuner inclus: " + petitDejeunerInclus;
    }
}
