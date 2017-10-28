package com.hart.team.battleship;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.AmazonPollyPresigningClient;
import com.amazonaws.services.polly.model.DescribeVoicesRequest;
import com.amazonaws.services.polly.model.DescribeVoicesResult;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechPresignRequest;
import com.amazonaws.services.polly.model.Voice;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

public class AmazonPolly extends Activity {

    private static final String TAG = "Polly";
    private static final Regions MY_REGION = Regions.US_EAST_2;
    CognitoCachingCredentialsProvider credentialsProvider;

    private AmazonPollyPresigningClient client;
    private static final String COGNITO_POOL_ID = "CHANGEME";
    MediaPlayer mediaPlayer;

    public void AmazonPolly() {

        initPollyClient();
    }

    void initPollyClient() {
        // Initialize the Amazon Cognito credentials provider.
        credentialsProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                COGNITO_POOL_ID,
                MY_REGION
        );

        // Create a client that supports generation of presigned URLs.
        client = new AmazonPollyPresigningClient(credentialsProvider);
    }

    public void ReadText(String text) {



        SynthesizeSpeechPresignRequest synthesizeSpeechPresignRequest =
                new SynthesizeSpeechPresignRequest()
                        // Set text to synthesize.
                        .withText(text)
                        // Set voice selected by the user.
                        .withVoiceId("Joanna")
                        // Set format to MP3.
                        .withOutputFormat(OutputFormat.Mp3);

        // Get the presigned URL for synthesized speech audio stream.
        URL presignedSynthesizeSpeechUrl = client.getPresignedSynthesizeSpeechUrl(synthesizeSpeechPresignRequest);

        // Create a media player to play the synthesized audio stream.
        if (mediaPlayer.isPlaying()) {
            setupNewMediaPlayer();
        }
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


        try {
            // Set media player's data source to previously obtained URL.
            mediaPlayer.setDataSource(presignedSynthesizeSpeechUrl.toString());
        } catch (IOException e) {
            Log.e(TAG, "Unable to set data source for the media player! " + e.getMessage());
        }

        // Start the playback asynchronously (since the data source is a network stream).
        mediaPlayer.prepareAsync();
    }


    void setupNewMediaPlayer() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                setupNewMediaPlayer();
            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {


                return false;
            }
        });
    }
}
