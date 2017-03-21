package fr.esilv.s8.youtubesearch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import fr.esilv.s8.youtubesearch.adapters.VideoAdapter;
import fr.esilv.s8.youtubesearch.models.Constants;
import fr.esilv.s8.youtubesearch.models.VideoResponse;
import fr.esilv.s8.youtubesearch.R;


public class SearchActivity extends AppCompatActivity {
    private ListView listView;
    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;
    private VideoResponse responseAsObject;
    private List<VideoResponse.ItemsBean> listVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //Bind the XML ListView to the Java ListView
        listView = (ListView) findViewById(R.id.ListVideos);

        getVideos("Android");
        //fr.esilv.s8.youtubesearch.models.VideoResponse;
        //Populate the ListView with Dummy Content

    }

// Get Json Video datas
    private void getVideos(String queryString) {
        String stringReadyForQuery = TransformStringQuery(queryString);
        //Log.d("Test", "***********************TESSST**************");
        Log.d("TEST",Constants.VIDEOS_URL + "&q=" + stringReadyForQuery + "&type=video&key=" + Constants.API_KEY);

        StringRequest videosRequest = new StringRequest(Constants.VIDEOS_URL + "&q=" + stringReadyForQuery + "&key=" + Constants.API_KEY , new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                //parse data from webservice to get Videos as Java object
                responseAsObject = new Gson().fromJson(response, VideoResponse.class);
                listVideos = responseAsObject.getItems();
                setAdapter(responseAsObject);



            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Contracts", "Error");
            }
        });

        Volley.newRequestQueue(this).add(videosRequest);
    }


    private String TransformStringQuery(String queryString){
        String stringTransformed;
        stringTransformed = queryString.replace(' ','|');
        return stringTransformed;
    }

    private void setAdapter(VideoResponse videoResponse) {
        VideoAdapter videoAdapter = new VideoAdapter(this, listVideos);
        listView.setAdapter(videoAdapter);
    }


}
