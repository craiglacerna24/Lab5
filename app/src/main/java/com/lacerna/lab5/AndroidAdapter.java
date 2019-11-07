package com.lacerna.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AndroidAdapter  extends ArrayAdapter<Android> {
    Context mContext;
    int mResources;


    public AndroidAdapter(@NonNull Context context, int resource, @NonNull List<Android> objects) {
        super(context, resource, objects);

        mContext = context;
        mResources = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getLogo();
        String name = getItem(position).getName();
        String version = getItem(position).getVersion();
        String APILevel = getItem(position).getAPILevel();
        String date = getItem(position).getDate();
        String shortMessage = getItem(position).getShortMessage();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResources, parent, false);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvVersion = convertView.findViewById(R.id.tvVersion);
        TextView tvAPI = convertView.findViewById(R.id.tvAPI);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        ImageView ivLogo = convertView.findViewById(R.id.ivLogo);

        tvName.setText(name);
        tvVersion.setText(version);
        tvAPI.setText(APILevel);
        tvDate.setText(date);
        ivLogo.setImageResource(image);
        return convertView;
    }
}
