package com.example.cms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.Entity.Reply;
import com.example.cms.Repository.ReplyRepository;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;


    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }


    public ReplyService() {
    }   

    public boolean addReply(Reply reply){
        replyRepository.save(reply);
        return true;
    }
    public List<Reply> findByCorrespondenceId(long id){
        return replyRepository.findByCorrespondenceId(id);
    }

}
