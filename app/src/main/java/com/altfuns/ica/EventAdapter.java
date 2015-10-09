package com.altfuns.ica;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.altfuns.ica.model.Event;

import java.util.List;

/**
 * Created by altfuns on 8/23/15.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private List<Event> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mDate;
        public TextView mTitle;
        public TextView mLocation;
        public TextView mSchedule;
        public TextView mRating;
        public LinearLayout mRatingContainer;
        public ImageView mImageView;

        public ViewHolder(View v, TextView title, TextView date, TextView location, TextView schedule, TextView rating, LinearLayout ratingContainer, ImageView image) {
            super(v);
            mTitle = title;
            mDate = date;
            mLocation = location;
            mSchedule = schedule;
            mRating = rating;
            mRatingContainer = ratingContainer;
            mImageView = image;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public EventAdapter(List<Event> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        TextView title = (TextView) v.findViewById(R.id.title);
        TextView date = (TextView) v.findViewById(R.id.date);
        TextView location = (TextView) v.findViewById(R.id.location);
        TextView schedule = (TextView) v.findViewById(R.id.schedule);
        TextView rating = (TextView) v.findViewById(R.id.rating);
        LinearLayout ratingContainer = (LinearLayout) v.findViewById(R.id.rating_container);
        ImageView image = (ImageView) v.findViewById(R.id.image);

        ViewHolder vh = new ViewHolder(v, title, date, location, schedule, rating, ratingContainer,image);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Event event = mDataset.get(position);

        holder.mTitle.setText(event.getTitle());
        holder.mDate.setText(event.getDate());
        holder.mLocation.setText(event.getLocation());
        holder.mSchedule.setText(event.getSchedule());

        int imageId = Event.UNA;
        switch (event.getOrganization()){
            case Event.UNA:
                imageId = R.drawable.ic_isotipo_una;
                break;
            case Event.HEREDIA_SOSTENIBLE:
                imageId = R.drawable.ic_isotipo_herediasost;
                break;
            case Event.ICA:
                imageId = R.drawable.ic_icono_actividades;
                break;
        }

        if(TextUtils.isEmpty(event.getRating())){
            holder.mRatingContainer.setVisibility(View.GONE);
        }else{
            holder.mRatingContainer.setVisibility(View.VISIBLE);
            holder.mRating.setText(event.getRating());
        }

        holder.mImageView.setImageResource(imageId);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
