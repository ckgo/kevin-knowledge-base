package base.knowlage.com.myknowlagebase.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import base.knowlage.com.myknowlagebase.R;

/*
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/15 15:30
 * Desc: 目录页面的基类
 */
public abstract class CKCatalogBaseActivity extends CKBaseActivity {

    private ListView listView;

    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(false);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(R.id.list_view);
    }

    @Override
    public void initData() {
        data = getListData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                CKCatalogBaseActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //                if (position == 1) {
                //                    Intent in = new Intent(CatalogBaseActivity.this, CKDialogActivity.class);
                //                    startActivity(in);
                //                }
                itemClick(position);
            }
        });
    }

    public abstract String[] getListData();

    public abstract void itemClick(int position);
}
