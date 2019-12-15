package web.name.placeholder.service;

import web.name.placeholder.models.Comment;
import web.name.placeholder.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CommentService {
    private CommentRepository repository;
    private Long commentId;

    @Autowired
    public CommentService(CommentRepository repository, Long commentId){
        this.repository = repository;
    }
    public Iterable<Comment> showAll() {
        return repository.findAll();
    }

    // posting a new comment
    public Comment postComment (Comment comment){
        return repository.save(comment);
    }

    // getting a single comment by single user
    public Comment getUserComment(Long userId){
        return repository.findOne(userId);
    }

    // getting all comments by a single user
    public Comment getAllUserComments(Long userId){
        //return (Comment) repository.findAll();
        return repository.findAllByUserId(userId);
    }
    // getting comments on a single video
    public Comment getVideoComments(Long videoId){
        return repository.findOne(videoId);
    }

    //deleting a comment
    public Boolean deleteComment(Long commentId){
        repository.delete(commentId);
        return true;
    }

}


