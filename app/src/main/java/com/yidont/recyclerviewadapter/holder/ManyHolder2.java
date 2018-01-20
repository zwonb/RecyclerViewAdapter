package com.yidont.recyclerviewadapter.holder;

import android.view.ViewGroup;

import com.yidont.recyclerviewadapter.R;
import com.yidont.recyclerviewadapter.base.SuperViewHolder;
import com.yidont.recyclerviewadapter.bean.ManyBean;


/**
 * many item holder2
 * Created by zwonb on 2018/1/19.
 */

public class ManyHolder2 extends SuperViewHolder<ManyBean> {

    public ManyHolder2(ViewGroup parent) {
        super(parent, R.layout.item2_img);
    }

    @Override
    protected void setDate(ManyBean bean, int position) {
        // 设置你的数据
        setImageResource(R.id.item2_img, bean.getImg());
    }

}
