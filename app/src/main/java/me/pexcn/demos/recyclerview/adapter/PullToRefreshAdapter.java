package me.pexcn.demos.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.pexcn.demos.R;
import me.pexcn.demos.recyclerview.viewholder.TextViewHolder;

/**
 * Created by pexcn on 2017-03-21.
 */
public class PullToRefreshAdapter extends RecyclerView.Adapter<TextViewHolder> {
    private ArrayList<String> mItems = new ArrayList<>();

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item_text, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void init() {
        for (int i = 0; i < 50; i++) {
            mItems.add("Item " + i);
        }
    }

    public void add(String text) {
        mItems.add(text);
        notifyItemInserted(mItems.size());
    }

    public void add(int index, String text) {
        mItems.add(index, text);
        notifyItemInserted(index);
    }
}
