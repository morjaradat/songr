package com.example.songr.Controller;

import com.example.songr.Models.Album;
import com.example.songr.Models.Song;
import com.example.songr.Repository.AlbumRepository;
import com.example.songr.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Album> albums= albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "album";
    }

    @PostMapping("/albums")
    public RedirectView createAlbum(String title, String artist, int songCount, int length, String imageUrl) {
        albumRepository.save(new Album(title, artist, songCount, length, imageUrl));
        return new RedirectView("/albums");
    }

    @GetMapping("allsong")
    public String getAllSong(Model model){
        List<Song> songs = songRepository.findAll();
        model.addAttribute("allsong",songs);
        return "allsong";
    }

    @GetMapping("song/{id}")
    public String song(@PathVariable Long id ,Model model) {

        List<Song> songs = albumRepository.findAlbumById(id).getSong();
//        System.out.println("-----------------------");
//        System.out.println("Again in song");
//        System.out.println(songs.toString());
//        System.out.println("-----------------------");
        model.addAttribute("songList", songs);
        model.addAttribute("id", id);
        return "song";
    }


    @PostMapping("/addSong")
    public RedirectView addNewSong(String title , int length, int trackNumber , Long id){
//        System.out.println("-----------------------");
//        System.out.println(title+""+length+""+trackNumber+""+id);
//        System.out.println("-----------------------");
        Album album = albumRepository.findAlbumById(id);
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);

        return new RedirectView("/song/"+id);
    }
}
