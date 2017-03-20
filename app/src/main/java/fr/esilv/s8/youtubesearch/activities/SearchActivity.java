package fr.esilv.s8.youtubesearch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fr.esilv.s8.youtubesearch.adapters.VideoAdapter;
import fr.esilv.s8.youtubesearch.models.Video;

import fr.esilv.s8.youtubesearch.R;

public class SearchActivity extends AppCompatActivity {
    private ListView listView;

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

    private List<Video> createDummyVideoList() {
        List<Video> videoList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Video video = new Video("Video Test");
            videoList.add(video);
        }
        return videoList;
    }
}
