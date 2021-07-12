package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Locale;

@Controller
public class HelloWorld {

    @Autowired
    AlbumRepository albumsRepository;

    @GetMapping("/")
    public String helloWorld() {
        return "HomePage";
    }

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(name = "word", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("word", name);
        return "helloWorld";

    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model) {
        model.addAttribute("text", text.toUpperCase(Locale.ROOT));
        return "capitalize";
    }

    @GetMapping("/albums")
    public String album(Model model) {
//        Album egyptRomance = new Album("egyptRomance", "Mohamed Hamaki", "58 songs", "3 hr 44 min", "https://i.scdn.co/image/ab67706f000000039e65e57c167ef4f9487b9093");
//        Album newMusicFridayLevent = new Album("new Music Friday Levent", "Issam Alnajjar", "54 songs", "2 hr 54 min", "https://i.scdn.co/image/ab67706f00000003d786c0f5809930e8196cc439");
//        Album lastTrainHome = new Album("last Train Home", "John Mayer", "4 songs", "14 min 10 sec", "https://i.scdn.co/image/ab67616d00001e026881d7f9d8555a9c8796e167");
//        Album[] albums = {egyptRomance, newMusicFridayLevent, lastTrainHome};
        List<Album> albums= albumsRepository.findAll();
        model.addAttribute("albums", albums);
        return "album";
    }

    @PostMapping("/albums")
    public RedirectView postAlbum(String title, String artist, String songCount, String length, String imageUrl) {
        Album albums= new Album(title,artist,songCount,length,imageUrl);
        albumsRepository.save(albums);
        return new RedirectView("/albums");
    }

}
