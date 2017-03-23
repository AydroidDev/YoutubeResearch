package fr.esilv.s8.youtubesearch.activities;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

import fr.esilv.s8.youtubesearch.adapters.VideoAdapter;
import fr.esilv.s8.youtubesearch.models.Constants;
import fr.esilv.s8.youtubesearch.models.VideoResponse;
import fr.esilv.s8.youtubesearch.R;


public class SearchActivity extends AppCompatActivity  {
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

        //Query default research.

        getVideos("");

        buttonResearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getVideos(search.getText().toString());
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(SearchActivity.this, VideoScreen.class);
                intent.putExtra("idVideo",  (VideoResponse.ItemsBean)listView.getItemAtPosition(position));

                VideoResponse.ItemsBean itemm = (VideoResponse.ItemsBean) listView.getItemAtPosition(position);
                Log.d("ITEM",itemm.getSnippet().getTitle());

                startActivity(intent);

            }
        });

    }


    /**
     * This method takes as input the string written in the TextView.
     * If the text is an empty String, the default query is to find last french videos published.
     * Then the request is done in the Youtube API.
     * Then we get the Json result and parse it to our object VideoResponse which corresponds exactly to the json
     *
     * @param queryString The string typed in Research TextView
     */
    private void getVideos(String queryString) {
        String stringReadyForQuery = TransformStringQuery(queryString);
        String query = "";
        Log.d("Queried URL", Constants.VIDEOS_URL + "&q=" + stringReadyForQuery + "&maxResults=" + Constants.NUMBER_OF_VIDEOS_RETURNED + "&type=video&key=" + Constants.API_KEY);


        //Default query is a empty char.

        if (queryString == "")
            query = Constants.VIDEOS_URL + "&order=date&relevanceLanguage=fr&key=" + Constants.API_KEY;
        else
            query = Constants.VIDEOS_URL + "&q=" + stringReadyForQuery + "&maxResults=" + Constants.NUMBER_OF_VIDEOS_RETURNED + "&key=" + Constants.API_KEY;

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

    /**
     * The purpose of this query is to adapt the string research to the URL for the API.
     * Indeed, we must replace the space by | and the ' by %7C.
     *
     * @param queryString Exactly what the user of the app typed in the TextVIew
     * @return the URL adapted String
     */
    private String TransformStringQuery(String queryString) {
        queryString = queryString.replace(' ', '|');
        queryString = queryString.replace("\'", "%7C");
        return queryString;
    }

    /**
     * We use this method to adapt our VideoREsponse object to and ArrayAdapter
     *
     * @param videoResponse This is the VideoReponse object we want to adapt to ArrayAdapter
     */
    private void setAdapter(VideoResponse videoResponse) {
        VideoAdapter videoAdapter = new VideoAdapter(this, listVideos);
        listView.setAdapter(videoAdapter);
    }

}
