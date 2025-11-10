package com.mmp.mangaManager.repository;

import com.mmp.mangaManager.domain.Manga;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepository extends MongoRepository<Manga, String> {
}
