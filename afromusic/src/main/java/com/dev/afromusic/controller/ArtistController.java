package com.dev.afromusic.controller;

import com.dev.afromusic.models.Artist;
import com.dev.afromusic.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public String getAllArtists(Model model){
        List<Artist> artists = artistService.findAllArtists();
        model.addAttribute("artists", artists);
        return "artists-list";
    }

    @GetMapping("/artists/new")
    public String createNewArtist(Model model){
        Artist artist = new Artist();
        model.addAttribute(artist);
        return  "artists-create";
    }

    @PostMapping("artists/new")
    public String saveArtist(@ModelAttribute("artist") Artist artist, Model model){
        artistService.saveArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping("artists/{artistId}/edit")
    public String editArtistForm(@PathVariable("artistId") Long artistId, Model model){
        Artist artist = artistService.findArtistById(artistId);
        model.addAttribute("artist", artist);
        return "artists-edit";
    }


    @PostMapping("artists/{artistId}/edit")
    public String updateArtistProfile(@PathVariable("artistId") Long artistId, @ModelAttribute("artist") Artist artist, Model model){
        artist.setId(artistId);
        artistService.updateArtistProfile(artist);
        return "redirect:/artists";

    }


    @GetMapping("artists/{artistId}")
    public String viewArtist(@PathVariable("artistId") long artistId, Model model){
        Artist artist = artistService.findArtistById(artistId);
        model.addAttribute("artist",artist);
        return "artists-detail";
    }


    @GetMapping("/artists/{artistId}/delete")
    public String deleteArtist(@PathVariable("artistId") Long artistId){
        artistService.deleteArtist(artistId);
        return "redirect:/artists";
    }


    @GetMapping("/artists/search")
    public String searchForArtist(@RequestParam(value = "query") String query, Model model){
            List<Artist> artists = artistService.searchForArtist(query);
            model.addAttribute("artists",artists);
            return "artists-list";
    }


    @GetMapping("/contact")
    public String contactUs(Model model){
        return "contact";
    }

    @GetMapping("/home")
    public String homepage(Model model){
        return "home";
    }


}
