package com.example.android_final_project;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWordGenerator {

    private List<String> wordList;
    private String randomWord;

    public RandomWordGenerator(Context context) {
        wordList = new ArrayList<>();
        loadWordsFromAsset(context);
    }

    private void loadWordsFromAsset(Context context) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open("hangmanWords.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                wordList.add(line);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(wordList.size());
        return wordList.get(index);
    }
}
