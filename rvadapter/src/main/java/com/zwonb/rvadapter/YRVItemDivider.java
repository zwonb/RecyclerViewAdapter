package com.zwonb.rvadapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * RV分割线
 * Created by zwonb on 2017/12/15.
 */

public class YRVItemDivider extends RecyclerView.ItemDecoration {

    private final Context mContext;
    private int mLeftOffset = 0;
    private int mRightOffset = 0;
    private int mDividerHeight;
    private Paint mPaint;

    /**
     * @param offset offset[0]左 offset[1]右 两边的偏移 单位dp
     *               如果两边相等可以直接传一个
     */
    public YRVItemDivider(Context context, float... offset) {
        mContext = context;
        mDividerHeight = (int) getDP(context, (float) 0.4);
        if (offset != null && offset.length > 0) {
            mLeftOffset = (int) getDP(context, offset[0]);
            if (offset.length < 2) {
                mRightOffset = mLeftOffset;
            } else {
                mRightOffset = (int) getDP(context, offset[1]);
            }
        }
        mPaint = new Paint();
        mPaint.setColor(0xFFCCCCCC);
        mPaint.setAntiAlias(true);
    }

    /**
     * @param dividerHeight 单位dp
     */
    public void setDividerHeight(@FloatRange(from = 0) float dividerHeight) {
        mDividerHeight = (int) getDP(mContext, dividerHeight);
    }

    public void setDividerColor(@ColorInt int color) {
        mPaint.setColor(color);
    }

    /**
     * 给出分割线的空隙
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position != 0) {
//            第一个不需要分割线
            outRect.top = mDividerHeight;
        }
    }

    /**
     * 着色
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft() + mLeftOffset;
        int right = parent.getWidth() - parent.getPaddingRight() - mRightOffset;
//        从1开始
        for (int i = 1; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            int bottom = childView.getTop();
            int top = bottom + parent.getTop() - mDividerHeight;
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }

    public static float getDP(Context context, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
