import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Message pour préciser que l'utilisateur est considéré comme un ancien client par défaut
        System.out.println("---- BIENVENUE SUR L'INTERFACE BOOKING ----");
        System.out.println("Vous êtes considéré comme un ancien client par défaut pour simplifier l'exemple.");

        // Saisie des informations du client
        System.out.print("\nEntrez votre nom : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez votre prénom : ");
        String prenom = scanner.nextLine();

        // Création d'un ancien client avec un email généré automatiquement
        AncienClient utilisateur = new AncienClient(1, nom, prenom, nom.toLowerCase() + "@email.com", "pass123", LocalDate.now(), 10);

        // Création d'une liste d'hébergements
        ListeHebergement listeHebergement = new ListeHebergement();
        listeHebergement.ajouter(new Chambre(1, "Chambre Standard", "Paris", 2, 100.0, 2, true));
        listeHebergement.ajouter(new Appartement(2, "Suite Prestige", "Paris", 4, 150.0, 3));

        // Tri par prix
        listeHebergement.trier(new TriParPrix());
        System.out.println("\nHébergements triés par prix :");
        listeHebergement.afficher();

        // Choix de l'hébergement avec vérification
        Hébergement hebergementChoisi = null;
        do {
            System.out.print("\nChoisissez un hébergement (ID) : ");
            int idHebergement = Integer.parseInt(scanner.nextLine());

            for (Hébergement h : listeHebergement.getHebergements()) {
                if (h.id == idHebergement) {
                    hebergementChoisi = h;
                    break;
                }
            }

            if (hebergementChoisi == null) {
                System.out.println("Aucun hébergement ne correspond à cet ID.");
                System.out.println("Liste des IDs valides :");
                for (Hébergement h : listeHebergement.getHebergements()) {
                    System.out.println("- " + h.id + " : " + h.getNom());
                }
            } else {
                System.out.println("Hébergement trouvé : '" + hebergementChoisi.getNom() + "'");
            }
        } while (hebergementChoisi == null);

        // Saisie des dates
        System.out.print("\nDate d'arrivée (AAAA-MM-JJ) : ");
        String debutStr = scanner.nextLine();
        LocalDate dateDebut = LocalDate.parse(debutStr);
        System.out.print("Date de départ (AAAA-MM-JJ) : ");
        String finStr = scanner.nextLine();
        LocalDate dateFin = LocalDate.parse(finStr);

        // Réservation
        Réservation res = utilisateur.reserver(hebergementChoisi, dateDebut, dateFin);

        // Affichage du récapitulatif
        long nbNuits = java.time.temporal.ChronoUnit.DAYS.between(dateDebut, dateFin);
        double prixParNuit = hebergementChoisi.getPrixParNuit();
        double tauxReduc = utilisateur.verifierReduction() * 100;
        double montantBase = hebergementChoisi.calculerPrixSejour((int) nbNuits);

        System.out.println("\nRÉCAPITULATIF POUR : " + utilisateur.nom.toUpperCase() + " " + utilisateur.prenom);
        System.out.println("Hébergement : " + hebergementChoisi.getNom());
        System.out.println("Durée du séjour : " + nbNuits + " nuits");
        System.out.println("\nPrix brut (" + prixParNuit + "€ x " + nbNuits + " nuits) : " + montantBase + "€");
        System.out.println("Remise fidélité appliquée : " + tauxReduc + "%");
        System.out.println("\nMontant total : " + res.getPrixTotal() + "€");

        scanner.close();
    }
}
