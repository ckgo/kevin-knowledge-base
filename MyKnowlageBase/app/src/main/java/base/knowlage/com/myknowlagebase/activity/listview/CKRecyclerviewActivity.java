package base.knowlage.com.myknowlagebase.activity.listview;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import base.knowlage.com.myknowlagebase.R;
import base.knowlage.com.myknowlagebase.activity.CKBaseActivity;
import base.knowlage.com.myknowlagebase.model.CKModelGoods;

public class CKRecyclerviewActivity extends CKBaseActivity {

    private RecyclerView recyclerView;
    private RefreshLayout mRefreshLayout;
    private ClassicsHeader headerView;
    private ClassicsFooter footerView;
    private List<CKModelGoods> listdata = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_ckrecyclerview;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));//默认分割线

        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        mRefreshLayout.setReboundDuration(300);

        headerView = (ClassicsHeader) findViewById(R.id.headerView);
        headerView.setFinishDuration(0);
        footerView = (ClassicsFooter) findViewById(R.id.footerView);
        footerView.setFinishDuration(0);

        //刷新
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                listdata.clear();
                for (int i = 0; i < 10; i++) {
                    CKModelGoods goods = new CKModelGoods();
                    goods.setName("Kevin__" + listdata.size());
                    goods.setPrice("$1988");
                    goods.setImgurl("");
                    listdata.add(goods);
                }
                myAdapter.notifyDataSetChanged();
                refreshlayout.finishRefresh();
            }
        });
        //加载更多
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                for (int i = 0; i < 10; i++) {
                    CKModelGoods goods = new CKModelGoods();
                    goods.setName("Kevin__" + listdata.size());
                    goods.setPrice("$1988");
                    goods.setImgurl("");
                    listdata.add(goods);
                }
                myAdapter.notifyDataSetChanged();
                refreshlayout.finishLoadmore();
            }
        });

    }

    @Override
    public void initData() {
        for (int i = 0; i < 50; i++) {
            CKModelGoods goods = new CKModelGoods();
            goods.setName("Kevin__" + listdata.size());
            goods.setPrice("$1988");
            goods.setImgurl("");
            listdata.add(goods);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter = new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    CKRecyclerviewActivity.this).inflate(R.layout.item_activity_ckrecyclerview, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.txtname.setText(listdata.get(position).getName());
            holder.txtprice.setText(listdata.get(position).getPrice());
            // holder.img.setImageBitmap(null);
        }

        @Override
        public int getItemCount() {
            return listdata.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView txtname;
            TextView txtprice;
            ImageView img;

            public MyViewHolder(View view) {
                super(view);
                txtname = (TextView) view.findViewById(R.id.txtname);
                txtprice = (TextView) view.findViewById(R.id.txtprice);
                img = (ImageView) view.findViewById(R.id.img);
            }
        }
    }
}
