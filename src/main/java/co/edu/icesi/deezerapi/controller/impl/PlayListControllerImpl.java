package co.edu.icesi.deezerapi.controller.impl;

import co.edu.icesi.deezerapi.controller.PlayListController;
import co.edu.icesi.deezerapi.dto.PlayListDTO;
import co.edu.icesi.deezerapi.dto.TrackDTO;
import co.edu.icesi.deezerapi.model.PlayList;
import co.edu.icesi.deezerapi.model.Track;
import co.edu.icesi.deezerapi.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/playlists")
public class PlayListControllerImpl implements PlayListController {

    @Autowired
    private PlayListService playListService;

    @PostMapping
    public ResponseEntity<PlayListDTO> createPlaylist(@RequestBody PlayListDTO playlistDTO) {
        PlayList playlist = new PlayList();
        playlist.setName(playlistDTO.getName());
        playlist.setMood(playlistDTO.getMood());
        PlayList saved = playListService.createPlaylist(playlist);
        PlayListDTO dto = new PlayListDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setMood(saved.getMood());
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PlayListDTO>> getAllPlaylists() {
        List<PlayListDTO> playlists = playListService.getAllPlaylistDTOs();
        return ResponseEntity.ok(playlists);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playListService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{playlistId}/tracks")
    public ResponseEntity<Void> addTrackToPlaylist(@PathVariable Long playlistId, @RequestBody TrackDTO trackDTO) {
        playListService.addTrackToPlaylist(playlistId, trackDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{playlistId}/tracks/{trackId}")
    public ResponseEntity<Void> removeTrackFromPlaylist(@PathVariable Long playlistId, @PathVariable Long trackId) {
        playListService.removeTrackFromPlaylist(playlistId, trackId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{playlistId}/tracks")
    public ResponseEntity<List<TrackDTO>> getTracksByPlaylist(@PathVariable Long playlistId) {
        List<Track> tracks = playListService.getTracksByPlaylist(playlistId);
        List<TrackDTO> dtoList = tracks.stream().map(t -> {
            TrackDTO dto = new TrackDTO();
            dto.setId(t.getId());
            dto.setTitle(t.getTitle());
            dto.setDuration(t.getDuration());
            dto.setRank(t.getRank());
            dto.setArtistName(t.getArtistName());
            dto.setAlbumTitle(t.getAlbumTitle());
            dto.setArtistPicture(t.getArtistPicture());
            dto.setAlbumCover(t.getAlbumCover());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
