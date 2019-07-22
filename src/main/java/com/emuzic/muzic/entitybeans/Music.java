package com.emuzic.muzic.entitybeans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Data
@Getter 
@Setter 
@NoArgsConstructor
@Entity
@Table(name="music")
public class Music {
	
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="music_name", nullable=false)
	String name;
	
	@Column(name="music_owner", nullable=false)
	String music_owner;
	
	@Column(name="album_rating", nullable=true)
	String albumRating;
	
	@Basic
	@Temporal(TemporalType.TIME)
	private Date timeDuration;
	
	@Column(name="music_format")
	String musicFormat;
	
	@Column(name="downloadable")
	String downloadable;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "users_id")
	Users user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="album_id")
	private Album album;
	

}
