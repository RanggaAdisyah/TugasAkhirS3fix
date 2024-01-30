package controller;

import model.Film;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AdminController {
    private ArrayList<Film> films;
    private static final String FILE_NAME = "film_data.txt";

    public AdminController(ArrayList<Film> films) {
        this.films = films;
        loadDataFromFile();
    }


    public void addFilm(String judul, String jadwal, String studio) {
        Film newFilm = new Film(judul, jadwal, studio);
        films.add(newFilm);
        System.out.println("Film added successfully: " + newFilm.getjudul());
    }

    public void deleteFilm(String filmjudul) {
        films.removeIf(film -> film.getjudul().equals(filmjudul));
        saveDataToFile();
        System.out.println("Film deleted successfully: " + filmjudul);
    }


    public void managejadwal(String filmjudul, String newjadwal) {
        for (Film film : films) {
            if (film.getjudul().equals(filmjudul)) {
                film.setjadwal(newjadwal);
                System.out.println("jadwal updated successfully for " + filmjudul);
                return;
            }
        }
        System.out.println("Film not found: " + filmjudul);
    }

    public void displayFilmList() {
        System.out.println("List of Films:");
        for (Film film : films) {
            System.out.println(film.getjudul() + " | " + film.getjadwal() + " | " + film.getStudio());
        }
    }

    public void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Film film : films) {
                writer.write(film.getjudul() + "," + film.getjadwal() + "," + film.getStudio() + "\n");
            }
            System.out.println("Data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadDataFromFile() {
        films.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String judul = parts[0];
                    String jadwal = parts[1];
                    String studio = parts[2];
                    Film film = new Film(judul, jadwal, studio);
                    films.add(film);
                }
            }
            System.out.println("Data loaded successfully from " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Film> searchFilm(String filmjudul) {
        ArrayList<Film> searchResults = new ArrayList<>();
        for (Film film : films) {
            if (film.getjudul().equals(filmjudul)) {
                searchResults.add(film);
            }
        }
        return searchResults;
    }


    public ArrayList<Film> getFilms() {
        return films;
    }

    
}
