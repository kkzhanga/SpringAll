package cn.kk.threadlocal.inheritable;

/**
 * @Description TODO
 * @Date 2021/6/2 15:25
 * @Version 1.0
 * @Author zhangkk
 */
public class Inheritable_A01 {

  private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal();

  /**
   * Inheritable_Q01问题产生原因：
   *  每个线程都会有一个自己的ThreadLocalMap,
   *  所以子线程在调用get方法拿值的时候其实访问的是自己的ThreadLocalMap，
   *  这个Map和主线程的Map是两个不同的对象，所以肯定是拿不到值的。
   *
   * 解决：
   *  InheritableThreadLocal类可以使子线程访问父线程的变量
   *
   * 原理：
   *  InheritableThreadLocal在get()时覆写了getmap(),返回的是inheritableThreadLocals属性
   *  而在线程init()的时候,判断父线程中inheritableThreadLocals属性不为空的话就复制给子线程
   *
   *  注意：
   *   一旦子线程被创建以后，再操作父线程中的ThreadLocal变量，那么子线程是不能感知的
   *   因为父线程和子线程还是拥有各自的ThreadLocalMap,只是在创建子线程的“一刹那”
   *   将父线程的ThreadLocalMap复制给子线程，后续两者就没啥关系了
   *   例如在子线程中去set,而取到的是子线程中值
   */
  public static void main(String[] args) {
    threadLocal.set("mainThread");
    System.out.println("父线程：" + threadLocal.get());
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        threadLocal.set("sonThread");
        System.out.println("子线程：" + threadLocal.get());
      }
    });
    thread.start();
  }

}
