package com.example.cms.Repository;
import com.example.cms.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface CMSRepository extends JpaRepository<Correspondence, Long> {
    

    @Query("SELECT c FROM Correspondence c WHERE c.from.id = ?1")
    public List<Correspondence>  getSentMessages(long id);
    @Query("SELECT c FROM Correspondence c WHERE c.referance.id = ?1")
    public List<Correspondence>  getReceivedMessages(long id);
}
