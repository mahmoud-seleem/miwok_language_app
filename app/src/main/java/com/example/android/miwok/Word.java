package com.example.android.miwok;

public class Word {
    private String english;
    private String miwok;
    private int imageResourceId;
    private int audioResourceId;

    public Word(String english, String miwok, int imageResourceId) {
        this(english, miwok, imageResourceId, 0);
    }

    public Word(String english, String miwok) {
        this(english, miwok, 0, 0);
    }

    public Word(String english, String miwok, int imageResourceId, int audioResourceId) {
        this.english = english;
        this.miwok = miwok;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;

    }

    public String getEnglishWord() {
        return english;
    }

    public String getMiwokWord() {
        return miwok;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }
}
