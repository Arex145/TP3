import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Réservation {
    private int id;
            private String statut;
            private Client client;
            private Hébergement hebergement;
            private LocalDate dateArrivee;
            private LocalDate dateDepart;
            private double prixTotal;

    public Réservation(int id, Client client, Hébergement hebergement, LocalDate debut, LocalDate fin) {
        this.id = id;
        this.client = client;
        this.hebergement = hebergement;
        this.dateArrivee = debut;
        this.dateDepart = fin;
        this.statut = "CONFIRMEE";

        long nuits = ChronoUnit.DAYS.between(debut, fin);
        double prixBase = hebergement.calculerPrixSejour((int) nuits);
        this.prixTotal = prixBase - (prixBase * client.verifierReduction());
    }

    public LocalDate getDateArrivee() {
        return this.dateArrivee;
    }

    public LocalDate getDateDepart() {
        return this.dateDepart;
    }

    public String getStatut() {
        return this.statut;
    }

    public double getPrixTotal() {
        return prixTotal; }
}