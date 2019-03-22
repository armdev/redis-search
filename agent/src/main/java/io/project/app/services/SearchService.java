package io.project.app.services;

import io.project.app.domain.DataSearch;
import io.project.app.repositories.GoogleRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author armena
 */
@Service
@Component
@Slf4j
public class SearchService {
    
    @Autowired
    private GoogleRepository googleRepository;
    
    public DataSearch save(DataSearch googleSearch){
        return googleRepository.save(googleSearch);
        
    }
    
    public Optional<DataSearch> find(String id){
        return googleRepository.findById(id);
        
    }
    
}
