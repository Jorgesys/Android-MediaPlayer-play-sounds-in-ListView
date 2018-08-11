package com.gruporeforma.mediaplayersounds;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer sound;
    ListView list;
    String[] web = {
            "Shout",
            "What?",
            "Chirp",
            "Camera shot",
            "Strange song",
            "Chirp"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, web);
        list = (ListView) findViewById(R.id.soundslist);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0)
                    playSound(R.raw.shout);
                else if (position == 1)
                    playSound(R.raw.what);
                else if (position == 2)
                    playSound(R.raw.littlesound);
                else if (position == 3)
                    playSound(R.raw.camerashoot);
                else if (position == 4)
                    playSound(R.raw.strangesound);
                else if (position == 5)
                    playSound(R.raw.jorgesys_sound);
            }
        });
    }

    protected void playSound (int x){
        int soundPlaying = 0;
        //MediaPlayer sound = MediaPlayer.create(this,x);
        if(x != soundPlaying && sound != null){ //Play a new sound
            sound.release();
            sound = null;
            sound = MediaPlayer.create(this,x);
        }else{ //Play sound
            sound = MediaPlayer.create(this,x);
        }

        if(sound != null && !sound.isPlaying()) {
            sound.start();
            //playing = 1;

        } else if(sound != null && sound.isPlaying()){
            sound.stop();
            // playing = 0;
        }

        soundPlaying = x;
    }
}