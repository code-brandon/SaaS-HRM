package com.xiaozheng.system.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
public class QRCodeUtil {

    /**
     * 生成Base64 二维码
     */
    public static String crateQRCode(String content) throws IOException {
        log.info(content);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 200, 200);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ImageIO.write(bufferedImage, "png", os);
            //添加图片标识
            return "data:image/png;base64," + Base64.encode(os.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
        return null;
    }

}
