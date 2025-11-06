package com.mmp.mangaManager.service;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.domain.enums.Status;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MangaService {
    private List<Manga> mangas;

    public MangaService() {
        this.mangas = loadMangasFromCsv("mangas.csv");
    }

    private List<Manga> loadMangasFromCsv(String fileName) {
        try{
            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new RuntimeException("Nie znaleziono pliku: " + fileName);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            return br.lines()
                        .skip(1)
                        .map(line -> {
                            String[] data = line.split(",");

                            Integer id = Integer.parseInt(data[0]);
                            String title = data[1];
                            String author = data[2];
                            Integer year = Integer.parseInt(data[3]);
                            Status status = Status.valueOf(data[4].trim().toUpperCase());

                            return new Manga(id, title, author, year, status);
                        })
                        .collect(Collectors.toList());
        }catch (Exception e){
            throw new RuntimeException("Błąd podczas wczytywania CSV: " + e.getMessage(),e);
        }
    }

    public List<Manga> getAllMangas() {
        return mangas;
    }
}
