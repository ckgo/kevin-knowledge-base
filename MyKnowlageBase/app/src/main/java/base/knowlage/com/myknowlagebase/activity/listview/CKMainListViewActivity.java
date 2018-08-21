package base.knowlage.com.myknowlagebase.activity.listview;

import android.content.Intent;
import android.widget.ListView;

import base.knowlage.com.myknowlagebase.activity.CKCatalogBaseActivity;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/16 16:20
 * Desc:列表知识列表
 */
public class CKMainListViewActivity extends CKCatalogBaseActivity {

    private ListView listView;

    private String[] data = {
            "普通listview",
            "带图片的listview",
            "下拉刷新listview",
            "上拉加载listview",
            "上下拉的listview",
            "普通的recyclerview",
    };


    @Override
    public String[] getListData() {
        return data;
    }

    @Override
    public void itemClick(int position) {
        if (position == 0) {
            Intent in = new Intent(CKMainListViewActivity.this, CKListViewActivity.class);
            startActivity(in);
        } else if (position == 1) {
        } else if (position == 5) {
            Intent in = new Intent(CKMainListViewActivity.this, CKRecyclerviewActivity.class);
            startActivity(in);

        }
    }
}
