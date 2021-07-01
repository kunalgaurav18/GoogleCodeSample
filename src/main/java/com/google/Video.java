package com.google;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/** A class used to represent a video. */
class Video {

  private final String title;
  private final String videoId;
  private final List<String> tags;

  Video(String title, String videoId, List<String> tags) {
    this.title = title;
    this.videoId = videoId;
    this.tags = Collections.unmodifiableList(tags);
  }

  /** Returns the title of the video. */
  String getTitle() {
    return title;
  }

  /** Returns the video id of the video. */
  String getVideoId() {
    return videoId;
  }

  /** Returns a readonly collection of the tags of the video. */
  List<String> getTags() {
    return tags;
  }

  @Override
  public String toString() {
    return this.getTitle() + " (" + this.getVideoId() + ") [" +
            this.getTags().stream().map(Object::toString).collect(Collectors.joining(" ")) + "]";
  }
}
