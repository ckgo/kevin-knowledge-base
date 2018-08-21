package base.knowlage.com.myknowlagebase.activity.image;

import android.content.Intent;
import android.widget.ListView;

import base.knowlage.com.myknowlagebase.activity.CKCatalogBaseActivity;
import base.knowlage.com.myknowlagebase.activity.listview.CKListViewActivity;
import base.knowlage.com.myknowlagebase.activity.listview.CKRecyclerviewActivity;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/21 13:57
 * Desc:类功能描述
 */
public class CKMainImageActivity extends CKCatalogBaseActivity {

    private ListView listView;

    private String[] data = {
            "单个图片选择",
            "多个图片选择",
            "识别二维码",
    };


    @Override
    public String[] getListData() {
        return data;
    }

    @Override
    public void itemClick(int position) {
        if (position == 0) {
            Intent in = new Intent(CKMainImageActivity.this, CKListViewActivity.class);
            startActivity(in);
        } else if (position == 1) {
            Intent in = new Intent(CKMainImageActivity.this, CKListViewActivity.class);
            startActivity(in);
        } else if (position == 2) {
            Intent in = new Intent(CKMainImageActivity.this, CKRecyclerviewActivity.class);
            startActivity(in);
        }
    }
}