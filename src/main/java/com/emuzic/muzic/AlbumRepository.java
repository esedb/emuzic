package com.emuzic.muzic;

import com.emuzic.muzic.entitybeans.Album;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends  JpaRepository<Album, Long> {	
	List<Album> findByAlbumname(String albumname);
}
