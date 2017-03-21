package me.pexcn.demos.customview;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.pexcn.demos.R;
import me.pexcn.demos.base.BaseActivity;

/**
 * Created by pexcn on 2017-03-17.
 */
public class CoordinateSystemActivity extends BaseActivity {
    @SuppressWarnings("FieldCanBeLocal")
    private LinearLayout mLinearLayout;
    private TextView mGetX;
    private TextView mGetY;
    private TextView mGetRawX;
    private TextView mGetRawY;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_customview_coordinate_system;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void init() {
        super.init();

        mLinearLayout = (LinearLayout) findViewById(R.id.ll);
        mGetX = (TextView) findViewById(R.id.getX);
        mGetY = (TextView) findViewById(R.id.getY);
        mGetRawX = (TextView) findViewById(R.id.getRawX);
        mGetRawY = (TextView) findViewById(R.id.getRawY);

        mLinearLayout.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    mGetX.setText("getX() -> " + String.valueOf(event.getX()));
                    mGetY.setText("getY() -> " + String.valueOf(event.getY()));
                    mGetRawX.setText("getRawX() -> " + String.valueOf(event.getRawX()));
                    mGetRawY.setText("getRawY() -> " + String.valueOf(event.getRawY()));
                    break;
            }
            return true;
        });
    }

    @Override
    protected boolean isSubActivity() {
        return true;
    }
}
