package com.example.songr.Controller;

import com.example.songr.Models.Album;
import com.example.songr.Models.Song;
import com.example.songr.Repository.AlbumRepository;
import com.example.songr.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String album(Model model) {
//        Album egyptRomance = new Album("egyptRomance", "Mohamed Hamaki", "58 songs", "3 hr 44 min", "https://i.scdn.co/image/ab67706f000000039e65e57c167ef4f9487b9093");
//        Album newMusicFridayLevent = new Album("new Music Friday Levent", "Issam Alnajjar", "54 songs", "2 hr 54 min", "https://i.scdn.co/image/ab67706f00000003d786c0f5809930e8196cc439");
//        Album lastTrainHome = new Album("last Train Home", "John Mayer", "4 songs", "14 min 10 sec", "https://i.scdn.co/image/ab67616d00001e026881d7f9d8555a9c8796e167");
//        Album[] albums = {egyptRomance, newMusicFridayLevent, lastTrainHome};
        List<Album> albums= albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "album";
    }

    @PostMapping("/albums")
    public RedirectView postAlbum(String title, String artist, String songCount, String length, String imageUrl) {
        Album albums = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(albums);
        return new RedirectView("/albums");
    }

    @GetMapping("song/{id}")
    public String song(@PathVariable Long id ,Model model) {
        List<Song> songs = songRepository.findAll();
        System.out.println(id);
        model.addAttribute("songs", songs);
        model.addAttribute("id", id);
        return "Song";
    }


    @PostMapping("/addSong")
    public RedirectView addNewSong(String title , int length,int trackNumber , String id){
        System.out.println(title+""+length+""+trackNumber+""+id);
        Long albumId= Long.parseLong(id);
        List<Album> songAlbum = albumRepository.findAllById(Collections.singleton(albumId));
        Song song = new Song(title,length,trackNumber,songAlbum.get(0));
        songRepository.save(song);
        return new RedirectView("/song/"+albumId);
    }
}
