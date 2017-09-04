package com.nguyenhoanglam.progresslayout.defaultView;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nguyenhoanglam.progresslayout.IEmptyView;
import com.nguyenhoanglam.progresslayout.R;

/**
 * 默认的空数据布局
 */

public class DefaultEmptyView implements IEmptyView {


    LayoutInflater mInflater;

    RelativeLayout mRlEmpty;

    ImageView emptyStateImageView;
    TextView emptyStateContentTextView;

    public DefaultEmptyView(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    @Override
    public RelativeLayout init() {

        View view = mInflater.inflate(R.layout.layout_progress_empty, null);
        mRlEmpty = (RelativeLayout) view.findViewById(R.id.rl_empty);

        emptyStateImageView = (ImageView) view.findViewById(R.id.iv_empty);
        emptyStateContentTextView = (TextView) view.findViewById(R.id.tv_empty);






        return mRlEmpty;
    }

    @Override
    public void setView(String text, Drawable drawable, View.OnClickListener listener) {
        if (drawable != null) {
            emptyStateImageView.setImageDrawable(drawable);
            emptyStateImageView.setVisibility(View.VISIBLE);
        } else {
            emptyStateImageView.setVisibility(View.GONE);
        }
        emptyStateContentTextView.setText(text);
    }
}
