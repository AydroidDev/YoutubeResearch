package fr.esilv.s8.youtubesearch.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import fr.esilv.s8.youtubesearch.R;
import fr.esilv.s8.youtubesearch.models.Constants;
import fr.esilv.s8.youtubesearch.models.VideoResponse;

public class VideoScreen extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private static final int RECOVERY_REQUEST = 1;
    VideoResponse.ItemsBean itemm;
    YouTubePlayerView youTubeView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);
        Log.d("TEST", "*****************************OnCreate******************");
        itemm = (VideoResponse.ItemsBean) getIntent().getSerializableExtra("idVideo");

        Log.d("ResultIntentExtra",itemm.getSnippet().getChannelTitle());
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Constants.API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            //Corresponds to the ID of the video.
            Log.d("TEST", "*****************************Youtube******************");
            player.cueVideo(itemm.getId().getVideoId());
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }


}
