package web.name.placeholder.controller;

import web.name.placeholder.models.Video;
import web.name.placeholder.service.VideoService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VideoController {
    private VideoService videoService;

    public VideoController(VideoService videoService){
        this.videoService = videoService;
    }

    @GetMapping("/videos")
    public ResponseEntity<Iterable<Video>> index(){
        return new ResponseEntity<>(videoService.index(), HttpStatus.OK);

    }

    @GetMapping("/videos/{videoid}")
    public @ResponseBody ResponseEntity<Video> show (@PathVariable Long videoID){
        return new ResponseEntity<>(videoService.show(videoID), HttpStatus.OK);
    }

    @PostMapping("/videos")
    public ResponseEntity<Video> create(@Valid @RequestBody Video video){
        return new ResponseEntity<>(videoService.create(video), HttpStatus.OK);
    }

    @PutMapping("/videos")
    public ResponseEntity<Video> update(Long videoId, @Valid @RequestBody Video video){
        return new ResponseEntity<>(videoService.update(videoId, video), HttpStatus.OK);
    }

    @DeleteMapping("/videos")
    public ResponseEntity<Boolean> delete(Long videoId){
        return new ResponseEntity<>(videoService.delete(videoId), HttpStatus.OK);
    }
}
