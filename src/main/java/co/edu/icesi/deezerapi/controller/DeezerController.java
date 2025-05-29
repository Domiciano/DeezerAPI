package co.edu.icesi.deezerapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface DeezerController {
    @GetMapping("/search")
    ResponseEntity<String> searchDeezer(@RequestParam String q);
}
