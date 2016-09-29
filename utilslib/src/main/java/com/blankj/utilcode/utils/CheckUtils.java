package com.blankj.utilcode.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 验证工具类
 * Created by Administrator on 2016/9/29 0029.
 */
public class CheckUtils {

    public static boolean emptyCheck(Context context, String content, CharSequence chars) {
        if(TextUtils.isEmpty(content)) {
            Toast.makeText(context, chars, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public static boolean phoneCheck(Context context, String phone) {
        if(TextUtils.isEmpty(phone)) {
            Toast.makeText(context, "手机号码不能为空！", Toast.LENGTH_SHORT).show();
            return false;
        }
        String telRegex = ConstUtils.REGEX_MOBILE_SIMPLE;
        if(!phone.matches(telRegex)) {
            Toast.makeText(context, "手机号码格式错误！", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
