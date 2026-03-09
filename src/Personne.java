public abstract class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;

    public Personne(int id, String nom, String prenom, String email, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public abstract double verifierReduction();
}