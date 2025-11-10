package com.mmp.mangaManager.domain;

import com.mmp.mangaManager.domain.enums.Status;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mangas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manga {
    private String title;
    private String author;
    private Integer year;
    private Status status;
}
