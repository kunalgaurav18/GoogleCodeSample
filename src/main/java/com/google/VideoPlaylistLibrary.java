package com.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class VideoPlaylistLibrary {

    private final HashMap<String, Set<Video>> videoPlaylist;

    public VideoPlaylistLibrary() {
        this.videoPlaylist = new HashMap<>();
    }

    public boolean addVideo(String playList, Video video) {
        String actualName = getKeyInEnteredCase(playList);
        boolean res = this.videoPlaylist.get(actualName).add(video);
        return res;
    }

    public boolean createPlaylist(String name) {
        String actualKey = this.getKeyInEnteredCase(name);
        if(actualKey.isEmpty()){
            this.videoPlaylist.put(name, new HashSet<>());
            return true;
        }
        else {
            return false;
        }
    }

    public String getKeyInEnteredCase(String playlistName) {
        Set<String> keys = this.videoPlaylist.keySet();
        return keys.stream().filter(playlistName::equalsIgnoreCase).collect(Collectors.joining());
    }


}
