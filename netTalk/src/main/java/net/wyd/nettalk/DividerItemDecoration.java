package net.wyd.nettalk;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v4.view.ViewCompat;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.util.Log;

/**
 * Created by wyd on 2016/9/28.
 */

class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATTRS = new int[] {
            android.R.attr.listDivider
    };
    private Drawable mDivider;
    private int mLeftOffsetDP;
    private Context mContext;

    DividerItemDecoration(Context context, int leftOffsetDP) {
        mContext = context;
        mLeftOffsetDP = leftOffsetDP;
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            final int left = parent.getPaddingLeft() + Math.round(mLeftOffsetDP * mContext.getResources().getDisplayMetrics().density);
            //Log.d(getClass().getSimpleName(), Integer.toString(left));
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin +
                    Math.round(child.getTranslationY());
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(parent.getChildAdapterPosition(view) == 0)
            return;
        outRect.bottom = mDivider.getIntrinsicHeight();
    }
}
