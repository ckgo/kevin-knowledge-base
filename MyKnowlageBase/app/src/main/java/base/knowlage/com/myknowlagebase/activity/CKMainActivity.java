package base.knowlage.com.myknowlagebase.activity;

import android.Manifest;
import android.content.Intent;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;

import base.knowlage.com.myknowlagebase.activity.dialog.CKDialogActivity;
import base.knowlage.com.myknowlagebase.activity.image.CKMainImageActivity;
import base.knowlage.com.myknowlagebase.activity.listview.CKMainListViewActivity;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/15 14:53
 * Desc:启动页面  程序入口
 */
public class CKMainActivity extends CKCatalogBaseActivity {

    private String[] data = {
            "列表",
            "弹出框",
            "Http",
            "数据库",
            "activity的启动样式",
            "Fragment",
            "动态权限申请（获取联系人权限）",
            "图片选择",
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
        } else if (position == 6) {
            if (AndPermission.hasPermission(this, Manifest.permission.READ_SMS)) {
                // 有权限，直接do anything.
                Toast.makeText(this, "有权限", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "无权限", Toast.LENGTH_LONG).show();
                // 申请权限。
                AndPermission.with(this)
                        .requestCode(100)
                        .permission(Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_SMS)
                        .send();
            }
        } else if (position == 7) {
            Intent in = new Intent(CKMainActivity.this, CKMainImageActivity.class);
            startActivity(in);
        }
    }
}
