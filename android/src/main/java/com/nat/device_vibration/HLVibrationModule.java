package com.nat.device_vibration;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;

/**
 * Created by xuqinchao on 17/2/7.
 *  Copyright (c) 2017 Nat. All rights reserved.
 */

public class HLVibrationModule{
    private Context mContext;
    private static volatile HLVibrationModule instance = null;

    private HLVibrationModule(Context context){
        mContext = context;
    }

    public static HLVibrationModule getInstance(Context context) {
        if (instance == null) {
            synchronized (HLVibrationModule.class) {
                if (instance == null) {
                    instance = new HLVibrationModule(context);
                }
            }
        }

        return instance;
    }
    
    public void vibrate(int time, HLModuleResultListener listener){
        if (time == 0) time = 500;
        cancelVibration();
        vibrate(time);
        listener.onResult(null);
    }

    public void vibrate(long time) {
        if (time == 0) {
            time = 500;
        }
        AudioManager manager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        if (manager.getRingerMode() != AudioManager.RINGER_MODE_SILENT) {
            Vibrator vibrator = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(time);
        }
    }

    public void cancelVibration() {
        Vibrator vibrator = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.cancel();
    }

}
