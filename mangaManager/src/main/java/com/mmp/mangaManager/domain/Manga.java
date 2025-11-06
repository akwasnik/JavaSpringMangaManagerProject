package com.mmp.mangaManager.domain;

import com.mmp.mangaManager.domain.enums.Status;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manga {
    private Integer id;
    private String title;
    private String author;
    private Integer year;
    private Status status;

}
