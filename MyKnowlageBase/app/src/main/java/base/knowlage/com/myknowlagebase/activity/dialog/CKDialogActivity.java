package base.knowlage.com.myknowlagebase.activity.dialog;

import android.widget.ListView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;

import base.knowlage.com.myknowlagebase.activity.CKCatalogBaseActivity;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/15 14:53
 * Desc: dialog 目录
 */
public class CKDialogActivity extends CKCatalogBaseActivity {

    private ListView listView;

    private String[] data = {
            "dialog样式1",
            "dialog样式2",
            "dialog样式3",
            "dialog样式4",
            "dialog样式5",
    };


    @Override
    public String[] getListData() {
        return data;
    }

    @Override
    public void itemClick(int position) {
        if (position == 0) {
            new AlertView.Builder().setContext(this)
                    .setStyle(AlertView.Style.ActionSheet)
                    .setTitle("选择操作")
                    .setMessage(null)
                    .setCancelText("取消")
                    .setDestructive("拍照", "从相册中选择")
                    .setOthers(null)
                    .setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(Object o, int position) {

                        }
                    })
                    .build()
                    .show();
        } else if (position == 1) {
            new AlertView("上传头像", null, "取消", null, new String[]{"拍照", "从相册中选择"},
                    this, AlertView.Style.ActionSheet, new OnItemClickListener() {
                public void onItemClick(Object o, int position) {
                }
            }).show();
        } else if (position == 2) {
        }
    }
}
