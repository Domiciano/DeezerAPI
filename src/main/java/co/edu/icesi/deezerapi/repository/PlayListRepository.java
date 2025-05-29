package co.edu.icesi.deezerapi.repository;

import co.edu.icesi.deezerapi.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
}
