package com.vb.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.BarUtils;
import com.blankj.utilcode.utils.ImageUtils;
import com.blankj.utilcode.utils.KeyboardUtils;
import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ScreenUtils;
import com.blankj.utilcode.utils.SizeUtils;
import com.blankj.utilcode.utils.ViewUtils;


public class MainActivity extends AppCompatActivity {

    Context mContext;
    TextView tv_info;

    private ImageView iv_smaller, iv_bigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        tv_info = (TextView) findViewById(R.id.tv_info);
        iv_smaller = (ImageView) findViewById(R.id.iv_smaller);
        iv_bigger = (ImageView) findViewById(R.id.iv_bigger);


        findViewById(R.id.btn_screen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("状态栏高度：" + BarUtils.getStatusBarHeight(mContext)
                        + "\n屏幕宽度：" + ScreenUtils.getScreenWidth((Activity) mContext)
                        +"\n屏幕高度：" + ScreenUtils.getScreenHeight((Activity) mContext));
            }
        });

        findViewById(R.id.btn_net).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NetworkUtils.isAvailable(mContext)) {
                    tv_info.setText("当前网络状态可用");
                }else {
                    tv_info.setText("当前网络状态不可用");
                }
            }
        });

        findViewById(R.id.btn_dp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("10dp转化为" + SizeUtils.dp2px(mContext, 10) + "像素");
            }
        });

        findViewById(R.id.btn_px).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("10像素转化为" + SizeUtils.px2dp(mContext, 10) + "dp");
            }
        });

        findViewById(R.id.btn_wifiip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("当前wifi的ip是" + NetworkUtils.getWifiIp(mContext));
            }
        });

        findViewById(R.id.btn_nettype).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText(NetworkUtils.getNetWorkType(mContext) + "");
            }
        });

        findViewById(R.id.btn_hidenkeyboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtils.hideSoftInput((Activity) mContext);
                tv_info.setText("隐藏键盘");
            }
        });

        findViewById(R.id.btn_versiontag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("当前app版本号是：" + AppUtils.getAppVersionName(mContext));
            }
        });

        findViewById(R.id.btn_versioncode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("当前app版本code是：" + AppUtils.getAppVersionCode(mContext));
            }
        });


        findViewById(R.id.btn_manifest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("string=" + AppUtils.getManifestMetaDataStr(mContext, "manifest_str") +
                        ", int=" + AppUtils.getManifestMetaDataInt(mContext, "manifest_int", -1));
            }
        });

        findViewById(R.id.btn_widthheight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_info.setText("宽度：" + ViewUtils.getViewWidth(v) + "    高度：" + ViewUtils.getViewHeight(v));
            }
        });

        findViewById(R.id.btn_setx).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.setLayoutX(findViewById(R.id.slider), 200);
                tv_info.setText("设置X");
            }
        });

        findViewById(R.id.btn_sety).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.setLayoutY(findViewById(R.id.slider), 500);
                tv_info.setText("设置Y");
            }
        });

        findViewById(R.id.btn_setxy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.setLayout(findViewById(R.id.slider), 400, 200);
                tv_info.setText("设置XY");
            }
        });

        Bitmap bitCat = BitmapFactory.decodeResource(getResources(), R.mipmap.cat);
        iv_smaller.setImageBitmap(ImageUtils.scaleBitmap(bitCat, 200, 0));
        iv_bigger.setImageBitmap(ImageUtils.scaleBitmap(bitCat, 1000, 0));

    }

    @Override
    protected void onResume() {
        super.onResume();
        tv_info.setText("Width:" + ViewUtils.getViewWidthNoContent(tv_info) + "     Height:" + ViewUtils.getViewHeightNoContent(tv_info));
    }
}
