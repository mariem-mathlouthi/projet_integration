package com.backendSpring.BackendSpring.Controller;

import com.backendSpring.BackendSpring.Service.FileManagementService;
import com.backendSpring.BackendSpring.entity.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Clock;

@RestController
@RequestMapping("/file")
public class FileManagementController {
    @Autowired
    private FileManagementService FM;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException,Exception {
        if(FM.uploadFile(file)) {
            return ResponseEntity.ok("File Uploaded successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Error occurred while uploading the file");
        }
    }
    @GetMapping("/download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename, HttpServletResponse response) throws IOException {
        if (FM.downloadFile(filename,response)) {
            System.out.println("File downloaded Successfully");
            return ResponseEntity.ok("File downloaded Successfully");
        }
        else {
            System.out.println("Error occurred while downloading the file");
            return ResponseEntity.badRequest().body("Error occurred while downloading the file");
        }
    }

    @GetMapping("/get/{filename}")
    public ResponseEntity<?> getAvatar(@PathVariable String filename) throws IOException {
        return FM.ReadAvatarLogo(filename);
    }

    @PostMapping("/generateAtt")
    public ResponseEntity<?> generateAttestation(@RequestBody Demande demande, HttpServletResponse response) throws IOException {
        if (FM.GenerateAttestation(demande)) {
            FM.downloadFile("attestation.pdf",response,"BackendSpring/src/main/resources/");
            return ResponseEntity.ok("Attestation Generated");
        }
        else {
            return ResponseEntity.badRequest().body("Error generating Attestation");
        }
    }
}
