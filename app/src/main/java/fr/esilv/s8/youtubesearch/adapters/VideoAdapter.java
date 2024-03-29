package fr.esilv.s8.youtubesearch.adapters;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

import fr.esilv.s8.youtubesearch.R;
import fr.esilv.s8.youtubesearch.models.DownloadImageTask;
import fr.esilv.s8.youtubesearch.models.VideoResponse;

/**
 * Created by Salem on 20/03/2017.
 */

public class VideoAdapter extends ArrayAdapter<VideoResponse.ItemsBean> {

    private final LayoutInflater layoutInflater;


    public VideoAdapter(Context context, List<VideoResponse.ItemsBean> objects) {
        super(context, 0, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        //The convertView is null when the view is inflated for the first time
        if (convertView == null) {
            //In that case, we create the view and we hold the sub views in a ViewHolder for an easier, more efficient access
            convertView = layoutInflater.inflate(R.layout.viewholder_video, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.details = (TextView) convertView.findViewById(R.id.description);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageVideo);
            viewHolder.channelTitle = (TextView) convertView.findViewById(R.id.channelTitle);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Finally, we get the current item, and we set the View according to the data we wish to display
        VideoResponse.ItemsBean item = getItem(position);
        viewHolder.title.setText(item.getSnippet().getTitle());
        viewHolder.details.setText(item.getSnippet().getDescription());
        //viewHolder.imageView;
        viewHolder.channelTitle.setText(item.getSnippet().getChannelTitle());
        // show The Image in a ImageView
        new DownloadImageTask((ImageView) convertView.findViewById(R.id.imageVideo)) .execute(item.getSnippet().getThumbnails().getDefaultX().getUrl());

        //viewHolder.firstNameTextView.setText(student.getFirstName());
        return convertView;
    }



    static class ViewHolder {


        private TextView title;
        private TextView details;
        private ImageView imageView;
        private TextView channelTitle;




    }



}



