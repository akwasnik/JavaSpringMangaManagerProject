package com.mmp.mangaManager.controller;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.domain.enums.Status;
import com.mmp.mangaManager.service.MangaService;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("Requested mangas GET");
        return mangaService.getAllMangas();
    }

    @PostMapping
    public String addManga(@RequestBody String title,@RequestBody String author, @RequestBody Integer year, @RequestBody String statusValue){
        System.out.println("Requested mangas POST");
        Status status = Status.valueOf(statusValue);
        mangaService.addManga(title,author,year,status);
        return "Added manga "+title;
    }
}
