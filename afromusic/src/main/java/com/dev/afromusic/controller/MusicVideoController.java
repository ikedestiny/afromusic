package com.dev.afromusic.controller;

import com.dev.afromusic.models.Artist;
import com.dev.afromusic.models.MusicVideo;
import com.dev.afromusic.models.UserEntity;
import com.dev.afromusic.security.SecurityUtil;
import com.dev.afromusic.service.ArtistService;
import com.dev.afromusic.service.MusicVideoService;
import com.dev.afromusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MusicVideoController {
    private MusicVideoService musicVideoService;
    private UserService userService;

    @Autowired
    public MusicVideoController(MusicVideoService musicVideoService, UserService userService) {
        this.musicVideoService = musicVideoService;
        this.userService = userService;
    }

    @GetMapping("/videos")
    public String getAllVideos(Model model){
        UserEntity user = new UserEntity();
        String username = SecurityUtil.getSessionUser();
        List<MusicVideo> videos = musicVideoService.findAllMusicVideos();
        if (username!=null){
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
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

    @GetMapping("/videos/search")
    public String searchVideos(@RequestParam(value = "query") String query, Model model){
        List<MusicVideo> videos = musicVideoService.searchMusicVideos(query);
        model.addAttribute("videos", videos);
        return "videos-list";
    }


}
