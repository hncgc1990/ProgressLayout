package com.nguyenhoanglam.progresslayout.defaultView;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nguyenhoanglam.progresslayout.IErrorView;
import com.nguyenhoanglam.progresslayout.R;

/**
 * 默认的错误视图
 */

public class DefaultErrorView implements IErrorView {

    ImageView errorStateImageView;
    TextView errorStateContentTextView;
    Button errorStateButton;
    LayoutInflater mInflater;

    RelativeLayout mRlEmpty;


    public DefaultErrorView(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    @Override
    public RelativeLayout init() {

        View view = mInflater.inflate(R.layout.layout_progress_error, null);
        mRlEmpty = (RelativeLayout) view.findViewById(R.id.rl_error);

        errorStateImageView = (ImageView) view.findViewById(R.id.iv_error);
        errorStateContentTextView = (TextView) view.findViewById(R.id.tv_error);
        errorStateButton = (Button) view.findViewById(R.id.btn_error);


        return mRlEmpty;
    }

    @Override
    public void setView(String errText, Drawable drawable, String btnText, View.OnClickListener listener) {
        if (drawable != null) {
            errorStateImageView.setImageDrawable(drawable);
            errorStateImageView.setVisibility(View.VISIBLE);
        } else {
            errorStateImageView.setVisibility(View.GONE);
        }
        errorStateContentTextView.setText(errText);
        errorStateButton.setText(btnText);
        errorStateButton.setOnClickListener(listener);
    }


}
