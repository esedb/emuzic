package com.emuzic.muzic;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emuzic.muzic.entitybeans.Ratings;

public interface RatingRepository extends JpaRepository<Ratings, Long> {
	

}
