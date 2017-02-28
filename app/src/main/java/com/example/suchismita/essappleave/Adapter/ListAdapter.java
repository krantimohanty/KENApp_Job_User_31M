package com.example.suchismita.essappleave.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.suchismita.essappleave.Model.ApprovedLeaveModel;
import com.example.suchismita.essappleave.Model.ListModel;
import com.example.suchismita.essappleave.R;

import java.util.List;

/**
 * Created by suchismita on 2/23/2017.
 */

public class ListAdapter extends ArrayAdapter<ListModel> {
    private final Context context;

    public ListAdapter(Context context, int resourceId,
    List<ListModel> items) {
        super(context, resourceId, items);
        this.context = context;
    }
    private class ViewHolder {

        TextView date;
        TextView event;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ListModel listItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.event = (TextView) convertView.findViewById(R.id.event);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.date.setText(listItem.getDate());
        holder.event.setText(listItem.getEvent());


        return convertView;
    }
}

