package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        String[] englishWords = {"father", "mother", "son", "daughter",
                "older brother", "younger brother", "older sister", "younger sister",
                "grandmother", "grandfather"};
        String[] miwokWords = {"apa", "ata", "angsi", "tune", "taachi",
                "chalitti", "tete", "kolitti", "ama", "paapa"};
        ListView rootView = (ListView) findViewById(R.id.rootView);
        for (int i = 0; i < englishWords.length; i++) {
            words.add(new Word(englishWords[i], miwokWords[i]
                    , getResources().getIdentifier("family_" +
                            englishWords[i].replaceAll("\\s+", "_"),
                    "drawable", getPackageName()),
                    getResources().getIdentifier("family_"
                            + englishWords[i].replaceAll("\\s+",
                            "_"), "raw", getPackageName())));
            System.out.println("item" + i);
        }
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_family);
        rootView.setAdapter(itemsAdapter);
        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(),words.get(i).getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}