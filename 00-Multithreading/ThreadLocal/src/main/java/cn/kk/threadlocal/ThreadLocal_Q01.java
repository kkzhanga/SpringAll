package cn.kk.threadlocal;

/**
 * @Description
 * @Date 2021/6/1 14:33
 * @Version 1.0
 * @Author zhangkk
 */
public class ThreadLocal_Q01 {

  private static String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    ThreadLocal_Q01.content = content;
  }

  /**
   * 循环创建多个线程是对变量访问
   * 多访问几次发现数据混乱，如下：
   * 线程1--->线程0的数据
   * 线程2--->线程2的数据
   * 线程0--->线程0的数据
   */
  public static void main(String[] args) {

    final ThreadLocal_Q01 demo = new ThreadLocal_Q01();
    for (int i = 0; i < 3; i++) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          demo.setContent(Thread.currentThread().getName() + "的数据");
          System.out.println("---"+content+"---");
          System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
        }
      });
      thread.setName("线程" + i);
      thread.start();
    }
  }

}
