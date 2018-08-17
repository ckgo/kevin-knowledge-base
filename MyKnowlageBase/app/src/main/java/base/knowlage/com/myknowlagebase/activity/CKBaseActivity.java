package base.knowlage.com.myknowlagebase.activity;
/*
 * -----------------------------------------------------------------
 * Copyright (C) 2014-2018, by 中伟科计算机研究院, All rights reserved.
 * -----------------------------------------------------------------
 *
 * File: BaseActivity.java
 * Author: Taylor
 * Version: V100R001C01
 * Create: 2018/8/15 13:31
 * Desc: Activity基类
 *
 * Changes (from 2018/8/15)
 * -----------------------------------------------------------------
 * 2018/8/15 : Create BaseActivity.java (Taylor);
 * -----------------------------------------------------------------
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public abstract class CKBaseActivity extends Activity {
    /***是否显示标题栏*/
    private boolean isshowtitle = false;
    /***是否显示状态栏*/
    private boolean isshowstate = true;
    /***封装toast对象**/
    private static Toast toast;
    /***获取TAG的activity名称**/
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isshowtitle) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        if (!isshowstate) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        //设置布局
        setContentView(initLayout());
        //初始化控件
        initView();
        //设置数据
        initData();
    }


    /**
     * 设置布局
     *
     * @return
     */
    public abstract int initLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();

    /**
     * 是否设置标题栏
     *
     * @return
     */
    public void setTitle(boolean ishow) {
        isshowtitle = ishow;
    }

    /**
     * 设置是否显示状态栏
     *
     * @param ishow
     */
    public void setState(boolean ishow) {
        isshowstate = ishow;
    }

}
