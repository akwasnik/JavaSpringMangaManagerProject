package com.mmp.mangaManager.service;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.domain.enums.Status;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MangaService {
    private List<Manga> mangas = new ArrayList<>();
    private String fileName = "mangas.csv";
    private InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);

    public MangaService() {
        this.mangas = loadMangasFromCsv();
    }

    private List<Manga> loadMangasFromCsv() {
        try{
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
                            Status status = Status.valueOf(data[4]);

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

    public void addManga(String title, String author, Integer year, Status status) {
        Integer id = mangas.size() + 1;
        String line = id.toString() + "," + title + "," + author + "," + year.toString() + "," + status.toString();
        try {
            File file = new ClassPathResource(fileName).getFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.newLine();
                writer.write(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
