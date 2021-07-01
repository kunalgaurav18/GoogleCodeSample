package com.google;

import java.util.*;
import java.util.stream.Collectors;

public class VideoPlayer {

    private final VideoLibrary videoLibrary;
    private final VideoPlaylistLibrary videoPlaylistLibrary;

    private Video playingVideo;

    // true = Playing and false = Paused
    private Boolean videoStatus = true;

    public VideoPlayer() {
        this.videoLibrary = new VideoLibrary();
        this.videoPlaylistLibrary = new VideoPlaylistLibrary();
    }

    public void numberOfVideos() {
        System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
    }

    public void showAllVideos() {

        System.out.println("Here's a list of all available videos:");
        List<Video> videos = videoLibrary.getVideos();
        videos = videos.stream().sorted(Comparator.comparing(Video::getTitle)).collect(Collectors.toList());
        videos.forEach(System.out::println);
    }

    public void playVideo(String videoId) {
        Video video = videoLibrary.getVideo(videoId);
        Optional<Video> optional = Optional.ofNullable(video);
        if (optional.isPresent()) {
            if (playingVideo != null) {
                stopVideo();
            }
            playingVideo = video;
            videoStatus = true;
            System.out.println("Playing video: " + video.getTitle());
        } else {
            System.out.println("Cannot play video: Video does not exist");
        }

    }

    public void stopVideo() {
        if (playingVideo == null) {
            System.out.println("Cannot stop video: No video is currently playing");
        } else {
            System.out.println("Stopping video: " + playingVideo.getTitle());
            playingVideo = null;
        }
    }

    public void playRandomVideo() {
        Random rand = new Random();
        Video video = videoLibrary.getVideos().get(rand.nextInt(videoLibrary.getVideos().size()));
        playVideo(video.getVideoId());
    }

    public void pauseVideo() {
        if (playingVideo == null) {
            System.out.println("Cannot pause video: No video is currently playing");
        } else {
            if (videoStatus) {
                System.out.println("Pausing video: " + playingVideo.getTitle());
                videoStatus = false;
            } else {
                System.out.println("Video already paused: " + playingVideo.getTitle());
            }
        }
    }

    public void continueVideo() {
        if (playingVideo == null) {
            System.out.println("Cannot continue video: No video is currently playing");
        } else {
            if (videoStatus) {
                System.out.println("Cannot continue video: Video is not paused");
            } else {
                System.out.println("Continuing video: " + playingVideo.getTitle());
                videoStatus = true;
            }
        }
    }

    public void showPlaying() {
        if (playingVideo == null) {
            System.out.println("No video is currently playing");
        } else {
            if (videoStatus) {
                System.out.println("Currently playing: " + playingVideo.toString());
            } else {
                System.out.println("Currently playing: " + playingVideo.toString() + " - PAUSED");
            }
        }
    }

    public void createPlaylist(String playlistName) {
        boolean created = this.videoPlaylistLibrary.createPlaylist(playlistName);
        if (created) {
            System.out.println("Successfully created new playlist: " + playlistName);
        } else {
            System.out.println("Cannot create playlist: A playlist with the same name already exists");
        }

    }

    public void addVideoToPlaylist(String playlistName, String videoId) {
        Video video = this.videoLibrary.getVideo(videoId);
        if(video == null) {
            System.out.println("Cannot add video to my_playlist: Video does not exist");
            return;
        }
        boolean added = this.videoPlaylistLibrary.addVideo(playlistName, video);
//        String actualName = this.videoPlaylistLibrary.getKeyInEnteredCase(playlistName);
        if (added) {
            System.out.println("Added video to " + playlistName + ": " + video.getTitle());
        } else {
            System.out.println("Cannot add video to " + playlistName + ": Video already added");
        }
    }

    public void showAllPlaylists() {
        System.out.println("showAllPlaylists needs implementation");
    }

    public void showPlaylist(String playlistName) {
        System.out.println("showPlaylist needs implementation");
    }

    public void removeFromPlaylist(String playlistName, String videoId) {
        System.out.println("removeFromPlaylist needs implementation");
    }

    public void clearPlaylist(String playlistName) {
        System.out.println("clearPlaylist needs implementation");
    }

    public void deletePlaylist(String playlistName) {
        System.out.println("deletePlaylist needs implementation");
    }

    public void searchVideos(String searchTerm) {
        System.out.println("searchVideos needs implementation");
    }

    public void searchVideosWithTag(String videoTag) {
        System.out.println("searchVideosWithTag needs implementation");
    }

    public void flagVideo(String videoId) {
        System.out.println("flagVideo needs implementation");
    }

    public void flagVideo(String videoId, String reason) {
        System.out.println("flagVideo needs implementation");
    }

    public void allowVideo(String videoId) {
        System.out.println("allowVideo needs implementation");
    }
}