package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        String[] englishWords = {"one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine", "ten"};
        String[] miwokWords = {"lutti", "otiiko", "tolookosu", "oyyisa", "massokka",
                "temmokka", "kenkaku", "kawinta", "wo'e", "na'aacha"};
        ListView rootView = (ListView) findViewById(R.id.rootView);
        for (int i = 0; i < englishWords.length; i++) {
            words.add(new Word(englishWords[i], miwokWords[i]
                    , getResources().getIdentifier("number_" + englishWords[i],
                    "drawable", getPackageName())
                    , getResources().getIdentifier("number_" + englishWords[i],
                    "raw", getPackageName())));
            System.out.println("item" + i);
        }
        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
        rootView.setAdapter(itemsAdapter);
        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int audioResourceId = words.get(i).getAudioResourceId();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, audioResourceId);
                mediaPlayer.start();
            }
        });
//        for (String element :words){
//            TextView wordView = new TextView(this);
//            wordView.setText(element);
//            wordView.setTextSize(2,30);
//            rootView.addView(wordView);
//        }
    }
}