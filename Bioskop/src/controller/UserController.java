package controller;

import model.Film;
import model.Ticket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserController {
    private ArrayList<Film> availableFilms;
    private ArrayList<Ticket> transactions;
    private static final String FILE_NAME = "film_data.txt";
    public static final String USER_FILE_NAME = "user_data.txt";

    public UserController(ArrayList<Film> availableFilms) {
        this.availableFilms = availableFilms;
        this.transactions = new ArrayList<>();
        loadDataFromFile();
    }

    public void displayAvailableFilms() {
        System.out.println("Available Films:");
        for (Film film : availableFilms) {
            System.out.println(film.getjudul() + " | " + film.getjadwal() + " | " + film.getStudio());
        }
    }

    public void bookTicket(String filmjudul, String pengunjung) {
        for (Film film : availableFilms) {
            if (film.getjudul().equals(filmjudul)) {
                Ticket newTicket = new Ticket(pengunjung, film, film.getjadwal(), film.getStudio());
                transactions.add(newTicket);
                System.out.println("Ticket booked successfully for " + filmjudul);
                return;
            }
        }
        System.out.println("Film not found: " + filmjudul);
    }

    public void displayTransactionDetails() {
        System.out.println("Transaction Details:");
        for (Ticket ticket : transactions) {
            System.out.println("Visitor: " + ticket.getpengunjung() + " | Film: " + ticket.getFilm().getjudul() +
                    " | jadwal: " + ticket.getjadwal() + " | Studio: " + ticket.getStudio());
        }
    }

    public Film findFilmByjudul(String judul) {
        for (Film film : availableFilms) {
            if (film.getjudul().equalsIgnoreCase(judul)) {
                return film;
            }
        }
        return null;
    }

    public void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Film film : availableFilms) {
                writer.write(film.getjudul() + "," + film.getjadwal() + "," + film.getStudio() + "\n");
            }
            System.out.println("Data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTransactionToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_NAME,true))) {
            for (Ticket ticket : transactions) {
                writer.write(ticket.getpengunjung() + "," + ticket.getFilm().getjudul() + "," +
                        ticket.getjadwal() + "," + ticket.getStudio() + "\n");
            }
            System.out.println("Transaction data saved successfully to " + USER_FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Film> getAvailableFilms() {
        return availableFilms;
    }

    private void loadDataFromFile() {
        availableFilms.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String judul = parts[0];
                    String jadwal = parts[1];
                    String studio = parts[2];
                    Film film = new Film(judul, jadwal, studio);
                    availableFilms.add(film);
                }
            }
            System.out.println("Data loaded successfully from " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ticket> getTransactions() {
        return transactions;
    }
    
}
