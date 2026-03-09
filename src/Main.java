import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- BIENVENUE SUR L'INTERFACE BOOKING ----");
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez votre prénom : ");
        String prenom = scanner.nextLine();
        AncienClient utilisateur = new AncienClient(1, nom, prenom, nom.toLowerCase() + "@email.com", "pass123", LocalDate.now(), 10);
        Hébergement hotel = new Hébergement(101, "Le Grand Palace", "Nice", "Hôtel", 4, 150.0);

        System.out.print("Date d'arrivée (AAAA-MM-JJ) : ");
        String debutStr = scanner.nextLine();
        LocalDate dateDebut = LocalDate.parse(debutStr);
        System.out.print("Date de départ (AAAA-MM-JJ) : ");
        String finStr = scanner.nextLine();
        LocalDate dateFin = LocalDate.parse(finStr);

        Réservation res = utilisateur.reserver(hotel, dateDebut, dateFin);

        long nbNuits = java.time.temporal.ChronoUnit.DAYS.between(dateDebut, dateFin);
        double prixParNuit = hotel.getPrixParNuit(); // On va créer ce getter
        double tauxReduc = utilisateur.verifierReduction() * 100; // Pour l'afficher en %
        double montantBase = hotel.calculerPrixSejour((int)nbNuits);

        System.out.println("\nRÉCAPITULATIF POUR : " + utilisateur.nom.toUpperCase() + " " + utilisateur.prenom);
        System.out.println("Hébergement : " + hotel.getNom());
        System.out.println("Durée du séjour : " + nbNuits + " nuits");

        System.out.println("\nPrix brut (" + prixParNuit + "€ x " + nbNuits + " nuits) : " + montantBase + "€");
        System.out.println("Remise fidélité appliquée : " + tauxReduc + "%");

        System.out.println("\nMontant total : " + res.getPrixTotal() + "€");
        scanner.close();
    }
}