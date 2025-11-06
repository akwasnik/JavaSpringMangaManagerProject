package com.mmp.mangaManager.controller;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.service.MangaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    private final MangaService mangaService;

    public MangaController(MangaService mangaService){
        this.mangaService = mangaService;
    }

    @GetMapping
    public List<Manga> getAllMangas() {
        return mangaService.getAllMangas();
    }
}
