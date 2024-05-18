package com.backendSpring.BackendSpring.Service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileManagementService {
    @Value("${upload.directory}")
    String uploadDirectory;

    public boolean uploadFile(MultipartFile file) throws IOException,Exception {
        try {
            if (Files.notExists(Paths.get(uploadDirectory))) {
                Files.createDirectories(Paths.get(uploadDirectory));
            };
            File F = new File(uploadDirectory + File.separator + file.getOriginalFilename());
            file.transferTo(F.toPath());
            return true;
        } catch (IOException e) {
            System.out.println("IOException : " + e);
            return false;
        }
        catch (Exception e) {
            System.out.println("General Exception : " + e);
            return false;
        }
    }

    public boolean downloadFile(String filename, HttpServletResponse response) throws IOException {
        try {
            Path filePath = Paths.get(uploadDirectory + File.separator + filename);
            // set content type
            response.setContentType(Files.probeContentType(filePath));
            // set content length
            response.setContentLengthLong(Files.size(filePath));
            // add CONTENT_DISPOSITION header to response
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment()
                    .filename(filePath.getFileName().toString(), StandardCharsets.UTF_8)
                    .build()
                    .toString());
            // the actual copy of fileData
            Files.copy(filePath, response.getOutputStream());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ResponseEntity<?> ReadAvatarLogo(String filename) throws MalformedURLException {
        // Load the image as a resource
        Resource resource = new UrlResource(Paths.get(uploadDirectory).resolve(filename).toUri());
        // Set the appropriate content type
        MediaType mediaType = SetMediaType(filename);
        // Return the image as bytes
        return ResponseEntity.ok().contentType(mediaType).body(resource);
    }


    private MediaType SetMediaType(String imageName) {
        // file type based on file extension
        if (imageName.endsWith(".jpg") || imageName.endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else if (imageName.endsWith(".png")) {
            return MediaType.IMAGE_PNG;
        } else if (imageName.endsWith(".gif")) {
            return MediaType.IMAGE_GIF;
        } else {
            // Default to octet-stream for other file types
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
