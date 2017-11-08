package me.pexcn.android.samples.rxjava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.pexcn.android.samples.R;
import me.pexcn.android.samples.base.BaseActivity;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
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

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        super.init(savedInstanceState);

        mTextView = (TextView) findViewById(R.id.tv_text);
        mButton = (Button) findViewById(R.id.btn_start);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setClickable(false);

                Observable.from(getResources().getStringArray(R.array.activity_titles_sub_rxjava))
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.newThread())
                        .map(new Func1<String, String>() {
                            @Override
                            public String call(String s) {
                                s = Thread.currentThread().getName() + " -->\n";
                                return s;
                            }
                        })
                        .observeOn(Schedulers.io())
                        .map(new Func1<String, String>() {
                            @Override
                            public String call(String s) {
                                s = s + Thread.currentThread().getName() + " -->\n";
                                return s;
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String s) {
                                s = s + Thread.currentThread().getName();
                                mTextView.setText(s);
                            }
                        });
            }
        });
    }
}
