package shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.dto.category.CategoryItemDTO;
import shop.dto.UploadImageDto;
import shop.storage.StorageService;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class HomeController {
    private final StorageService storageService;
    private static List<CategoryItemDTO> list = new ArrayList<>();

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serverFile(@PathVariable String filename) throws Exception {
        Resource file = storageService.loadAsResource(filename);
        String urlFileName = URLEncoder.encode("Сало.jpg", StandardCharsets.UTF_8.toString());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + urlFileName + "\"")
                .body(file);
    }
    @GetMapping("/")
    public String index() {
        return "Hello Java Spring Boot";
    }
    @PostMapping("/")
    public void add(@RequestBody CategoryItemDTO category) {
        list.add(category);
    }
    @PostMapping("/upload")
    public String upload(@RequestBody UploadImageDto dto) {
        String fileName = storageService.save(dto.getBase64());
        return fileName;
    }
    @PostMapping(value = "/form/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String formUpload(@RequestParam("file") MultipartFile file){
        String fileName=storageService.saveMultipartFile(file);
        return fileName;
    }
}
