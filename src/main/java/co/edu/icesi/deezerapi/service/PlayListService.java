package co.edu.icesi.deezerapi.service;

import co.edu.icesi.deezerapi.dto.PlayListDTO;
import co.edu.icesi.deezerapi.dto.TrackDTO;
import co.edu.icesi.deezerapi.model.PlayList;
import co.edu.icesi.deezerapi.model.Track;

import java.util.List;

public interface PlayListService {

    PlayList createPlaylist(PlayList playlist);

    List<PlayListDTO> getAllPlaylistDTOs();

    void deletePlaylist(Long id);

    void addTrackToPlaylist(Long playlistId, TrackDTO trackId);

    void removeTrackFromPlaylist(Long playlistId, Long trackId);

    List<Track> getTracksByPlaylist(Long playlistId);
}
