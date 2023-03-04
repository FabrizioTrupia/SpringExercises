package co.develhope.fileUploaderAndDownloader.repositories;

import co.develhope.fileUploaderAndDownloader.entites.UtenteEntites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UtenteEntites , Long> {


}
