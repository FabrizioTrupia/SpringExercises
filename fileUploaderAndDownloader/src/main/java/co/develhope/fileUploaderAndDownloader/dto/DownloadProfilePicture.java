package co.develhope.fileUploaderAndDownloader.dto;

import co.develhope.fileUploaderAndDownloader.entites.UtenteEntites;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadProfilePicture {

    private UtenteEntites utenteEntites;
    private byte[] profileImage;

}
