package me.pexcn.demos.activities;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pexcn on 2016-10-04.
 */
public class RxJavaSubscribeAndObserverActivity extends BaseActivity {
    private static final String TAG = RxJavaSubscribeAndObserverActivity.class.getSimpleName();

    private TextView mTextView;
    @SuppressWarnings("FieldCanBeLocal")
    private Button mButton;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava_subscribe_and_observer;
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    @Override
    protected void init() {
        super.init();

        mTextView = (TextView) findViewById(R.id.tv_text);
        mButton = (Button) findViewById(R.id.btn_start);

        mButton.setOnClickListener(v -> {
            v.setClickable(false);
            StringBuilder sb = new StringBuilder();
            Observable.just("RxJava")
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(Schedulers.newThread())
                    .map(s -> {
                        Log.d(TAG, sb.append("当前线程 --> ").append(Thread.currentThread().getName()).append("\n").toString());
                        return s.length();
                    })
                    .observeOn(Schedulers.io())
                    .map(integer -> {
                        Log.d(TAG, sb.append("当前线程 --> ").append(Thread.currentThread().getName()).append("\n").toString());
                        return integer;
                    })
                    .map(s -> {
                        Log.d(TAG, sb.append("当前线程 --> ").append(Thread.currentThread().getName()).append("\n").toString());
                        return s;
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        Log.d(TAG, sb.append("当前线程 --> ").append(Thread.currentThread().getName()).append("\n").toString());
                        mTextView.setText(sb.toString());
                    });
        });
    }
}
