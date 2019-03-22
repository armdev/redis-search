/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.repositories;

import io.project.app.domain.GoogleSearch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author armena
 */
@Repository
@Component
public interface GoogleRepository extends CrudRepository<GoogleSearch, String>{
    
}
