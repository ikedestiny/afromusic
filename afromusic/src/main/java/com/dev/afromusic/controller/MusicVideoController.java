package com.dev.afromusic.controller;

import com.dev.afromusic.models.MusicVideo;
import com.dev.afromusic.service.MusicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MusicVideoController {
    private MusicVideoService musicVideoService;

    @Autowired
    public MusicVideoController(MusicVideoService musicVideoService) {
        this.musicVideoService = musicVideoService;
    }

    @GetMapping("/videos")
    public String getAllVideos(Model model){
        List<MusicVideo> videos = musicVideoService.findAllMusicVideos();
        model.addAttribute("videos", videos);
        return "videos-list";
    }

    @GetMapping("videos/{artistId}/new")
    public String createMusicVideoForm(@PathVariable("artistId") long artistId, Model model){
        MusicVideo musicVideo = new MusicVideo();
        model.addAttribute("artistId",artistId);
        model.addAttribute("musicVideo", musicVideo);
        return "videos-create";
    }

    @PostMapping("videos/{artistId}")
    public  String createMusicVideo(@PathVariable("artistId")Long artistId, @ModelAttribute("musicVideo")MusicVideo musicVideo, Model model){
        musicVideoService.createVideo(artistId,musicVideo);
        return "redirect:/artists/"+artistId;
    }


    @GetMapping("videos/{videoId}/delete")
    public String deleteVideo(@PathVariable("videoId") Long videoId){
            musicVideoService.deleteVideo(videoId);
            return "redirect:/artists";
    }
}
