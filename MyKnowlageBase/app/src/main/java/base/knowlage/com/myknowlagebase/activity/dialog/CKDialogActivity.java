package base.knowlage.com.myknowlagebase.activity.dialog;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.flyco.animation.BounceEnter.BounceTopEnter;
import com.flyco.animation.SlideExit.SlideBottomExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.MaterialDialog;
import com.flyco.dialog.widget.NormalDialog;

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
            "dialog样式6",
            "dialog样式7",
            "dialog样式8",
            "dialog样式9",
            "dialog样式10",
            "popwin选择",
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
            final NormalDialog dialog = new NormalDialog(this);
            dialog.content("是否确定退出程序")
                    .showAnim(new BounceTopEnter())
                    .dismissAnim(new SlideBottomExit())
                    .show();
            dialog.setOnBtnClickL(
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "点击取消");
                            dialog.dismiss();
                        }
                    },
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "点击确定");
                            dialog.dismiss();
                        }
                    });
        } else if (position == 3) {
            final NormalDialog dialog = new NormalDialog(this);
            dialog.content("为保证咖啡豆的新鲜度和咖啡的香味，并配以特有的传统烘焙和手工冲。")//
                    .style(NormalDialog.STYLE_TWO)//
                    .titleTextSize(23)//
                    .showAnim(new BounceTopEnter())
                    .dismissAnim(new SlideBottomExit())
                    .show();
            dialog.setOnBtnClickL(
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "点击取消");
                            dialog.dismiss();
                        }
                    },
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "点击确定");
                            dialog.dismiss();
                        }
                    });

        } else if (position == 4) {
            final NormalDialog dialog = new NormalDialog(this);
            dialog.isTitleShow(false)//
                    .bgColor(Color.parseColor("#383838"))//
                    .cornerRadius(5)//
                    .content("是否确定退出程序?")//
                    .contentGravity(Gravity.CENTER)//
                    .contentTextColor(Color.parseColor("#ffffff"))//
                    .dividerColor(Color.parseColor("#222222"))//
                    .btnTextSize(15.5f, 15.5f)//
                    .btnTextColor(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))//
                    .btnPressColor(Color.parseColor("#2B2B2B"))//
                    .widthScale(0.85f)//
                    .showAnim(new BounceTopEnter())//
                    .dismissAnim(new SlideBottomExit())//
                    .show();
            dialog.setOnBtnClickL(
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "点击取消");
                            dialog.dismiss();
                        }
                    },
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "点击确定");
                            dialog.dismiss();
                        }
                    });
        } else if (position == 5) {
            final NormalDialog dialog = new NormalDialog(this);
            dialog.content("你今天的抢购名额已用完~")//
                    .btnNum(1)
                    .btnText("继续逛逛")//
                    .showAnim(new BounceTopEnter())//
                    .dismissAnim(new SlideBottomExit())//
                    .show();
            dialog.setOnBtnClickL(
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "点击");
                            dialog.dismiss();
                        }
                    });

        } else if (position == 6) {
            BounceTopEnter mBasIn = new BounceTopEnter();
            SlideBottomExit mBasOut = new SlideBottomExit();
            final NormalDialog dialog = new NormalDialog(this);
            dialog.content("你今天的抢购名额已用完~")//
                    .style(NormalDialog.STYLE_TWO)//
                    .btnNum(3)
                    .btnText("取消", "确定", "继续逛逛")//
                    .showAnim(mBasIn)//
                    .dismissAnim(mBasOut)//
                    .show();
            dialog.setOnBtnClickL(
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "left");
                            dialog.dismiss();
                        }
                    }, new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "right");
                            dialog.dismiss();
                        }
                    }, new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "middle");
                            dialog.dismiss();
                        }
                    });

        } else if (position == 7) {
            BounceTopEnter mBasIn = new BounceTopEnter();
            SlideBottomExit mBasOut = new SlideBottomExit();
            final MaterialDialog dialog = new MaterialDialog(this);
            dialog.content(
                    "嗨！这是一个 MaterialDialogDefault. 它非常方便使用，你只需将它实例化，这个美观的对话框便会自动地显示出来它简洁小巧，完全遵照 Google 2014 年发布的 Material Design 风格，希望你能喜欢它！^ ^")
                    .btnText("取消", "确定")//
                    .showAnim(mBasIn)//
                    .dismissAnim(mBasOut)//
                    .show();
            dialog.setOnBtnClickL(
                    new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "left");
                            dialog.dismiss();
                        }
                    }, new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            Log.i("=======", "right");
                            dialog.dismiss();
                        }
                    });
        } else if (position == 8) {
            String[] stringItems = {"接收消息并提醒", "接收消息但不提醒", "收进群助手且不提醒", "屏蔽群消息"};
            final ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, null);
            dialog.layoutAnimation(null);
            dialog.setShowWindowAnim(false);
            dialog.title("选择群消息提醒方式\r\n(该群在电脑的设置:接收消息并提醒)")//
                    .titleTextSize_SP(14.5f)//
                    .show();
            dialog.setOnOperItemClickL(new OnOperItemClickL() {
                @Override
                public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                }
            });

        } else if (position == 9) {
            String[] stringItems = {"版本更新", "帮助与反馈", "退出QQ"};
            final ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, null);
            dialog.layoutAnimation(null);
            dialog.setShowWindowAnim(false);
            dialog.setOnOperItemClickL(new OnOperItemClickL() {
                @Override
                public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                }
            });
            dialog.isTitleShow(false).show();

        } else if (position == 10) {
            Intent in = new Intent(CKDialogActivity.this, CKPopWinActivity.class);
            startActivity(in);
        }
    }


}
