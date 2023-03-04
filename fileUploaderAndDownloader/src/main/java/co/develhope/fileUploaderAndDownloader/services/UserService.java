package co.develhope.fileUploaderAndDownloader.services;

import co.develhope.fileUploaderAndDownloader.dto.DownloadProfilePicture;
import co.develhope.fileUploaderAndDownloader.entites.UtenteEntites;
import co.develhope.fileUploaderAndDownloader.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  FileStorageService fileStorageService;

    @SneakyThrows
    private UtenteEntites getUser(Long userId){
        Optional<UtenteEntites> optionalUser =  userRepository.findById(userId);
        if(!optionalUser.isPresent()) throw new Exception("User is not present");
        return optionalUser.get();
    }

    @SneakyThrows
    public UtenteEntites uploadProfilePicture(Long userId, MultipartFile profilePicture) throws Exception {
        UtenteEntites utenteEntites = getUser(userId);
        if(utenteEntites.getProfilePicture() != null){
            fileStorageService.remove(utenteEntites.getProfilePicture());
        }
        String fileName =  fileStorageService.upload(profilePicture);
        utenteEntites.setProfilePicture(fileName);
        return userRepository.save(utenteEntites);
    }

    @SneakyThrows
    public DownloadProfilePicture downloadProfilePicture(Long userId) {
        UtenteEntites utenteEntites = getUser(userId); // prende l utente
        DownloadProfilePicture dto = new DownloadProfilePicture();
        dto.setUtenteEntites(utenteEntites);

        if (utenteEntites.getProfilePicture() == null) return dto;

        byte[] profilePictureByte = fileStorageService.download(utenteEntites.getProfilePicture());
        dto.setProfileImage(profilePictureByte);
        return dto;
    }

    @SneakyThrows
    public void remove(Long userId) {
        UtenteEntites utenteEntites = getUser(userId);
        if(utenteEntites.getProfilePicture() != null) {
            fileStorageService.remove(utenteEntites.getProfilePicture());
        }
        userRepository.deleteById(userId);
    }
}
