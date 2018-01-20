package com.yidont.recyclerviewadapter.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * RecyclerView 单种布局的适配器
 * Created by zwonb on 2018/1/19.
 */

public class SuperAdapter<E, VH extends SuperViewHolder<E>> extends RecyclerView.Adapter<VH> {

    protected Context mContext;
    private List<E> mList;
    private final Class mVhClass;
    private OnItemClickListener mOnItemClickListener;

    public SuperAdapter(List<E> list, Class vhClass) {
        mList = list;
        mVhClass = vhClass;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        return getViewHolder(parent, mVhClass);
    }

    @Override
    public void onBindViewHolder(VH holder, @SuppressLint("RecyclerView") final int position) {
        holder.setDate(mList.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    /**
     * 获取 Class 对象
     *
     * @return ViewHolder的对象
     */
    @SuppressWarnings("unchecked cast")
    VH getViewHolder(ViewGroup parent, Class vhClass) {
        try {
            Constructor constructor = vhClass.getConstructor(ViewGroup.class);
            return (VH) constructor.newInstance(parent);
        } catch (NoSuchMethodException | IllegalAccessException |
                InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("找不到相关 ViewHolder ,查看是否已经添加混淆代码");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<E> getData() {
        return mList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}
