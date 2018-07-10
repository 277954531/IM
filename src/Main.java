import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class Main {

    private static ScheduledFuture<?> scheduledFuture;
    private static ScheduledFuture<?> scheduledFuture1;
    private static ScheduledExecutorService setThreadPool;

    public static void main(String[] args) {
/*        File file = new File("E:/test");
//        boolean mkdirs = file.mkdirs();

        System.out.println(file.delete());*/
        double v = (Math.sqrt(Math.pow(1920, 2) + Math.pow(1080, 2))) / 72;
        System.out.println(v);
    }

    private static class SendRunnable implements Runnable {

        private final int id;
        private int i;

        public SendRunnable(int i) {
            this.id = i;
        }

        @Override
        public void run() {
            if (id == 1 && i == 10) {
                setThreadPool.shutdownNow();
                scheduledFuture.cancel(false);
                scheduledFuture.cancel(false);
            }
            if (id == 2 && i == 10) {
                scheduledFuture1.cancel(true);
                scheduledFuture1.cancel(true);
            }
            System.out.println(Thread.currentThread().getName() + "--" + id + "--" + i++);

        }
    }

    /**
     * 判断6位密码是不是太简单
     *
     * @param pwd 6位密码
     * @return 太简单true 不简单false
     */
    public static boolean isSoSimple(String pwd) {
        String sequence = "1234567890";
        String reversed = "0987654321";

        char[] chars = pwd.toCharArray();
        char temple = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0)
                temple = chars[i];
            else {
                if (temple != chars[i]) {
                    return false;
                }
            }
        }
        return sequence.contains(pwd) || reversed.contains(pwd);
    }
}
