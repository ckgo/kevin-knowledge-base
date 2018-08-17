package base.knowlage.com.myknowlagebase.activity.listview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import base.knowlage.com.myknowlagebase.R;
import base.knowlage.com.myknowlagebase.activity.CKBaseActivity;
import base.knowlage.com.myknowlagebase.model.CKModelGoods;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/16 16:20
 * Desc:普通的listview
 */
public class CKListViewActivity extends CKBaseActivity {
    private ListView listView;

    private List<CKModelGoods> listdata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_cklist_view;
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(R.id.list_view);
    }

    @Override
    public void initData() {
        for (int i = 0; i < 50; i++) {
            CKModelGoods goods = new CKModelGoods();
            goods.setName("Kevin");
            goods.setPrice("$1988");
            goods.setImgurl("");
            listdata.add(goods);
        }
        MyAdapter adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
    }

    public final class ViewHolder {
        public ImageView img;
        public TextView txtname;
        public TextView txtprice;
    }


    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return listdata.size();
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_activity_cklistview, null);
                holder.img = (ImageView) convertView.findViewById(R.id.img);
                holder.txtname = (TextView) convertView.findViewById(R.id.txtname);
                holder.txtprice = (TextView) convertView.findViewById(R.id.txtprice);
                convertView.setTag(holder);
            } else {

                holder = (ViewHolder) convertView.getTag();
            }
            // holder.img.setImageBitmap(null);
            holder.txtname.setText((String) listdata.get(position).getName());
            holder.txtprice.setText((String) listdata.get(position).getPrice());
            return convertView;
        }
    }
}
