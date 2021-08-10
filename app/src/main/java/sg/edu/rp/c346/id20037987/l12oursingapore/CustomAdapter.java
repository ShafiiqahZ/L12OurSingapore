package sg.edu.rp.c346.id20037987.l12oursingapore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<OurSingapore> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<OurSingapore> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) //LINE 29-33 is the same for all files where it will read the file to find the textViewName etc
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvDesc = rowView.findViewById(R.id.textViewDesc);
        //TextView tvStar = rowView.findViewById(R.id.textViewStar);

        RatingBar rbStars = rowView.findViewById(R.id.ratingBar);

        TextView tvSize = rowView.findViewById(R.id.textViewSize);

        // Obtain the Android Version information based on the position
        OurSingapore currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentVersion.getName());
        tvSize.setText(String.valueOf(currentVersion.getSize()));

        //rbStars.getNumStars();
        rbStars.setRating(currentVersion.getStars());

        //rbStars.setText(String.valueOf(currentVersion.getStars()));
        //tvStar.setText(String.valueOf(currentVersion.toString()));
        tvDesc.setText(currentVersion.getDesc());

        /*if (currentVersion.getYearReleased() >= 2019 ) {
            ivNew.setImageResource(R.drawable.newimg);
            //ivNew.setVisibility(View.VISIBLE);
        } else {
            ivNew.setVisibility(View.INVISIBLE);
        }*/

        return rowView;
    }

}
