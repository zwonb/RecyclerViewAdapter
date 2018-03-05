package com.zwonb.recyclerviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zwonb.recyclerviewadapter.bean.SingleBean;
import com.zwonb.recyclerviewadapter.holder.SingleHolder;
import com.zwonb.rvadapter.SuperAdapter;
import com.zwonb.rvadapter.SuperViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SingleItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SuperAdapter<SingleBean, SuperViewHolder<SingleBean>> adapter = new SuperAdapter<>(getList(), SingleHolder.class);
        recyclerView.setAdapter(adapter);
    }

    private List<SingleBean> getList() {
        List<SingleBean> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            SingleBean bean = new SingleBean();
            bean.setString("单种类型" + i);
            list.add(bean);
        }
        return list;
    }
}
