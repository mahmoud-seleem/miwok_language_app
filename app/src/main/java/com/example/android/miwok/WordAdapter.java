package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private  int colorResourceId;
    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> objects,int colorResourceId) {
        super(context, 0, objects);
        this.colorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word currentWord = getItem(position);
        TextView englishTextView = listItemView.findViewById(R.id.english_word);
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_word);
        ImageView imageView = listItemView.findViewById(R.id.image);
        LinearLayout textLayout = listItemView.findViewById(R.id.text_layout);
        englishTextView.setText(currentWord.getEnglishWord());
        miwokTextView.setText(currentWord.getMiwokWord());
        imageView.setImageResource(currentWord.getImageResourceId());
        textLayout.setBackgroundResource(this.colorResourceId);
        return listItemView;
    }
}
