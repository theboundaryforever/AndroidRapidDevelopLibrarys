package com.bailiangjin.utilslibrary.utils.device;

import android.content.Context;
import android.nfc.NfcManager;
import android.provider.Settings;
import android.support.annotation.Nullable;

import com.bailiangjin.utilslibrary.utils.app.AppUtils;
import com.bailiangjin.utilslibrary.utils.LogUtils;
import com.bailiangjin.utilslibrary.utils.ToastUtils;

/**
 * Created by bailiangjin on 16/9/23.
 */

public class NFCUtils {

    public static boolean isNFCOpen() {
        NfcManager nfcManager = getNfcManager();

        if (null == nfcManager || null == nfcManager.getDefaultAdapter()) {
            return false;
        }

        return nfcManager.getDefaultAdapter().isEnabled();
    }

    @Nullable
    private static NfcManager getNfcManager() {
        Object obj = AppUtils.getContext()
                .getSystemService(Context.NFC_SERVICE);
        return null == obj ? null : (NfcManager) obj;
    }


    public static void toSetNFC() {

        NfcManager nfcManager = getNfcManager();
        if (null != nfcManager && null != nfcManager.getDefaultAdapter()) {
            String action = Settings.ACTION_NFC_SETTINGS;
            DeviceSetUtils.toSetByAction(action);
        } else {
            ToastUtils.shortToast("当前设备不支持NFC");
            LogUtils.e("当前设备不支持NFC");
        }

    }

}
