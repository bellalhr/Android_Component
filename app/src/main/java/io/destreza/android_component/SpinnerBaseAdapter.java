package io.destreza.android_component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerBaseAdapter extends BaseAdapter{
    Context context;
    int flags[];
    String[] countryNames;
    LayoutInflater inflter;

    public SpinnerBaseAdapter(Context context, int[] flags, String[] countryNames) {
        this.context = context;
        this.flags = flags;
        this.countryNames = countryNames;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.raw_spinner, null);
        ImageView im=view.findViewById(R.id.imageview);
        TextView textView=view.findViewById(R.id.textView);

        im.setImageResource(flags[i]);
        textView.setText(countryNames[i]);

        return view;
    }
}
