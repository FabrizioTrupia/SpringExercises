package co.develhope.fileUploaderAndDownloader.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(indexes = {
        @Index(unique = true , name = "email_idx" , columnList = "email")
})
@Entity
public class UtenteEntites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String profilePicture;



}
