package com.sammymanunggal.tugasBesarPBP;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.util.Locale;

public final class UtilityPR {
    private UtilityPR() {
        // no instance
    }
    public static String getRootDirPath(Context context) {
        //meletakkan file hasil download ke folder android/data/package/files
        //meletakkan file hasil download ke folder root/download
        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Download");
        return docsFolder.getAbsolutePath();
    }

    public static String getProgressDisplayLine(long currentBytes, long totalBytes) {
        return getBytesToMBString(currentBytes) + "/" + getBytesToMBString(totalBytes);
    }

    private static String getBytesToMBString(long bytes){
        return String.format(Locale.ENGLISH, "%.2fMb", bytes / (1024.00 * 1024.00));
    }
}
