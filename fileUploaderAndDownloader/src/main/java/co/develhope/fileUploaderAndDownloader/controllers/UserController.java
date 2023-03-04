package co.develhope.fileUploaderAndDownloader.controllers;

import co.develhope.fileUploaderAndDownloader.dto.DownloadProfilePicture;
import co.develhope.fileUploaderAndDownloader.entites.UtenteEntites;
import co.develhope.fileUploaderAndDownloader.repositories.UserRepository;
import co.develhope.fileUploaderAndDownloader.services.FileStorageService;
import co.develhope.fileUploaderAndDownloader.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UtenteEntites create(@RequestBody UtenteEntites utenteEntites){
        utenteEntites.setId(null);
       return userRepository.save(utenteEntites);
    }

    @PostMapping("/profile/{id}")
    public UtenteEntites uploadProfileImage(@PathVariable Long id , @RequestBody MultipartFile profilePicture) throws Exception {
        return userService.uploadProfilePicture(id , profilePicture);

    }

    @GetMapping("/read_all")
    public List<UtenteEntites> readAll(){
        return userRepository.findAll();
    }

    @GetMapping("/read_one/{id}")
    public Optional<UtenteEntites> readOne(@PathVariable Long id){
       return userRepository.findById(id);
    }

    @SneakyThrows
    @GetMapping("/profile/{id}")
    public @ResponseBody byte[] getProfileImage(@PathVariable Long id , HttpServletResponse response){
        DownloadProfilePicture downloadProfilePicture = userService.downloadProfilePicture(id);
        String fileName = downloadProfilePicture.getUtenteEntites().getProfilePicture();
        if (fileName == null) throw new Exception("User doesn t have a profile picture");
        String extension = FilenameUtils.getExtension(downloadProfilePicture.getUtenteEntites().getProfilePicture());
        switch (extension){
            case "gif" :
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case "jpg" :
            case "jpeg" :
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png" :
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition" , "attachment; filename= \"" + fileName + "\"");
        return downloadProfilePicture.getProfileImage();
    }

    @SneakyThrows
    @PutMapping("/update/{id}")
    public UtenteEntites update(@RequestBody UtenteEntites utenteEntites , @PathVariable Long id){
        utenteEntites.setId(id);
        return userRepository.save(utenteEntites);
    }


    @DeleteMapping("/delete_all")
    public void deleteAll(){

    }

    @SneakyThrows
    @DeleteMapping("/delete_one/{id}")
    public void deleteOne(@PathVariable Long userId){
         userService.remove(userId);
    }
}
