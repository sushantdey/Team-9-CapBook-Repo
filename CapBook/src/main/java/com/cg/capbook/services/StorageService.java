 package com.cg.capbook.services;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class StorageService {
	private final Path rootLocation=Paths.get("D:\\java\\finalProject\\userImages");
	
	public void store(MultipartFile file) {
		try {
			Files.copy(
					file.getInputStream(),this.rootLocation.resolve(file.getOriginalFilename()));
		}catch(Exception e) {
			throw new RuntimeException("fail");
		}
	}
}
