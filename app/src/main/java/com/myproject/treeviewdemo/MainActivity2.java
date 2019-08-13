package com.myproject.treeviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myproject.treeviewdemo.vp.GalleryLayoutManager;
import com.myproject.treeviewdemo.vp.ImageCardAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mPagerRecycleView;
    private List<ImageCardAdapter.CardItem> mCardItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCardItems = new ArrayList();
        for(int i=0; i<10; i++) {
            ImageCardAdapter.CardItem d = new ImageCardAdapter.CardItem(R.drawable.node_view_bg, "item"+i);
            mCardItems.add(d);
        }
        setContentView(R.layout.activity_main2);
        mPagerRecycleView = findViewById(R.id.mPagerRecycleView);
        final GalleryLayoutManager layoutManager = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        layoutManager.attach(mPagerRecycleView, 0);
        layoutManager.setOnItemSelectedListener(new GalleryLayoutManager.OnItemSelectedListener() {
            @Override
            public void onItemSelected(RecyclerView recyclerView, View item, int position) {
                /*Bitmap bmp = BitmapUtils.decodeSampledBitmapFromResource(getResources(), mResId.get(position % mResId.size()), 100, 100);
                mPagerBg.setImageBitmap(FastBlur.doBlur(bmp, 20, false));*/
            }
        });
        layoutManager.setItemTransformer(new ScaleTransformer());
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        final ImageCardAdapter imageAdapter = new ImageCardAdapter(mCardItems, (int) (displayMetrics.widthPixels * 0.7f), (int) (displayMetrics.heightPixels * 0.8f));
        imageAdapter.setOnItemClickListener(new ImageCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(MainActivity2.this, "click" + mCardItems.get(position).mName, Toast.LENGTH_SHORT).show();
                //mPagerRecycleView.smoothScrollToPosition(position);

                mCardItems.remove(layoutManager.getCurSelectedPosition());
                imageAdapter.notifyItemRemoved(layoutManager.getCurSelectedPosition());

            }
        });
        mPagerRecycleView.setAdapter(imageAdapter);
    }

    public class ScaleTransformer implements GalleryLayoutManager.ItemTransformer {

        private static final String TAG = "CurveTransformer";


        @Override
        public void transformItem(GalleryLayoutManager layoutManager, View item, float fraction) {
            //item.setScaleX((1-Math.abs(fraction))*0.2f+0.8f);
            item.setScaleY((1-Math.abs(fraction))*0.2f+0.8f);
            Log.i("tagg", fraction+" ");
        }
    }
}
