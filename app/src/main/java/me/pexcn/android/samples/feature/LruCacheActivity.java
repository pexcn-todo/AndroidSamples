package me.pexcn.android.samples.feature;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import me.pexcn.android.utils.io.LogUtils;
import me.pexcn.android.samples.R;
import me.pexcn.android.samples.BaseActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static me.pexcn.android.samples.R.id.json;

/**
 * Created by pexcn on 2017-04-01.
 */
@SuppressWarnings("WeakerAccess")
public class LruCacheActivity extends BaseActivity {
    private static final String JSON_URL = "http://news-at.zhihu.com/api/4/news/latest";
    private static final String BITMAP_URL = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";

    private LruCache<Integer, String> mJSONCache;
    private BitmapLruCache mBitmapCache;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feature_lru_cache;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int cacheSize = (int) (Runtime.getRuntime().maxMemory() / 1024 / 8);
        mJSONCache = new LruCache<>(cacheSize);
        mBitmapCache = new BitmapLruCache(cacheSize);
    }

    @Override
    protected void init() {
        super.init();

        TextView text = (TextView) findViewById(json);
        ImageView image = (ImageView) findViewById(R.id.image);

        final OkHttpClient client = new OkHttpClient();

        findViewById(R.id.load).setOnClickListener(v -> {
            if (mJSONCache.get(0x01) == null) {
                LogUtils.d("Network Request --> json");
                client.newCall(new Request.Builder().url(JSON_URL).build()).enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        LogUtils.d("Network Response --> " + json);
                        mJSONCache.put(0x01, json);
                        text.post(() -> {
                            text.setVisibility(View.VISIBLE);
                            text.setText(json);
                        });
                    }

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                });
            } else {
                LogUtils.d("Cached --> " + mJSONCache.get(0x01));
                text.setVisibility(View.VISIBLE);
                text.setText(mJSONCache.get(0x01));
            }

            if (mBitmapCache.get("bitmap") == null) {
                LogUtils.d("Network Request --> bitmap");
                client.newCall(new Request.Builder().url(BITMAP_URL).build()).enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        LogUtils.d("Network Response --> bitmap");
                        Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                        mBitmapCache.put("bitmap", bitmap);
                        image.post(() -> {
                            image.setVisibility(View.VISIBLE);
                            image.setImageBitmap(bitmap);
                        });
                    }

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                });
            } else {
                LogUtils.d("Cached --> bitmap");
                image.setVisibility(View.VISIBLE);
                image.setImageBitmap(mBitmapCache.get("bitmap"));
            }
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    public static class BitmapLruCache extends LruCache<String, Bitmap> {
        public BitmapLruCache(int maxSize) {
            super(maxSize);
        }

        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getByteCount() / 1024;
        }
    }
}
