package com.mmp.mangaManager.service;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.domain.enums.Status;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MangaService {
    private List<Manga> mangas = new ArrayList<>();

    public List<Manga> getAllMangas() {
        return mangas;
    }

    public void addManga(String title, String author, Integer year, Status status) {

    }

    public static void main(String[] args) {
        System.out.println(new MangaService().getAllMangas());
    }

}
