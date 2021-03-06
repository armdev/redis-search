/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.resource;

import io.micrometer.core.annotation.Timed;
import io.project.app.domain.SearchData;
import io.project.app.services.SearchService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/search")
@Slf4j
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    @Timed
    @ResponseBody
    public ResponseEntity<?> find(@RequestParam String id) {
        Optional<SearchData> find = searchService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(find.get());

    }

    @GetMapping("/search")
    @Timed
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam String id) {
        SearchData search = searchService.search(id);
        return ResponseEntity.status(HttpStatus.OK).body(search);

    }

    @PostMapping
    @Timed
    @ResponseBody
    public ResponseEntity<?> post(@RequestBody SearchData googleSearch) {
        SearchData save = searchService.save(googleSearch);
        return ResponseEntity.status(HttpStatus.OK).body("Data saved");

    }

}
