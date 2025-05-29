package co.edu.icesi.deezerapi.service.impl;

import co.edu.icesi.deezerapi.service.DeezerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeezerServiceImpl implements DeezerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${deezer.api.url.search}")
    private String BASE_URL;

    @Override
    public String search(String query) {
        String url = BASE_URL + query;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

}
