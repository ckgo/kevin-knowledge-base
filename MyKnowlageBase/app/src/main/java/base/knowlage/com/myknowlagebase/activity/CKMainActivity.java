package base.knowlage.com.myknowlagebase.activity;

import android.content.Intent;

import base.knowlage.com.myknowlagebase.activity.dialog.CKDialogActivity;
import base.knowlage.com.myknowlagebase.activity.listview.CKMainListViewActivity;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/15 14:53
 * Desc:启动页面
 */
public class CKMainActivity extends CKCatalogBaseActivity {

    private String[] data = {
            "列表",
            "弹出框",
            "Http",
            "数据库",
            "activity的启动样式",
            "Fragment"
    };

    @Override
    public String[] getListData() {
        return data;
    }

    @Override
    public void itemClick(int position) {
        if (position == 0) {
            Intent in = new Intent(CKMainActivity.this, CKMainListViewActivity.class);
            startActivity(in);
        } else if (position == 1) {
            Intent in = new Intent(CKMainActivity.this, CKDialogActivity.class);
            startActivity(in);
        }
    }
}
