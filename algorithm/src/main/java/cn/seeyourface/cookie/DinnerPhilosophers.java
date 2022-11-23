package cn.seeyourface.cookie;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * <p>
 *     信号量解决哲学家就餐问题
 *     奇数位哲学家先拿起右手边叉子，偶数位哲学家先拿起左手边叉子
 * </p>
 *
 * @author yangLei
 * @date 2022/11/23 11:16
 * @since 1.0.0
 */
@Slf4j
public class DinnerPhilosophers {

    /** 叉子数量 */
    public static final int NUM = 5;

    private static final Semaphore[] semaphore = new Semaphore[]{
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1)
    };

    static class MyThread implements Runnable {

        private final int i;

        public MyThread(int i) {
            this.i = i;
        }

        @Override
        @SneakyThrows
        public void run() {
            while (true) {
                think(i);
                if (i % 2 == 0) {
                    // 偶数号哲学家先拿起左手边叉子，再拿起右手边叉子
                    semaphore[i % 5].acquire();
                    semaphore[(i + 1) % 5].acquire();
                } else {
                    // 奇数号哲学家先拿起右手边叉子，再拿起左手边叉子
                    semaphore[(i + 1) % 5].acquire();
                    semaphore[i % 5].acquire();
                }
                // 吃饭需要两个叉子，属于临界区，被别人拿了就吃不了
                eat(i);
                // 释放两手叉子
                semaphore[i % 5].release();
                semaphore[(i + 1) % 5].release();
                log.info("哲学家" + i + "进餐完毕...");
            }
        }
    }

    private static void think(int i) throws InterruptedException {
        log.info("哲学家" + i + "思考中...");
        Thread.sleep(5000);
    }

    private static void eat(int i) throws InterruptedException {
        log.info("哲学家" + i + "进餐中...");
        Thread.sleep(10000);
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; ++i) {
            Thread t = new Thread(new MyThread(i));
            t.start();
        }
    }
}
