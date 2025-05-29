package co.edu.icesi.deezerapi.repository;

import co.edu.icesi.deezerapi.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
