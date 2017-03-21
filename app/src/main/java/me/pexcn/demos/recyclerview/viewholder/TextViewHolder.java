package me.pexcn.demos.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import me.pexcn.demos.R;

/**
 * Created by pexcn on 2017-03-21.
 */
@SuppressWarnings("WeakerAccess")
public class TextViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;

    public TextViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.text);
    }

    public void setText(CharSequence text) {
        mTextView.setText(text);
    }
}