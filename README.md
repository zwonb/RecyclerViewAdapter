# RecyclerViewAdapter

[ ![Download](https://api.bintray.com/packages/zhouyb/maven/rvadapter/images/download.svg) ](https://bintray.com/zwonb/maven/rvadapter/_latestVersion)

```java
implementation "com.zwonb:rvadapter:<last-version>"
```
简单的 Recyclerview Adapter，不需要新建Adapter适配器，直接新建一个ViewHolder即可。
数据设置全部都在` ViewHolder.setDate(E) `里面完成。支持多种ItemType！

## 使用

新建一个 Holder 类继承 SuperViewHolder<E>

```java
public class Holder extends SuperViewHolder<Bean> {

    public Holder(ViewGroup parent) {
        super(parent, R.layout.item_layout);
    }

    @Override
    protected void setDate(Bean bean) {
        // 设置你的数据
        setText(R.id.item_text, bean.getString());
    }

}

```

- 注意！这里的构造方法必须是一个参数，而且这个参数必须是 android.View.ViewGroup

```java
Constructor(android.View.ViewGroup) {
    super(parent, R.layout.item_layout);
}

```

### 如果只是显示单种ItemType，只需要 new SuperAdapter<E, VH> 传入对应参数即可

```java
RecyclerView recyclerView = findViewById(R.id.recycler_view);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
SuperAdapter<SingleBean, SuperViewHolder<SingleBean>> adapter = new SuperAdapter<>(getList(), SingleHolder.class);
recyclerView.setAdapter(adapter);

```

### 如果想要显示多种ItemType

#### 第一步
实体类Bean必须实现 ManyItemType 接口

```java
public class ManyBean implements ManyItemType {

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemViewType() {
        return getType();
    }
}

```

- 注意！这里的 type 必须从0开始。

举个例子，需要实现两种不同ItemType的布局
```java
ManyItemAdapter<>(getList(), ManyHolder1.class, ManyHolder2.class)
```
这里的 type = 0 代表 ManyHolder1 这种布局
这里的 type = 1 代表 ManyHolder2 这种布局
...
type 的值不能大于传入Holder的数量

#### 第二步

需要使用这个适配器 ManyItemAdapter<E, VH>

```java
RecyclerView recyclerView = findViewById(R.id.recycler_view);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
ManyItemAdapter<ManyBean, SuperViewHolder<ManyBean>> adapter = new ManyItemAdapter<>(getList(), ManyHolder1.class, ManyHolder2.class);
recyclerView.setAdapter(adapter);

```

## 混淆规则
```java
-keep class * extends com.zwonb.rvadapter.SuperViewHolder {
    public <methods>;
}

```
