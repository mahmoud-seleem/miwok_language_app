package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words = new ArrayList<Word>();
        String[] englishWords = {"red", "green", "brown", "gray",
                "black", "white", "dusty yellow", "mustard yellow"};
        String[] miwokWords = {"weṭeṭṭi","chokokki","ṭakaakki","ṭopoppi","kululli" ,
                "kelelli","ṭopiisә","chiwiiṭә"};
        ListView rootView =  (ListView) findViewById(R.id.rootView);
        for (int i = 0;i<englishWords.length;i++){
            words.add(new Word(englishWords[i],miwokWords[i],
                    getResources().getIdentifier("color_"+
                                    englishWords[i].replaceAll("\\s+","_"),
                    "drawable", getPackageName()),
                    getResources().getIdentifier("color_"+
                                    englishWords[i].replaceAll("\\s+","_"),
                            "raw", getPackageName())));
            System.out.println("item"+i);
        }
        WordAdapter itemsAdapter = new WordAdapter(this, words,R.color.category_colors);
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