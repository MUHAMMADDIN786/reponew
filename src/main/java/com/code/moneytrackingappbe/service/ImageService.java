package com.code.moneytrackingappbe.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class ImageService {
    private final Path root = Paths.get("images");

    public String saveImages(MultipartFile imageFile) {
        try {
            String fileName = imageFile.getOriginalFilename() + UUID.randomUUID();
            Files.copy(imageFile.getInputStream(), this.root.resolve(fileName));
            return "https://" + "moneytransactionapp" + "/images/get-i  mage?fileName=" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Resource getImage(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

}



