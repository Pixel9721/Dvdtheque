package Model;

public class ModelActeur {

    public static final int ID = 0;
    public static final int NomA = 1;
    public static final int PrenomA = 2;
    public static final int Image = 3;

    private String idActeur;
    private String nomActeur;
    private String prenomActeur;
    private String imageActeur;



    public ModelActeur(String idActeur, String nomActeur, String prenomActeur, String imageActeur) {
        this.idActeur = idActeur;
        this.nomActeur = nomActeur;
        this.prenomActeur = prenomActeur;
        this.imageActeur = imageActeur;
    }

    public void setIdActeur(String idActeur) { this.idActeur = idActeur; }
    public void setNomActeur(String nomActeur) { this.nomActeur = nomActeur; }
    public void setPrenomActeur(String prenomActeur) { this.prenomActeur = prenomActeur; }
    public void setImageActeur(String imageActeur) { this.imageActeur = imageActeur; }

    public String getIdActeur() { return idActeur; }
    public String getNomActeur() { return nomActeur; }
    public String getPrenomActeur() { return prenomActeur; }
    public String getImageActeur() { return imageActeur; }
}
