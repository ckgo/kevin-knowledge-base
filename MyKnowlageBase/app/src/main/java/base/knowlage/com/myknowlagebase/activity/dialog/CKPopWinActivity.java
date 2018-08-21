package base.knowlage.com.myknowlagebase.activity.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.flyco.animation.SlideEnter.SlideTopEnter;
import com.flyco.animation.SlideExit.SlideTopExit;
import com.flyco.dialog.widget.popup.base.BasePopup;

import base.knowlage.com.myknowlagebase.R;
import base.knowlage.com.myknowlagebase.util.T;

/**
 * popwin展示 changkuan
 */
public class CKPopWinActivity extends AppCompatActivity {

    Button btn;

    private SimpleCustomPop mQuickCustomPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ckpopwin);
        mQuickCustomPopup = new SimpleCustomPop(CKPopWinActivity.this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuickCustomPopup
                        .alignCenter(true)
                        .anchorView(btn)
                        .gravity(Gravity.BOTTOM)
                        .showAnim(new SlideTopEnter())
                        .dismissAnim(new SlideTopExit())
                        .offset(0, 0)
                        .dimEnabled(false)
                        .show();
            }
        });
    }


    class SimpleCustomPop extends BasePopup<SimpleCustomPop> {

        TextView mTvItem1;
        TextView mTvItem2;
        TextView mTvItem3;
        TextView mTvItem4;

        public SimpleCustomPop(Context context) {
            super(context);
            //setCanceledOnTouchOutside(false);
        }

        @Override
        public View onCreatePopupView() {
            View inflate = View.inflate(mContext, R.layout.popup_custom, null);

            mTvItem1 = (TextView) inflate.findViewById(R.id.tv_item_1);
            mTvItem2 = (TextView) inflate.findViewById(R.id.tv_item_2);
            mTvItem3 = (TextView) inflate.findViewById(R.id.tv_item_3);
            mTvItem4 = (TextView) inflate.findViewById(R.id.tv_item_4);
            return inflate;
        }

        @Override
        public void setUiBeforShow() {
            mTvItem1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    T.showShort(mContext, mTvItem1.getText());
                    dismiss();
                }
            });
            mTvItem2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    T.showShort(mContext, mTvItem2.getText());
                    dismiss();
                }
            });
            mTvItem3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    T.showShort(mContext, mTvItem3.getText());
                    dismiss();
                }
            });
            mTvItem4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    T.showShort(mContext, mTvItem4.getText());
                    dismiss();
                }
            });
        }
    }
}
