package co.edu.icesi.deezerapi.service.impl;

import co.edu.icesi.deezerapi.dto.PlayListDTO;
import co.edu.icesi.deezerapi.dto.TrackDTO;
import co.edu.icesi.deezerapi.model.PlayList;
import co.edu.icesi.deezerapi.model.Track;
import co.edu.icesi.deezerapi.repository.PlayListRepository;
import co.edu.icesi.deezerapi.repository.TrackRepository;
import co.edu.icesi.deezerapi.service.PlayListService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayListServiceImpl implements PlayListService {

    @Autowired
    private PlayListRepository playListRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public PlayList createPlaylist(PlayList playlist) {
        return playListRepository.save(playlist);
    }

    @Override
    public List<PlayListDTO> getAllPlaylistDTOs() {
        return playListRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deletePlaylist(Long id) {
        Optional<PlayList> optional = playListRepository.findById(id);
        if (optional.isPresent()) {
            PlayList playlist = optional.get();
            playlist.getTracks().forEach(track -> track.setPlayList(null));
            playListRepository.delete(playlist);
        }
    }

    @Override
    public void addTrackToPlaylist(Long playlistId, TrackDTO trackDTO) {
        Optional<PlayList> playlistOpt = playListRepository.findById(playlistId);

        if (playlistOpt.isPresent()) {
            PlayList playlist = playlistOpt.get();

            Track track = new Track();
            track.setTitle(trackDTO.getTitle());
            track.setDuration(trackDTO.getDuration());
            track.setRank(trackDTO.getRank());
            track.setArtistName(trackDTO.getArtistName());
            track.setAlbumTitle(trackDTO.getAlbumTitle());
            track.setArtistPicture(trackDTO.getArtistPicture());
            track.setAlbumCover(trackDTO.getAlbumCover());
            track.setPlayList(playlist);  // Asocia la playlist

            trackRepository.save(track);
        } else {
            throw new EntityNotFoundException("Playlist con id " + playlistId + " no encontrada");
        }
    }



    @Override
    public void removeTrackFromPlaylist(Long playlistId, Long trackId) {
        Optional<Track> trackOpt = trackRepository.findById(trackId);
        if (trackOpt.isPresent()) {
            Track track = trackOpt.get();
            if (track.getPlayList() != null && track.getPlayList().getId().equals(playlistId)) {
                track.setPlayList(null);
                trackRepository.save(track);
            }
        }
    }

    @Override
    public List<Track> getTracksByPlaylist(Long playlistId) {
        return trackRepository.findAll().stream()
                .filter(t -> t.getPlayList() != null && t.getPlayList().getId().equals(playlistId))
                .collect(Collectors.toList());
    }

    private PlayListDTO toDTO(PlayList p) {
        PlayListDTO dto = new PlayListDTO();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setMood(p.getMood());
        return dto;
    }
}
