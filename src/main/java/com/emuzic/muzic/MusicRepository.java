package com.emuzic.muzic;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emuzic.muzic.entitybeans.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
	List<Music> findAllByName(String name);
}
