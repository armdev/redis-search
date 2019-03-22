/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.resource;

import io.micrometer.core.annotation.Timed;
import io.project.app.services.GoogleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class GoogleResource {

    @Autowired
    private GoogleService googleService;

    @GetMapping
    @Timed
    @ResponseBody
    public ResponseEntity<?> find(@RequestParam String key) {
        googleService.find();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could not process this request");

    }

}
