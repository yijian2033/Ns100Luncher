package com.nas.ns100luncher.manager;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

/**
 * 二维码生成辅助类
 */

public class ZxingHelper {

    private static ZxingHelper instance = null;

    public static ZxingHelper getInstance() {
        if (instance == null) {
            instance = new ZxingHelper();
        }
        return instance;
    }

    /**
     * 生成二维码
     *
     * @param msg
     * @return
     */
    public Bitmap encodeAsBitmap(String msg) {
        Bitmap bitmap = null;
        BitMatrix result = null;
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            result = multiFormatWriter.encode(msg, BarcodeFormat.QR_CODE, 300, 300);
            //使用zxing要写的代码
            BarcodeEncoder encoder = new BarcodeEncoder();
            bitmap = encoder.createBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
