package co.edu.icesi.deezerapi.controller.impl;

import co.edu.icesi.deezerapi.controller.DeezerController;
import co.edu.icesi.deezerapi.service.DeezerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/deezer")
public class DeezerControllerImpl implements DeezerController {

    @Autowired
    private DeezerService DeezerService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> searchDeezer(@RequestParam String q) {
        String result = DeezerService.search(q);
        return ResponseEntity.ok(result);
    }

}
