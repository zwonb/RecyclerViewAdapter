package com.yidont.recyclerviewadapter.holder;

import android.view.ViewGroup;

import com.yidont.recyclerviewadapter.R;
import com.yidont.recyclerviewadapter.base.SuperViewHolder;
import com.yidont.recyclerviewadapter.bean.SingleBean;

/**
 * 单种类型的 holder
 * Created by zwonb on 2018/1/19.
 */

public class SingleHolder extends SuperViewHolder<SingleBean> {

    public SingleHolder(ViewGroup parent) {
        super(parent, R.layout.item_text);
    }

    @Override
    protected void setDate(SingleBean bean) {
        // 设置你的数据
        setText(R.id.item_text, bean.getString());
    }

}
