package shop.storage;
import  org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Patch;

public interface StorageService {
    void init();
    Resource loasAsResource(String fileName);
    String save(String base64);
    String saveMultipartFile(MultipartFile file);
    void removeFile(String name);
    Patch load(String filename);
}
