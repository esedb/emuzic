package com.emuzic.muzic.entitybeans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter 
@Setter 
@NoArgsConstructor
@Entity
@Table(name="albums")
public class Album {
	@Id
	@Column(name="album_id", nullable=false, unique = true )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long albumId;
	
	@Column(name="album_name")
	String albumname;
	
	@Column(name="album_rating")
	Integer albumrating;
	
	@Column(name="time_ammased")
	private Date timeDuration;
	
		
	@OneToMany(mappedBy="album", cascade = CascadeType.ALL)
	Set<Music> music= new HashSet<Music>();
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	Users user;
	
}
