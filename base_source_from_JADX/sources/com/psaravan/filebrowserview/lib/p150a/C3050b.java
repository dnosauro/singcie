package com.psaravan.filebrowserview.lib.p150a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.psaravan.filebrowserview.lib.View.FileBrowserView;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.p172io.FileUtils;
import org.apache.commons.p172io.comparator.NameFileComparator;

/* renamed from: com.psaravan.filebrowserview.lib.a.b */
public class C3050b {

    /* renamed from: a */
    private Context f7105a;

    /* renamed from: b */
    private FileBrowserView f7106b;

    /* renamed from: c */
    private File f7107c;

    /* renamed from: d */
    private final long f7108d = 1024;

    /* renamed from: e */
    private final long f7109e = 1048576;

    /* renamed from: f */
    private final long f7110f = FileUtils.ONE_GB;

    /* renamed from: g */
    private final long f7111g = FileUtils.ONE_TB;

    public C3050b(Context context, FileBrowserView fileBrowserView) {
        this.f7105a = context;
        this.f7106b = fileBrowserView;
    }

    /* renamed from: a */
    private String m8855a(long j) {
        long[] jArr = {FileUtils.ONE_TB, FileUtils.ONE_GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "bytes"};
        if (j < 1) {
            return "";
        }
        for (int i = 0; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return m8856a(j, j2, strArr[i]);
            }
        }
        return null;
    }

    /* renamed from: a */
    private String m8856a(long j, long j2, String str) {
        double d = j2 > 1 ? ((double) j) / ((double) j2) : (double) j;
        return new DecimalFormat("#,##0.#").format(d) + " " + str;
    }

    @SuppressLint({"SdCardPath"})
    /* renamed from: a */
    private String m8857a(String str) {
        return (str.equals("/storage/emulated/0") || str.equals("/storage/emulated/0/") || str.equals("/storage/emulated/legacy") || str.equals("/storage/emulated/legacy/") || str.equals("/storage/sdcard0") || str.equals("/storage/sdcard0/") || str.equals("/sdcard") || str.equals("/sdcard/") || str.equals("/mnt/sdcard") || str.equals("/mnt/sdcard/")) ? Environment.getExternalStorageDirectory().toString() : str;
    }

    /* renamed from: b */
    private String m8858b(String str) {
        String[] split = str.split("\\.");
        return split[split.length - 1];
    }

    /* renamed from: a */
    public C3049a mo23901a(File file) {
        String str;
        StringBuilder sb;
        String str2;
        this.f7107c = file;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, NameFileComparator.NAME_INSENSITIVE_COMPARATOR);
            for (File file2 : listFiles) {
                if ((!file2.isHidden() || this.f7106b.mo23867b()) && file2.canRead()) {
                    if (!file2.isDirectory() || !this.f7106b.mo23874g()) {
                        try {
                            String canonicalPath = file2.getCanonicalPath();
                            if (this.f7106b.getFileExtensionFilter() != null) {
                                String[] split = canonicalPath.split(".");
                                if (this.f7106b.getFileExtensionFilter().mo23903a().containsKey("." + split[split.length - 1])) {
                                }
                            }
                            arrayList2.add(canonicalPath);
                            arrayList.add(file2.getName());
                            String str3 = "";
                            try {
                                str3 = file2.getCanonicalPath();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (m8858b(str3).equalsIgnoreCase("mp3") || m8858b(str3).equalsIgnoreCase("3gp") || m8858b(str3).equalsIgnoreCase("m4a") || m8858b(str3).equalsIgnoreCase("aac") || m8858b(str3).equalsIgnoreCase("flac") || m8858b(str3).equalsIgnoreCase("mid") || m8858b(str3).equalsIgnoreCase("xmf") || m8858b(str3).equalsIgnoreCase("mxmf") || m8858b(str3).equalsIgnoreCase("midi") || m8858b(str3).equalsIgnoreCase("rtttl") || m8858b(str3).equalsIgnoreCase("rtx") || m8858b(str3).equalsIgnoreCase("ota") || m8858b(str3).equalsIgnoreCase("imy") || m8858b(str3).equalsIgnoreCase("ogg") || m8858b(str3).equalsIgnoreCase("mkv") || m8858b(str3).equalsIgnoreCase("wav")) {
                                arrayList3.add(0);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("jpg") || m8858b(str3).equalsIgnoreCase("gif") || m8858b(str3).equalsIgnoreCase("png") || m8858b(str3).equalsIgnoreCase("bmp") || m8858b(str3).equalsIgnoreCase("webp")) {
                                arrayList3.add(2);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("3gp") || m8858b(str3).equalsIgnoreCase("mp4") || m8858b(str3).equalsIgnoreCase("ts") || m8858b(str3).equalsIgnoreCase("webm") || m8858b(str3).equalsIgnoreCase("mov") || m8858b(str3).equalsIgnoreCase("mkv")) {
                                arrayList3.add(1);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("pdf")) {
                                arrayList3.add(3);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("p7m") || m8858b(str3).equalsIgnoreCase("p7s")) {
                                arrayList3.add(4);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("doc") || m8858b(str3).equalsIgnoreCase("docx") || m8858b(str3).equalsIgnoreCase("odt") || m8858b(str3).equalsIgnoreCase("rtf")) {
                                arrayList3.add(5);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("xls") || m8858b(str3).equalsIgnoreCase("xlsx") || m8858b(str3).equalsIgnoreCase("csv")) {
                                arrayList3.add(6);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("ppt") || m8858b(str3).equalsIgnoreCase("pptx") || m8858b(str3).equalsIgnoreCase("pps")) {
                                arrayList3.add(7);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("txt") || m8858b(str3).equalsIgnoreCase("log")) {
                                arrayList3.add(8);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("apk")) {
                                arrayList3.add(9);
                                sb = new StringBuilder();
                            } else if (m8858b(str3).equalsIgnoreCase("zip") || m8858b(str3).equalsIgnoreCase("rar") || m8858b(str3).equalsIgnoreCase("7z")) {
                                arrayList3.add(10);
                                sb = new StringBuilder();
                            } else {
                                arrayList3.add(100);
                                sb = new StringBuilder();
                            }
                            sb.append("");
                            str2 = m8855a(file2.length());
                        } catch (IOException unused) {
                        }
                    } else {
                        arrayList2.add(Build.VERSION.SDK_INT >= 17 ? m8857a(file2.getAbsolutePath()) : file2.getAbsolutePath());
                        arrayList.add(file2.getName());
                        File[] listFiles2 = file2.listFiles();
                        if (listFiles2 != null) {
                            arrayList3.add(200);
                            if (listFiles2.length == 1) {
                                sb = new StringBuilder();
                                sb.append("");
                                sb.append(listFiles2.length);
                                str2 = " item";
                            } else {
                                sb = new StringBuilder();
                                sb.append("");
                                sb.append(listFiles2.length);
                                str2 = " items";
                            }
                        } else {
                            arrayList3.add(200);
                            str = "Unknown items";
                            arrayList4.add(str);
                        }
                    }
                    sb.append(str2);
                    str = sb.toString();
                    arrayList4.add(str);
                }
            }
        }
        return new C3049a(arrayList, arrayList3, arrayList2, arrayList4);
    }

    /* renamed from: a */
    public File mo23902a() {
        return this.f7107c;
    }
}
