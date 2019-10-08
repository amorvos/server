package com.xiaoleilu.loServer.listener;

import com.xiaoleilu.hutool.io.IoUtil;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.RandomAccessFile;

/**
 * 文件进度指示监听
 *
 * @author Looly
 */
public class FileProgressiveFutureListener implements ChannelProgressiveFutureListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileProgressiveFutureListener.class);

    private RandomAccessFile raf;

    public FileProgressiveFutureListener(RandomAccessFile raf) {
        this.raf = raf;
    }

    @Override
    public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) {
        LOGGER.debug("Transfer progress: {} / {}", progress, total);
    }

    @Override
    public void operationComplete(ChannelProgressiveFuture future) {
        IoUtil.close(raf);
        LOGGER.debug("Transfer complete.");
    }

    /**
     * 构建文件进度指示监听
     *
     * @param raf RandomAccessFile
     * @return 文件进度指示监听
     */
    public static FileProgressiveFutureListener build(RandomAccessFile raf) {
        return new FileProgressiveFutureListener(raf);
    }
}
