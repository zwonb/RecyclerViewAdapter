package com.yidont.recyclerviewadapter.base;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * RecyclerView ViewHolder 的超类
 * Created by zwonb on 2018/1/19.
 */

public abstract class SuperViewHolder<E> extends RecyclerView.ViewHolder {

    private SparseArray<View> mSparseArray;

    public SuperViewHolder(ViewGroup parent, @LayoutRes int itemLayout) {
        super(LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false));
        if (mSparseArray == null) {
            mSparseArray = new SparseArray<>();
        }
    }

    /**
     * 查找 itemView 的id
     * {@link #itemView}
     */
    @SuppressWarnings("unchecked cast")
    protected <V extends View> V getView(@IdRes int id) {
        View view = mSparseArray.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mSparseArray.put(id, view);
        }
        return (V) view;
    }

    /**
     * 设置 textView 的数据
     */
    protected SuperViewHolder<E> setText(@IdRes int id, CharSequence text) {
        ((TextView) getView(id)).setText(text);
        return this;
    }

    /**
     * 设置 ImageView 的图片
     */
    protected SuperViewHolder<E> setImageResource(@IdRes int id, @DrawableRes int resId) {
        ((ImageView) getView(id)).setImageResource(resId);
        return this;
    }

    protected abstract void setDate(E bean);

}
