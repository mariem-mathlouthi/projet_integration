package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.FileManagementService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileManagementController {
    @Autowired
    private FileManagementService FM;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(FM.uploadFile(file)) {
            return ResponseEntity.ok("File Uploaded successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Error occurred while uploading the file");
        }
    }
    @GetMapping("/download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename,HttpServletResponse response) throws IOException {
        if (FM.downloadFile(filename,response)) {
            System.out.println("File downloaded Successfully");
            return ResponseEntity.ok("File downloaded Successfully");
        }
        else {
            System.out.println("Error occurred while downloading the file");
            return ResponseEntity.badRequest().body("Error occurred while downloading the file");
        }
    }
}
