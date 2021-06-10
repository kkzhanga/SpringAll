package cn.kk.threadlocal.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Date 2021/6/9 16:24
 * @Version 1.0
 * @Author zhangkk
 */
public class DateUtil {

  //直接用静态sdf会报错
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  static ThreadLocal threadLocal = new ThreadLocal();

  public static DateFormat getDateFormat() {
    DateFormat df = new SimpleDateFormat(DATE_FORMAT);
    /*DateFormat df = (DateFormat) threadLocal.get();
    if (df == null) {
      df = new SimpleDateFormat(DATE_FORMAT);
      threadLocal.set(df);
    }*/
    return df;
  }

  public static Date parse(String strDate) throws ParseException {
    //return sdf.parse(strDate);
    return getDateFormat().parse(strDate);
  }


  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(100);
    for (int i = 0; i < 1000; i++) {
      executorService.execute(() -> {
        try {
          /*DateFormat dt = DateUtil.getDateFormat();
          System.out.println(dt.format(new Date()));*/
          System.out.println(parse("2019-06-15 16:35:20"));
        } catch (Exception e) {
          e.printStackTrace();
        }
      });
    }
  }

}
