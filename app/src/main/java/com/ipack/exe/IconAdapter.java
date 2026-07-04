package com.ipack.exe;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private final Context context;
    private final String[] iconNames;

    public IconAdapter(Context context, String[] iconNames) {
        this.context = context;
        this.iconNames = iconNames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.icon_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = iconNames[position];
        Resources res = context.getResources();
        int resId = res.getIdentifier(name, "drawable", context.getPackageName());
        if (resId != 0) {
            holder.icon.setImageResource(resId);
        }
    }

    @Override
    public int getItemCount() {
        return iconNames.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        ViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon_image);
        }
    }
}