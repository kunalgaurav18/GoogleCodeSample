package com.google;

import java.util.Set;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private String name;
    private Set<Video> videos;

    public VideoPlaylist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }
}
