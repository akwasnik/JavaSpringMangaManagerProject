package com.mmp.mangaManager.service;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.domain.enums.Status;
import com.mmp.mangaManager.repository.MangaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    private final MangaRepository mangaRepository;

    public MangaService(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    public Manga addManga(String title, String author, Integer year, Status status) {
        Manga manga = new Manga(title, author, year, status);
        return mangaRepository.save(manga);
    }

    public void deleteManga(String id) {
        mangaRepository.deleteById(id);
    }
}
