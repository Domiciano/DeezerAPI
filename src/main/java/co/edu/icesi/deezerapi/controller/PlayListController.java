package co.edu.icesi.deezerapi.controller;

import co.edu.icesi.deezerapi.dto.PlayListDTO;
import co.edu.icesi.deezerapi.dto.TrackDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PlayListController {

    @PostMapping
    ResponseEntity<PlayListDTO> createPlaylist(@RequestBody PlayListDTO playlistDTO);

    @GetMapping
    ResponseEntity<List<PlayListDTO>> getAllPlaylists();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePlaylist(@PathVariable Long id);

    @PostMapping("/{playlistId}/tracks/{trackId}")
    ResponseEntity<Void> addTrackToPlaylist(@PathVariable Long playlistId, @RequestBody TrackDTO trackDto);

    @DeleteMapping("/{playlistId}/tracks/{trackId}")
    ResponseEntity<Void> removeTrackFromPlaylist(@PathVariable Long playlistId, @PathVariable Long trackId);

    @GetMapping("/{playlistId}/tracks")
    ResponseEntity<List<TrackDTO>> getTracksByPlaylist(@PathVariable Long playlistId);
}
