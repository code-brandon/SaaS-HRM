package com.xiaozheng.common.utils;

import com.sun.istack.internal.NotNull;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Objects;

public class DownloadUtils {


    /**
     * 下载文件流处理
     *
     * @param byteArrayOutputStream 将要写出的文件流
     * @param response              响应
     * @param request               请求
     * @param fileName              文件名
     * @throws IOException
     */
    public static void download(@NotNull ByteArrayOutputStream byteArrayOutputStream, HttpServletRequest request, @NotNull  HttpServletResponse response, @NotNull String fileName, String type) throws IOException {
        addHeader(request, response, type, fileName);
        writeOut(byteArrayOutputStream, response);
    }

    /**
     * 对文件名进编码行格式化
     *
     * @param agent    浏览器类型
     * @param filename 文件名
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getFileName(String agent,@NotNull  String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

    public static void addHeader(HttpServletRequest request,@NotNull  HttpServletResponse response, String type, @NotNull String filename) throws UnsupportedEncodingException {
        String Type = StringUtils.isEmpty(type) ? "application/octet-stream" : type;
        filename = getFileName(Objects.nonNull(request) ? request.getHeader("user-agent"): null, filename);

        response.setCharacterEncoding("UTF-8");
        response.setContentType(Type);
        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("Pragma", "no-cache");
        response.setHeader("filename", filename);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"; filename*=utf-8''" + filename);
    }

    private static void writeOut(@NotNull ByteArrayOutputStream byteArrayOutputStream, @NotNull HttpServletResponse response) throws IOException {
        response.setContentLength(byteArrayOutputStream.size());
        //取得输出流
        ServletOutputStream outputstream = response.getOutputStream();
        //写到输出流
        byteArrayOutputStream.writeTo(outputstream);
        //关闭
        byteArrayOutputStream.close();
        //刷数据
        outputstream.flush();
    }

}
