package com.mmp.mangaManager.controller;

import com.mmp.mangaManager.domain.Manga;
import com.mmp.mangaManager.domain.enums.Status;
import com.mmp.mangaManager.service.MangaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String addManga(@RequestBody Map<String,Object> body){
        System.out.println("Requested mangas POST");
        String title = (String) body.get("title");
        String author = (String) body.get("author");
        Integer year = (Integer) body.get("year");
        String statusValue = (String) body.get("status");
        Status status = Status.valueOf(statusValue);
        mangaService.addManga(title,author,year,status);
        return "Added manga "+title;
    }
}
