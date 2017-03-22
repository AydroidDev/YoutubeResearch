package fr.esilv.s8.youtubesearch.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.List;

import fr.esilv.s8.youtubesearch.adapters.VideoAdapter;
import fr.esilv.s8.youtubesearch.models.Constants;
import fr.esilv.s8.youtubesearch.models.VideoResponse;
import fr.esilv.s8.youtubesearch.R;


public class SearchActivity extends AppCompatActivity {
    private ListView listView;
    private Button buttonResearch;
    private TextView search;
    private VideoResponse responseAsObject;
    private List<VideoResponse.ItemsBean> listVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        //Bind the XML ListView to the Java ListView
        listView = (ListView) findViewById(R.id.ListVideos);
        buttonResearch = (Button) findViewById(R.id.buttonResearch);
        search = (TextView) findViewById(R.id.textVideo);
        getVideos("");
        //fr.esilv.s8.youtubesearch.models.VideoResponse;
        //Populate the ListView with Dummy Content

        buttonResearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getVideos(search.getText().toString());
            }
        });

    }

// Get Json Video datas
    private void getVideos(String queryString) {
        String stringReadyForQuery = TransformStringQuery(queryString);
        //Log.d("Test", "***********************TESSST**************");
        String query="";
        Log.d("TEST",Constants.VIDEOS_URL + "&q=" + stringReadyForQuery + "&maxResults="+Constants.NUMBER_OF_VIDEOS_RETURNED+"&type=video&key=" + Constants.API_KEY);
        if(queryString == "")
            query = Constants.VIDEOS_URL + "&order=date&relevanceLanguage=fr&key=" + Constants.API_KEY;
        else
        query = Constants.VIDEOS_URL + "&q=" + stringReadyForQuery + "&maxResults="+Constants.NUMBER_OF_VIDEOS_RETURNED+ "&key=" + Constants.API_KEY;

        StringRequest videosRequest = new StringRequest(query, new Response.Listener<String>() {


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
