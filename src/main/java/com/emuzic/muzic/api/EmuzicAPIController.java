package com.emuzic.muzic.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emuzic.muzic.*;
import com.emuzic.muzic.entitybeans.Album;
import com.emuzic.muzic.entitybeans.Music;

import com.emuzic.muzic.entitybeans.Users;

@RestController
@RequestMapping("/api")
public class EmuzicAPIController {
	
	@Autowired
	UsersService user_service;	
	
	@Autowired
	UserRepository user_repo;	
	@Autowired
	MusicRepository music_repo;
	
	@Autowired
	AlbumRepository album_repo;
	
	@Autowired
	EStorageService storage_service;
	
	
	
	@Autowired
	@RequestMapping("")
	@ResponseBody
	public List<Music> allMusic() {
		
		List<Music> music_list = music_repo.findAll();
		if(music_list.size() <= 0) {
			return null;
		}
		
		return music_repo.findAll();
	}
	
	@PostMapping("user/signup")
	@ResponseBody
	public Users createUser(@RequestBody @Valid Users user, BindingResult bindingresult) {		
		if(bindingresult.hasErrors()) {
			return null;
		}
		return user_repo.save(user);	
	}
	
	@GetMapping("user/allusers")
	@ResponseBody
	public List<Users> getAllUser(){		
		return user_repo.findAll();		
	}
	
	@PostMapping("user/update")
	@ResponseBody
	public Users updateUsers(@RequestBody @Valid Users user, BindingResult bindingresult) {
		if(user==null) {
			
		}
		return user_repo.save(user);
	}
	
	@PostMapping("music/uploadmusic/{username}/{album_id}")
	@ResponseBody
	public Music createMusic(@RequestParam("file") MultipartFile file, @PathVariable("username") String username, @PathVariable("album_id") String id) {
		System.err.println("filename:>>> " + file.getOriginalFilename());
		if(CUtility.isNull(username) || storage_service.isMusic(file)) {			
			return null;
		}
		Long album_id = Long.parseLong(id);
		Optional<Album> album_opt = album_repo.findById(album_id);
		Album album = album_opt.get();
		Users user = user_repo.findByUsername(username);
		
		if(album == null || user == null) {
			return null;
		}
		String filename = storage_service.storeFile(file, username);
		Music music = new Music();
		music.setName(filename.split("_")[0]);
		music.setAlbum(album);
		music.setUser(user);
				
				
		return music_repo.save(music);
	}
	
	@GetMapping("music/updatemusic/{music_id}")
	@ResponseBody
	public Music updateMusic(@RequestBody @Valid Music music, @PathVariable("music_id") String id,  BindingResult bidningresult) {		
		if(CUtility.isNull(music.getName()) || id == null) {
			return null;
		}
		Optional<Music> music_opt =music_repo.findById(Long.parseLong(id));
		Music opt_music = music_opt.get();
		opt_music.getId();
	
		
		return music_repo.save(music);
	}
	
	@GetMapping("music/search/{name}")
	@ResponseBody
	public List<Music> findMusic(@PathVariable("name") String name) {
		if(CUtility.isNull(name)){
			return null;
		}
		List<Music> music = music_repo.findAllByName(name);
		return music;
		
	}
	
	@PostMapping("/album/create/{username}")
	@ResponseBody
	public Album createAlbum(@RequestBody @Valid Album album, @PathVariable("username") String username, BindingResult bindingresult){
		if(album == null) {
			return null;
		}
		Users user = user_repo.findByUsername(username);
		album.setUser(user);
		
		return album_repo.save(album);		
	}
	@PostMapping("/album/search/{name}")
	@ResponseBody
	public List<Album> searchAlbum(@PathVariable("name") String albumname){
		if(CUtility.isNull(albumname)) {
			return null;
		}
		
		List<Album> album = album_repo.findByAlbumname(albumname);
		return album;
		
	}
	@PostMapping("/album/delete/{id}")
	@ResponseBody
	public Album deleteAlbum(@PathVariable("id") String id) {
		if(CUtility.isNull(id)) {
			return null;
		}
		Optional<Album> option_album = album_repo.findById(Long.parseLong(id));
		Album album = option_album.get();
		album_repo.delete(album);
		
		return album;
		
	}
	
}
