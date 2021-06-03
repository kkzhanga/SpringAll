package cn.kk.threadlocal.inheritable;

/**
 * @Description TODO
 * @Date 2021/6/2 15:25
 * @Version 1.0
 * @Author zhangkk
 */
public class Inheritable_Q01 {
  private static ThreadLocal<String> threadLocal = new ThreadLocal();

  /**
   * 问题：
   *      子线程访问不到父线程中变量数据
   * 输出如下：
   *        父线程：mainThread
   *        子线程：null
   * 原因：
   *
   */
  public static void main(String[] args) {
    threadLocal.set("mainThread");
    System.out.println("父线程：" + threadLocal.get());
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("子线程：" + threadLocal.get());
      }
    });
    thread.start();
  }
}
