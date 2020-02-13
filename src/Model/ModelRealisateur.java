package Model;

public class ModelRealisateur {
    public static final int ID = 0;
    public static final int Nom = 1;
    public static final int Prenom = 2;
    public static final int Image = 3;

    private String id;
    private String nom;
    private String prenom;
    private String image;



    public ModelRealisateur(String id, String nom, String prenom, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
    }

    public void setIdActeur(String id) { this.id = id; }
    public void setNomActeur(String nom) { this.nom = nom; }
    public void setPrenomActeur(String prenom) { this.prenom = prenom; }
    public void setImageActeur(String image) { this.image = image; }

    public String getIdActeur() { return id; }
    public String getNomActeur() { return nom; }
    public String getPrenomActeur() { return prenom; }
    public String getImageActeur() { return image; }
}

