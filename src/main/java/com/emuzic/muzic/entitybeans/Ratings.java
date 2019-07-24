package com.emuzic.muzic.entitybeans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ratings {
	@Id
	public long id;
	
	@Column(name="rating", nullable=false)
	int rating;
	
	@OneToOne(cascade = CascadeType.ALL)
	Users user;
	
	@OneToOne(cascade = CascadeType.ALL)
	Music music;
	
	@OneToOne(cascade = CascadeType.ALL)
	Album album;

}
