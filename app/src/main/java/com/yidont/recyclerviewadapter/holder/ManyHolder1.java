package com.yidont.recyclerviewadapter.holder;

import android.view.ViewGroup;

import com.yidont.recyclerviewadapter.R;
import com.yidont.recyclerviewadapter.base.SuperViewHolder;
import com.yidont.recyclerviewadapter.bean.ManyBean;

/**
 * many item holder1
 * Created by zwonb on 2018/1/19.
 */

public class ManyHolder1 extends SuperViewHolder<ManyBean> {

    public ManyHolder1(ViewGroup parent) {
        super(parent, R.layout.item1_text);
    }

    @Override
    protected void setDate(ManyBean bean) {
        // 设置你的数据
        setText(R.id.item1_text, bean.getStr());
    }

}
