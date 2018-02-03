package com.sd.storage.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dframe.lib.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by MrZhou on 2016/10/14.
 */
public class ToastUtils {

    public static void showBaseToast(String message, Context context) {
        //  Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);

        showMyToast(toast,1000);

    }

    public static void showBaseToast(int resId, Context context) {
        showBaseToast(context.getString(resId), context);
    }

    public static void showMyToast(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt);
    }


}
