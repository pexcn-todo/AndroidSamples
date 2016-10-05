package me.pexcn.demos.activity;

import android.util.Log;
import android.widget.TextView;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pexcn on 2016-10-04.
 */
public class RxJava1Activity extends BaseActivity {
    private static final String TAG = RxJava1Activity.class.getSimpleName();

    private TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rxjava1;
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }

    @Override
    protected void init() {
        super.init();
        mTextView = (TextView) findViewById(R.id.tv_text);
        StringBuilder sb = new StringBuilder();

        Observable.just("RxJava")
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.newThread())
                .map(s -> {
                    Log.d(TAG, sb.append("Current thread --> ").append(Thread.currentThread().getName()).append("\n").toString());
                    return s.length();
                })
                .observeOn(Schedulers.io())
                .map(integer -> {
                    Log.d(TAG, sb.append("Current thread --> ").append(Thread.currentThread().getName()).append("\n").toString());
                    return integer;
                })
                .map(s -> {
                    Log.d(TAG, sb.append("Current thread --> ").append(Thread.currentThread().getName()).append("\n").toString());
                    return s;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Log.d(TAG, sb.append("Current thread --> ").append(Thread.currentThread().getName()).append("\n").toString());
                    mTextView.setText(sb.toString());
                });
    }
}
