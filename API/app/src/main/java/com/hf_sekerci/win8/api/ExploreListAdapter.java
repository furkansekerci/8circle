package com.hf_sekerci.win8.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.hf_sekerci.win8.api.Model.BeenHere;
import com.hf_sekerci.win8.api.Model.Item;
import com.hf_sekerci.win8.api.Model.Item_;
import com.hf_sekerci.win8.api.Model.Model;
import com.hf_sekerci.win8.api.Model.Venue;

import java.util.List;

import static android.graphics.Color.BLACK;

/**
 * Created by WIN8 on 3.8.2017.
 */

public class ExploreListAdapter extends ArrayAdapter<Venue> {
    private LayoutInflater layoutInflater_;


    private static class ViewHolder {
        TextView tvName;
        TextView tvPoint;
        TextView tvGenre;
        TextView tvDistance;
        TextView tvComment;
        TextView tcLoc;
    }

    public ExploreListAdapter(Context context, int layout,List<Venue> objects ) {
        super(context,layout, objects);
        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // GET DATA ITEM
        Venue item_ = getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list, parent, false);

            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_item_name);
            viewHolder.tvPoint = (TextView) convertView.findViewById(R.id.tv_list_point);
            viewHolder.tvGenre = (TextView) convertView.findViewById(R.id.tv_item_genre);
            viewHolder.tvDistance = (TextView) convertView.findViewById(R.id.tv_item_distance);
            viewHolder.tvComment = (TextView) convertView.findViewById(R.id.tv_item_comment);


            viewHolder.tvName.setTextColor(BLACK);
            viewHolder.tvPoint.setTextColor(BLACK);
            viewHolder.tvGenre.setTextColor(BLACK);
            viewHolder.tvDistance.setTextColor(BLACK);
            viewHolder.tvComment.setTextColor(BLACK);
            convertView.setTag(viewHolder);

        } else {
            //view is being recycle
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // get each data

        String name = item_.getName();
        int point = item_.getStats().getCheckinsCount();
        String genre = item_.getCategories().get(0).getName();
        int distance = item_.getLocation().getDistance();
        String comment = item_.getLocation().getAddress();


        viewHolder.tvName.setText(name);
        viewHolder.tvPoint.setText(String.valueOf("Check-in : " +point));
        viewHolder.tvGenre.setText(genre);
        viewHolder.tvDistance.setText(String.valueOf(distance + " metre uzaklıkta"));
        viewHolder.tvComment.setText(comment);


        return convertView;
    }
}
