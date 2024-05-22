package com.backendSpring.BackendSpring.Service;


import com.backendSpring.BackendSpring.entity.Demande;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class FileManagementService {
    @Value("${upload.directory}")
    String uploadDirectory;

    public boolean uploadFile(MultipartFile file) throws IOException, Exception {
        try {
            if (Files.notExists(Paths.get(uploadDirectory))) {
                Files.createDirectories(Paths.get(uploadDirectory));
            }
            ;
            File F = new File(uploadDirectory + File.separator + file.getOriginalFilename());
            file.transferTo(F.toPath());
            return true;
        } catch (IOException e) {
            System.out.println("IOException : " + e);
            return false;
        } catch (Exception e) {
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

    // overloaded version of "downloadFile" (use custom directory)
    public boolean downloadFile(String filename, HttpServletResponse response, String alternativeDirectory) throws IOException {
        try {
            Path filePath = Paths.get(alternativeDirectory + File.separator + filename);
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

    public Boolean GenerateAttestation(Demande demande) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("BackendSpring/src/main/resources/attestation.pdf"));
            
            Path EntrepriseLogoPath = Paths.get(uploadDirectory + File.separator +demande.getOffreDeStage().getEntreprise().getLogo());

            Image Logo = Image.getInstance(EntrepriseLogoPath.toAbsolutePath().toString());
            Logo.scaleAbsolute(250, 150);
            Logo.setAlignment(Element.ALIGN_RIGHT);

            document.open();
            // fonts
            Font Titlefont = FontFactory.getFont(FontFactory.TIMES_BOLD, 20, BaseColor.BLACK);
            Titlefont.setStyle(Titlefont.UNDERLINE);
            Font Paragraphfont = FontFactory.getFont(FontFactory.COURIER, 15, BaseColor.BLACK);
            Font ParagraphfontUnderlined = FontFactory.getFont(FontFactory.HELVETICA, 15, BaseColor.BLACK);
            ParagraphfontUnderlined.setStyle(ParagraphfontUnderlined.UNDERLINE | ParagraphfontUnderlined.ITALIC);
            Font Keywordfont = FontFactory.getFont(FontFactory.COURIER, 15, BaseColor.BLACK);
            Keywordfont.setStyle(Keywordfont.BOLDITALIC);
            // document elements
              // title
            Paragraph title = new Paragraph("Attestation de Stage", Titlefont);
            title.setAlignment(Element.ALIGN_CENTER);
              // paragraphs
            Paragraph Parag = new Paragraph(50, "Je Soussignée, gérant de l'entreprise ", Paragraphfont);
            Parag.setAlignment(Element.ALIGN_MIDDLE);
            Parag.setSpacingBefore(20);
            Chunk companyName = new Chunk(demande.getOffreDeStage().getEntreprise().getName(), Keywordfont);
            Chunk Parag2 = new Chunk(" certifie que :\n", Paragraphfont);
            Chunk EtudiantName = new Chunk(demande.getEtudiant().getFullname(), Keywordfont);
            Chunk Parag3 = new Chunk(" etudiant en ", Paragraphfont);
            Chunk EtudiantDomain = new Chunk(demande.getEtudiant().getDomaine(), Keywordfont);
            Chunk Parag4 = new Chunk(" a effectuée son stage ", Paragraphfont);
            Chunk EtudiantStage = new Chunk(demande.getEtudiant().getTypeStage(), Keywordfont);
            Chunk Parag5 = new Chunk(" au sein de mon entreprise pendant la periode de : ", Paragraphfont);
            Chunk DateDebut = new Chunk(this.FormatDate(demande.getOffreDeStage().getDateDebut().toString()) + " -> ", Paragraphfont);
            Chunk DateFin = new Chunk(this.FormatDate(demande.getOffreDeStage().getDateFin().toString()), Paragraphfont);
            Chunk Parag6 = new Chunk(".\nCette attestation est délivrée à l'intéressé(e) pour servir et valoir ce que de droit.\n", Paragraphfont);
            Chunk DateCreation_Cachet = new Chunk("Fait le : " + this.FormatDate(new Date().toString()) + ".\nSignature:\nCachet entreprise\n", ParagraphfontUnderlined);
            // append the elements to paragraph
            Parag.add(companyName);
            Parag.add(Parag2);
            Parag.add(EtudiantName);
            Parag.add(Parag3);
            Parag.add(EtudiantDomain);
            Parag.add(Parag4);
            Parag.add(EtudiantStage);
            Parag.add(Parag5);
            Parag.add(DateDebut);
            Parag.add(DateFin);
            Parag.add(Parag6);
            Parag.add(DateCreation_Cachet);
            // append paragraph to document
            document.add(title);
            document.add(Parag);
            document.add(Logo);
            // close document
            document.close();
            return true;
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
            return false;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String FormatDate(String date) {
        LocalDateTime oldDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy"));
        String outputDate = oldDate.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
        return outputDate;
    }
}
