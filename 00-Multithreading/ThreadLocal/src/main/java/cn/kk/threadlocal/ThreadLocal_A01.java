package cn.kk.threadlocal;

/**
 * @Description TODO
 * @Date 2021/6/2 15:20
 * @Version 1.0
 * @Author zhangkk@deepblueai.com
 */
public class ThreadLocal_A01 {

  ThreadLocal<String> threadLocal = new ThreadLocal();

  private static String content;

  public String getContent() {
    //return content;
    return threadLocal.get();
  }

  public void setContent(String content) {
    ThreadLocal_A01.content = content;
    threadLocal.set(content);
  }

  /**
   * ThreadLocal_Q01问题产生的原因是由于线程间变量没有隔离
   * 解决：
   *     1.synchronized同步代码块,多并发下效率低下,以时间换空间
   *     2.threadlocal线程间数据隔离,以空间换时间
   *
   */
  public static void main(String[] args) {

    final ThreadLocal_A01 demo = new ThreadLocal_A01();
    for (int i = 0; i < 3; i++) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          //同步代码块
          //synchronized (Answer_01.class) {
          demo.setContent(Thread.currentThread().getName() + "的数据");
          System.out.println("---"+content+"---");
          System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
          // }
        }
      });
      thread.setName("线程" + i);
      thread.start();
    }
  }

}
