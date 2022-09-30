package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        String[] englishWords = {"Where are you going", "What is your name",
                "My name is", "How are you feeling", "I'm feeling good",
                "Are you coming", "Yes I'm coming", "I'm coming"
                , "Let's go", "Come here"};
        String[] miwokWords = {"minto wuksus", "tinnә oyaase'nә", "oyaaset..."
                , "michәksәs?", "kuchi achit", "әәnәs'aa?",
                "hәә’ әәnәm", "әәnәm", "yoowutis", "әnni'nem"};
        ListView rootView = (ListView) findViewById(R.id.rootView);
        for (int i = 0; i < englishWords.length; i++) {
            String resourceName = "phrase_" + englishWords[i].replaceAll
                    ("\\s+", "_").
                    replaceAll("'", "").toLowerCase();

            words.add(new Word(englishWords[i], miwokWords[i]
                    , 0,getResources().getIdentifier(resourceName, "raw", getPackageName()) ));
          System.out.println(resourceName);
        }
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_phrases);
        rootView.setAdapter(itemsAdapter);
        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), words.get(i).getAudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}