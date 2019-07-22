package com.emuzic.muzic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EStorageService {
	@Value( "${file.upload-dir}" )
	String storage_location;
		
	public boolean isMusic(MultipartFile file) throws WrongFileException{	
		
		String filepart[] = file.getOriginalFilename().split(".");
		System.err.println("length: " + filepart.length);
		if(filepart.length > 2 || filepart.length <= 0 || file.getName().contains("..")) {
			throw new WrongFileException("Please upload a Valid MP3 file");
		}
		String extension = filepart[1];
		if(!extension.equalsIgnoreCase(".mp3")) {
			throw new WrongFileException("Please upload a Valid MP3 file");
		}	
		
		return true;
		
	}
	
	public String storeFile(MultipartFile file, String username) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename()).replace(".mp3", "");
        filename = filename + "_" + username + new Date().toString() + ".mp3";

        try {
            
        	Path targetLocation = Paths.get(storage_location + "/" + filename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return filename;
        } catch (IOException ex) {
            throw new WrongFileException("Could not store file " + filename + ". Please try again!", ex);
        }
    }
	
	public Resource loadFileAsResource(String filename) {
        try {
            Path filePath = Paths.get(storage_location + filename);
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new ENotFoundException("File not found " + filename);
            }
        } catch (MalformedURLException ex) {
            throw new ENotFoundException("File not found " + filename, ex);
        }
    }
}
	
