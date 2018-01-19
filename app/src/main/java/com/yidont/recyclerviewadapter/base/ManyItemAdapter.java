package com.yidont.recyclerviewadapter.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.view.ViewGroup;

import com.yidont.recyclerviewadapter.bean.ManyItemType;

import java.util.List;

/**
 * RecyclerView 多种布局的适配器
 * Created by zwonb on 2018/1/19.
 */

public class ManyItemAdapter<E extends ManyItemType, VH extends SuperViewHolder<E>> extends SuperAdapter<E, VH> {

    protected Context mContext;
    private final Class[] mVhClass;

    public ManyItemAdapter(@NonNull List<E> listData, @Size(min = 2) Class... vhClass) {
        super(listData, vhClass[0]);
        mVhClass = vhClass;
    }

    @Override
    public int getItemViewType(int position) {
        return getData().get(position).getItemViewType();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        return getViewHolder(parent, mVhClass[viewType]);
    }

}
