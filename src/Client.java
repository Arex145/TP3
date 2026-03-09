import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client extends Personne {
    protected LocalDate dateInscription;
    protected List<Réservation> reservations;

    public Client(int id, String nom, String prenom, String email, String motDePasse, LocalDate dateInscription) {
        super(id, nom, prenom, email, motDePasse);
        this.dateInscription = dateInscription;
        this.reservations = new ArrayList<>();
    }

    public double verifierReduction() { return 0.0; }

        public Réservation reserver(Hébergement h, LocalDate debut, LocalDate fin) {
        Réservation r = new Réservation(reservations.size() + 1, this, h, debut, fin);
        reservations.add(r);
        return r;
    }
}

class NouveauClient extends Client {
    public NouveauClient(int id, String nom, String prenom, String email, String motDePasse, LocalDate dateInscription) {
        super(id, nom, prenom, email, motDePasse, dateInscription);
    }
}

class AncienClient extends Client {
    private int nombreReservations;

    public AncienClient(int id, String nom, String prenom, String email, String motDePasse, LocalDate dateInscription, int nbRes) {
        super(id, nom, prenom, email, motDePasse, dateInscription);
        this.nombreReservations = nbRes;
    }

    public double verifierReduction() {
        if (this.nombreReservations > 5) {
            return 0.10; // 10% de réduction
        } else {
            return 0.05; // 5% de réduction
        }
    }
}