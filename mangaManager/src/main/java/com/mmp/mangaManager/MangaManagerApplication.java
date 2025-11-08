package com.mmp.mangaManager;

import com.mmp.mangaManager.domain.enums.Status;
import com.mmp.mangaManager.service.MangaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MangaManagerApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MangaManagerApplication.class, args);
        MangaService ms = ctx.getBean(MangaService.class);
        ms.addManga("tte","sat",1234,Status.COMPLETED);
        System.out.println(ms.getAllMangas());
    }
}
