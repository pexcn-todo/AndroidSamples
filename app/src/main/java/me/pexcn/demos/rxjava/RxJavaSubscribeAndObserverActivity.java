package me.pexcn.demos.rxjava;

import android.annotation.SuppressLint;
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

    @SuppressLint("SetTextI18n")
    @Override
    protected void init() {
        super.init();

        mTextView = (TextView) findViewById(R.id.tv_text);
        mButton = (Button) findViewById(R.id.btn_start);

        mButton.setOnClickListener(v -> {
            v.setClickable(false);

            Observable.from(getResources().getStringArray(R.array.activity_titles_sub_rxjava))
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.newThread())
                    .map(s -> {
                        s = Thread.currentThread().getName() + " -->\n";
                        return s;
                    })
                    .observeOn(Schedulers.io())
                    .map(s -> {
                        s = s + Thread.currentThread().getName() + " -->\n";
                        return s;
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        s = s + Thread.currentThread().getName();
                        mTextView.setText(s);
                    });
        });
    }
}
