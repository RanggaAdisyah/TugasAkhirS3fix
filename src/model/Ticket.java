package model;

public class Ticket {
    private String pengunjung;
    private Film film;
    private String jadwal;
    private String studio;
    
    public Ticket(String pengunjung, Film film, String jadwal, String studio) {
        this.pengunjung = pengunjung;
        this.film = film;
        this.jadwal = jadwal;
        this.studio = studio;
    }
    public String getpengunjung() {
        return pengunjung;
    }
    public void setpengunjung(String pengunjung) {
        this.pengunjung = pengunjung;
    }
    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }
    public String getjadwal() {
        return jadwal;
    }
    public void setjadwal(String jadwal) {
        this.jadwal = jadwal;
    }
    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }

    
}
