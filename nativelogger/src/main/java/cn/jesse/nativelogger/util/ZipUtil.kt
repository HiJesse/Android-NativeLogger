package cn.jesse.nativelogger.util;

import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import cn.jesse.nativelogger.NLogger;

/**
 * Created by jesse on 9/8/16.
 */
public class ZipUtil {
    private static final int BUFF_SIZE = 1024 * 1024;
    private static final String SUFFIX_LOCK = ".lck";
    public static final String SUFFIX_ZIP = ".zip";

    private ZipUtil() {
        //unused
    }

    /**
     * get suitable files from path depend on pack num ,clear redundant files
     *
     * @param path source files path
     * @param expiredPeriod expired file period
     */
    public static Collection<File> getSuitableFilesWithClear(String path, int expiredPeriod) {
        Collection<File> files = new CopyOnWriteArrayList<>();
        File file = new File(path);
        File[] subFile = file.listFiles();

        if (null == subFile)
            return files;

        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            if (!subFile[iFileLength].isDirectory()) {
                File item = subFile[iFileLength];

                long expired = expiredPeriod * 24 * 60 * 60 * 1000L;
                if ((System.currentTimeMillis() - item.lastModified() > expired) && !item.delete())
                    NLogger.e("can not delete expired file " + item.getName());

                if (item.getName().endsWith(SUFFIX_LOCK) ||
                        item.getName().endsWith(SUFFIX_ZIP))
                    continue;

                files.add(item);
            }
        }
        return files;
    }
    
    /**
     * zip files
     *
     * @param resFileList zip from files
     * @param zipFile zip to file
     * @param comment comment of target file
     */
    public static boolean zipFiles(Collection<File> resFileList, File zipFile, String comment)
            throws IOException {
        if (null == resFileList || resFileList.isEmpty())
            return false;

        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(
                zipFile), BUFF_SIZE));
        for (File resFile : resFileList) {
            zipFile(resFile, zipOutputStream, "");
        }
        if (!TextUtils.isEmpty(comment))
            zipOutputStream.setComment(comment);
        zipOutputStream.close();
        return true;
    }

    /**
     * zip file
     *
     * @param resFile zip from file
     * @param zipOut zip to file
     * @param rootPath target file path
     */
    private static void zipFile(File resFile, ZipOutputStream zipOut, String rootPath)
            throws IOException {
        String filePath = rootPath + (rootPath.trim().length() == 0 ? "" : File.separator)
                + resFile.getName();
        filePath = new String(filePath.getBytes("8859_1"), "GB2312");
        if (resFile.isDirectory()) {
            File[] fileList = resFile.listFiles();
            for (File file : fileList) {
                zipFile(file, zipOut, filePath);
            }
        } else {
            byte[] buffer = new byte[BUFF_SIZE];
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(resFile),
                    BUFF_SIZE);
            zipOut.putNextEntry(new ZipEntry(filePath));
            int realLength;
            while ((realLength = in.read(buffer)) != -1) {
                zipOut.write(buffer, 0, realLength);
            }
            in.close();
            zipOut.flush();
            zipOut.closeEntry();
        }
    }
}
