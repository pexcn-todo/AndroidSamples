package me.pexcn.demos.feature.adapter;

import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import me.pexcn.demos.R;

/**
 * Created by pexcn on 2017-03-30.
 */
public class GridView9PalaceGridAdapter extends BaseAdapter {
    private ArrayList<Uri> mUris;

    public GridView9PalaceGridAdapter(ArrayList<Uri> uris) {
        mUris = uris;
    }

    @Override
    public int getCount() {
        if (mUris == null) {
            return 1;
        }
        if (mUris.size() >= 9) {
            return mUris.size();
        }
        return mUris.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        if (mUris == null) {
            return null;
        }
        return mUris.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_9_palace_grid, parent, false);
            holder = new ViewHolder();
            holder.mImageView = (ImageView) convertView.findViewById(R.id.image);
            holder.mDelete = (ImageView) convertView.findViewById(R.id.delete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (mUris != null && position < mUris.size()) {
            holder.mImageView.setImageURI(mUris.get(position));
            if (holder.mImageView.getVisibility() != View.VISIBLE) {
                holder.mImageView.setVisibility(View.VISIBLE);
            }
            if (holder.mDelete.getVisibility() != View.VISIBLE) {
                holder.mDelete.setVisibility(View.VISIBLE);
            }
        } else {
            holder.mImageView.setImageDrawable(ContextCompat.getDrawable(parent.getContext(), R.drawable.ic_action_add_photo));
            if (holder.mImageView.getVisibility() != View.VISIBLE) {
                holder.mImageView.setVisibility(View.VISIBLE);
            }
            if (holder.mDelete.getVisibility() != View.GONE) {
                holder.mDelete.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    @SuppressWarnings("WeakerAccess")
    public static class ViewHolder {
        public ImageView mImageView;
        public ImageView mDelete;
    }

    public void add(Uri uri) {
        mUris.add(uri);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mUris.remove(position);
        notifyDataSetChanged();
    }
}
