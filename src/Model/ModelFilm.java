package Model;

public class ModelFilm {

    public static final int ID = 0;
    public static final int NomF = 1;
    public static final int Annee = 2;
    public static final int Note = 3;
    public static final int Resume = 4;
    public static final int Image = 5;


    private String idFilm;
    private String nomFilm;
    private String anneeFilm;
    private String resumeFilm;
    private String noteFilm;
    private String imageFilm;


    public ModelFilm(String idFilm, String nomFilm, String anneeFilm, String noteFilm, String resumeFilm) {
        this.idFilm = idFilm;
        this.nomFilm = nomFilm;
        this.anneeFilm = anneeFilm;
        this.noteFilm = noteFilm;
        this.resumeFilm = resumeFilm;
        this.imageFilm = imageFilm;
    }


    public void setIdFilm(String idFilm) { this.idFilm = idFilm; }
    public void setNomFilm(String nomFilm) { this.nomFilm = nomFilm; }
    public void setAnneeFilm(String anneeFilm) { this.anneeFilm = anneeFilm; }
    public void setNoteFilm(String noteFilm) { this.noteFilm = noteFilm; }
    public void setResumeFilm(String resumeFilm) { this.resumeFilm = resumeFilm; }
    public void setImageFilm(String imageFilm) { this.imageFilm = imageFilm; }

    public String getIdFilm() { return idFilm; }
    public String getNomFilm() { return nomFilm; }
    public String getAnneeFilm() { return anneeFilm; }
    public String getNoteFilm() { return noteFilm; }
    public String getResumeFilm() { return resumeFilm; }
    public String getImageFilm() { return imageFilm; }

}
