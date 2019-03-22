package io.project.app.services;

import io.project.app.domain.SearchData;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import io.project.app.repositories.SearchRepository;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *
 * @author armena
 */
@Service
@Component
@Slf4j
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private RedisTemplate<String, SearchData> redisTemplate;

    public SearchData save(SearchData googleSearch) {
        return searchRepository.save(googleSearch);

    }

    public Optional<SearchData> find(String id) {
        return searchRepository.findById(id);

    }

}
