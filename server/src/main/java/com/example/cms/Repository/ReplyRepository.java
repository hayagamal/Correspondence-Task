package com.example.cms.Repository;


import com.example.cms.Entity.Reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
    @Query("SELECT r FROM Reply r WHERE r.correspondence.id = ?1")
   public List<Reply>findByCorrespondenceId(long id);
}
