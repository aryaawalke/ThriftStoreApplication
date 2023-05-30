package com.example.thriftstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CourseGVAdapterCart extends ArrayAdapter<CourseModelCart> {

    public CourseGVAdapterCart(@NonNull Context context, ArrayList<CourseModelCart> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;

        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.cart_card_layout, parent, false);
        }

        CourseModelCart courseModel = getItem(position);
        TextView courseTV1 = listitemView.findViewById(R.id.idTVCourse1);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);
        Button deleteBtn = listitemView.findViewById(R.id.delete_button);

        courseTV1.setText(courseModel.getCourse_price());
        courseTV.setText(courseModel.getCourse_name());
        courseIV.setImageResource(courseModel.getImgid());

        // Set listener for delete button
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event here
                remove(courseModel); // Remove item from adapter
            }
        });

        return listitemView;
    }
}
