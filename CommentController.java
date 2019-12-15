package web.name.placeholder.controller;

import web.name.placeholder.models.Comment;
import web.name.placeholder.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> postComment(@Valid @RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.postComment(comment), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Comment> getUserComment(@PathVariable Long userId) {
        return new ResponseEntity<>(commentService.getUserComment(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Comment> getAllUserComment(@PathVariable Long userId) {
        return new ResponseEntity<>(commentService.getAllUserComments(userId), HttpStatus.OK);
    }

    @GetMapping("/{videoId}")
    public ResponseEntity<Comment> getVideoComments(@PathVariable Long videoId) {
        return new ResponseEntity<>(commentService.getVideoComments(videoId), HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.deleteComment(commentId), HttpStatus.OK);
    }

}