package me.pexcn.demos.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import me.pexcn.demos.R;

/**
 * Created by pexcn on 2017-03-21.
 */
@SuppressWarnings("WeakerAccess")
public class LoadingViewHolder extends RecyclerView.ViewHolder {
    public ProgressBar mProgressBar;

    public LoadingViewHolder(View itemView) {
        super(itemView);
        mProgressBar = (ProgressBar) itemView.findViewById(R.id.progress);
    }

    public void setLoading(boolean isLoading) {
        mProgressBar.setIndeterminate(isLoading);
    }
}