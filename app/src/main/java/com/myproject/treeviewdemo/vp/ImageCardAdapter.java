package com.myproject.treeviewdemo.vp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myproject.treeviewdemo.BuildConfig;
import com.myproject.treeviewdemo.R;

import java.util.List;


/**
 * Created by chensuilun on 2016/11/15.
 */
public class ImageCardAdapter extends RecyclerView.Adapter<ImageCardAdapter.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "ImageCardAdapter";
    private List<CardItem> items;
    private OnItemClickListener mOnItemClickListener;
    private int mWidth;
    private int mHeight;

    public ImageCardAdapter(List<CardItem> items, int width, int height) {
        this.items = items;
        mWidth = width;
        mHeight = height;
    }

    public ImageCardAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, "onCreateViewHolder: type:" + viewType);
        }
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycel_image, parent, false);
        v.setOnClickListener(this);
        v.setLayoutParams(new RecyclerView.LayoutParams(mWidth, mHeight));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onBindViewHolder: position:" + position);
        }
        CardItem item = items.get(position);
        holder.image.setText(item.mName);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(final View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    /**
     * @author chensuilun
     */
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (TextView) itemView.findViewById(R.id.text);
        }
    }

    /**
     * @author chensuilun
     */
    public interface OnItemClickListener {

        void onItemClick(View view, int position);

    }

    /**
     *
     */
    public static class CardItem {
        public int mResId;
        public String mName;

        public CardItem(int resId, String name) {
            mResId = resId;
            mName = name;
        }
    }
}