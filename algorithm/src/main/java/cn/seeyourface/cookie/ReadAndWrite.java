package cn.seeyourface.cookie;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * <p>
 *     信号量实现读写者模式
 *     读-读不互斥
 *     读-写互斥
 *     写-写互斥
 * </p>
 *
 * @author yangLei
 * @date 2022/11/23 14:29
 * @since 1.0.0
 */
@Slf4j
public class ReadAndWrite {

    // 读者数量
    private static int rCount = 0;
    // 写写互斥信号
    private static final Semaphore wMutex = new Semaphore(1);
    // 控制修改rCount互斥信号
    private static final Semaphore rMutex = new Semaphore(1);
    // 控制读写线程公平竞争
    private static final Semaphore flag = new Semaphore(1);

    private static void write() throws InterruptedException {
        while (true) {
            flag.acquire();
            wMutex.acquire();
            log.info("正在执行写操作");
            Thread.sleep(300);
            wMutex.release();
            flag.release();
        }
    }

    private static void read() throws InterruptedException {
        for (;;) {
            flag.acquire();
            rMutex.acquire();
            if (rCount == 0) {
                // 如果此时有写者，线程会在这里阻塞直到写者完成
                // 如果没有写者，线程继续执行，但会阻塞写线程
                // 如果信号量初始化不是公平的，则该阻塞线程不保证被选择
                log.info("阻塞写操作");
                wMutex.acquire();
            }
            rCount++;
            log.info("读者进入");
            rMutex.release();

            log.info("正在执行读操作");
            Thread.sleep(100);

            rMutex.acquire();
            rCount--;
            log.info("读者离开");
            if (rCount == 0) {
                log.info("最后一个读者退出，唤醒写操作");
                wMutex.release();
            }
            rMutex.release();
            flag.release();
        }
    }

    public static void main(String[] args) {
        Thread write = new Thread(() -> {
            try {
                write();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread read = new Thread(() -> {
            try {
                read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        write.start();
        read.start();
    }
}
