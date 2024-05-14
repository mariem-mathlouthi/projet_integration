package com.backendSpring.BackendSpring.Service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileManagementService {
    @Value("${upload.directory}")
    String uploadDirectory;

    public boolean uploadFile(MultipartFile file) throws IOException {
        try {
            File F = new File(uploadDirectory + File.separator + file.getOriginalFilename());
            file.transferTo(F.toPath());
            return true;
        } catch (IOException e) {
            System.out.println(e);
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
}
