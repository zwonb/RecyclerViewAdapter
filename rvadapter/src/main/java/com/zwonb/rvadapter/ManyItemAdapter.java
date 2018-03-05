package com.zwonb.rvadapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

/**
 * RecyclerView 多种布局的适配器
 * Created by zwonb on 2018/1/20.
 */

public class ManyItemAdapter<E extends ManyItemType, VH extends SuperViewHolder<E>> extends SuperAdapter<E, VH> {

    private final Class[] mVHClass;

    public ManyItemAdapter(@NonNull List<E> listData, @NonNull Class... vHClass) {
        super(listData, vHClass[0]);
        mVHClass = vHClass;
    }

    @Override
    public int getItemViewType(int position) {
        return getData().get(position).getItemViewType();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        return super.getViewHolder(parent, mVHClass[viewType]);
    }

}
