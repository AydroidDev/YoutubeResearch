package fr.esilv.s8.youtubesearch.activities;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import fr.esilv.s8.youtubesearch.adapters.VideoAdapter;
import fr.esilv.s8.youtubesearch.models.Video;

import fr.esilv.s8.youtubesearch.R;
import fr.esilv.s8.youtubesearch.models.Videos;

public class SearchActivity extends AppCompatActivity {
    private ListView listView;
    private static final String VIDEOS_URL = "https://www.googleapis.com/youtube/v3/videos";
    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //Bind the XML ListView to the Java ListView
        listView = (ListView) findViewById(R.id.ListVideos);

        //Populate the ListView with Dummy Content
        List<Video> videos = createDummyVideoList();
        VideoAdapter videoAdapter = new VideoAdapter(this, videos);
        listView.setAdapter(videoAdapter);
    }

// Get Json Video datas
    private void getVideos() {
        StringRequest contractsRequest = new StringRequest(VIDEOS_URL + "?apiKey=" /* + SyncStateContract.Constants.API_KEY*/, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Videos as Java object
                Videos videos = new Gson().fromJson(response, Videos.class);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", "Error");
            }
        });

        Volley.newRequestQueue(this).add(contractsRequest);
    }


    private List<Video> createDummyVideoList() {
        List<Video> videoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Video video = new Video("Video Test", "channel Test", "url TEst");
            videoList.add(video);
        }
        return videoList;
    }
}
