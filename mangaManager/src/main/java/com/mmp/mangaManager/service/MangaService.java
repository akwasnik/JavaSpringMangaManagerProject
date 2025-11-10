package com.mmp.mangaManager.service;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.domain.enums.Status;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MangaService {
    private static final Path DB_PATH = Path.of("db/mangas.csv");
    private List<Manga> mangas = loadMangasFromCsv();

    private List<Manga> loadMangasFromCsv() {
        try (BufferedReader br = Files.newBufferedReader(DB_PATH)) {
            return br.lines()
                    .skip(1)
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> {
                        String[] data = line.split(",");
                        Integer id = Integer.parseInt(data[0]);
                        String title = data[1];
                        String author = data[2];
                        Integer year = Integer.parseInt(data[3]);
                        Status status = Status.valueOf(data[4]);
                        return new Manga(id, title, author, year, status);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Błąd przy wczytywaniu CSV: " + e.getMessage(), e);
        }
    }

    public List<Manga> getAllMangas() {
        return mangas;
    }

    public void addManga(String title, String author, Integer year, Status status) {
        Integer id = mangas.size() + 1;
        String line = id + "," + title + "," + author + "," + year + "," + status;
        try (BufferedWriter writer = Files.newBufferedWriter(DB_PATH, StandardOpenOption.APPEND)) {
            writer.newLine();
            writer.write(line);
            mangas.add(new Manga(id, title, author, year, status));
            System.out.println("Dodano mange: " + title);
        } catch (IOException e) {
            throw new RuntimeException("Błąd zapisu CSV: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MangaService().getAllMangas());
    }

}
