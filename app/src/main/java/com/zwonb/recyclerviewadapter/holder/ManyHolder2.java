package com.zwonb.recyclerviewadapter.holder;

import android.view.ViewGroup;

import com.zwonb.recyclerviewadapter.R;
import com.zwonb.recyclerviewadapter.bean.ManyBean;
import com.zwonb.rvadapter.SuperViewHolder;


/**
 * many item holder2
 * Created by zwonb on 2018/1/19.
 */

public class ManyHolder2 extends SuperViewHolder<ManyBean> {

    public ManyHolder2(ViewGroup parent) {
        super(parent, R.layout.item2_img);
    }

    @Override
    protected void setDate(ManyBean bean) {
        // 设置你的数据
        setImageResource(R.id.item2_img, bean.getImg());
    }

}
