package com.yidont.recyclerviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yidont.recyclerviewadapter.base.ManyItemAdapter;
import com.yidont.recyclerviewadapter.base.SuperViewHolder;
import com.yidont.recyclerviewadapter.bean.ManyBean;
import com.yidont.recyclerviewadapter.holder.ManyHolder1;
import com.yidont.recyclerviewadapter.holder.ManyHolder2;

import java.util.ArrayList;
import java.util.List;

public class ManyItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ManyItemAdapter<ManyBean, SuperViewHolder<ManyBean>> adapter = new ManyItemAdapter<>(getList(), ManyHolder1.class, ManyHolder2.class);
        recyclerView.setAdapter(adapter);
    }

    private List<ManyBean> getList() {
        List<ManyBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ManyBean bean = new ManyBean();
            if (i % 2 == 0) {
                bean.setType(0);
                bean.setStr("数据" + i);
            } else {
                bean.setType(1);
                bean.setImg(R.mipmap.ic_launcher);
            }
            list.add(bean);
        }
        return list;
    }
}
