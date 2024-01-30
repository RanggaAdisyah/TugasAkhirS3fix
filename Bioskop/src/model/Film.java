package model;

public class Film {
    private String judul;
    private String jadwal;
    private String studio;

    public Film(String judul, String jadwal, String studio) {
        this.judul = judul;
        this.jadwal = jadwal;
        this.studio = studio;
    }

    public String getjudul() {
        return judul;
    }

    public void setjudul(String judul) {
        this.judul = judul;
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
