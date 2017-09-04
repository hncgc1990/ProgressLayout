package com.nguyenhoanglam.sample;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nguyenhoanglam.progresslayout.ProgressRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.progressLayout)
    ProgressRelativeLayout mProgressLayout;


    List<Integer> mIds;
    @BindView(R.id.btn_showLoading)
    Button btnShowLoading;
    @BindView(R.id.btn_showEmpty)
    Button btnShowEmpty;
    @BindView(R.id.btn_showError)
    Button btnShowError;
    @BindView(R.id.btn_showContent)
    Button btnShowContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        ButterKnife.bind(this);

        mIds = new ArrayList<>();
        mIds.add(R.id.toolbar);

        btnShowLoading.setOnClickListener(this);
        btnShowEmpty.setOnClickListener(this);
        btnShowError.setOnClickListener(this);
        btnShowContent.setOnClickListener(this);


//        loading();
    }


    private void loading() {
        mProgressLayout.showLoading(mIds);
        Observable.just(1)
                .delay(3, TimeUnit.SECONDS)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        if (integer == 1) throw new RuntimeException("空数据");
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String integer) {
                        mProgressLayout.showContent();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mProgressLayout.showEmpty(ContextCompat.getDrawable(RelativeLayoutActivity.this, R.drawable.ic_empty), "暂无数据", mIds);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showLoading:
                mProgressLayout.showLoading(mIds);
                break;
            case R.id.btn_showEmpty:
                mProgressLayout.showEmpty(ContextCompat.getDrawable(this, R.drawable.ic_empty), "暂无数据", mIds);
                break;
            case R.id.btn_showError:
                mProgressLayout.showError(ContextCompat.getDrawable(this, R.drawable.ic_no_connection), "网络错误", "重试", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(RelativeLayoutActivity.this, "点击重试", Toast.LENGTH_SHORT).show();
                    }
                }, mIds);
                break;
            case R.id.btn_showContent:

                mProgressLayout.showContent();
                break;
            default:
                break;
        }
    }
}
