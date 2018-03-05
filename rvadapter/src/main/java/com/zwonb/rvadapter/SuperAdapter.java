package com.zwonb.rvadapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * RecyclerView 单种布局的适配器
 * Created by zwonb on 2018/1/20.
 */

public class SuperAdapter<E, VH extends SuperViewHolder<E>> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    private List<E> mList;
    private final Class mVHClass;
    private OnItemClickListener mOnItemClickListener;
    private OnItemChildClickListener mOnItemChildClickListener;

    public SuperAdapter(@NonNull List<E> list, @NonNull Class vHClass) {
        mList = list;
        mVHClass = vHClass;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        return getViewHolder(parent, mVHClass);
    }

    @Override
    public void onBindViewHolder(VH holder, @SuppressLint("RecyclerView") int position) {
        holder.setDate(mList.get(position));
        holder.setAdapter(this);
        if (mOnItemClickListener != null) {
            onItemClick(holder);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 获取 ViewHolder 对象
     *
     * @return ViewHolder的对象
     */
    @SuppressWarnings("unchecked cast")
    VH getViewHolder(ViewGroup parent, Class vhClass) {
        try {
            Constructor constructor = vhClass.getConstructor(ViewGroup.class);
            return (VH) constructor.newInstance(parent);
        } catch (Exception e) {
            throw new RuntimeException("找不到相关 ViewHolder ,查看是否已经添加混淆代码");
        }
    }

    public List<E> getData() {
        return mList;
    }

    public void replaceList(List<E> list) {
        mList = list;
    }

    public void updateAllData(List<E> list) {
        mList = list;
        this.notifyDataSetChanged();
    }

    /**
     * @param positions 需要刷新的多个item索引
     */
    public void updateItemsChanged(@Nullable List<E> list, int... positions) {
        if (list != null) {
            mList = list;
        }
        for (int pos : positions) {
            this.notifyItemChanged(pos);
        }
    }

    public void insertedItem(E e) {
        mList.add(e);
        this.notifyItemInserted(mList.size());
    }

    public void removedItem(int position) {
        mList.remove(position);
        this.notifyItemRemoved(position);
    }

    private void onItemClick(final VH holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(SuperAdapter.this, v, holder.getLayoutPosition());
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        mOnItemChildClickListener = onItemChildClickListener;
    }

    public OnItemChildClickListener getOnItemChildClickListener() {
        return mOnItemChildClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(SuperAdapter adapter, View view, int position);
    }

    public interface OnItemChildClickListener {
        void onItemChildClick(SuperAdapter adapter, View view, int position);
    }

}
