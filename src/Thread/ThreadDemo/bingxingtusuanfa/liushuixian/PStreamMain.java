package Thread.ThreadDemo.bingxingtusuanfa.liushuixian;

/**
 * Created by dell on 2017/2/28.
 */
public class PStreamMain {
    public static void main(String args[]) {

        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
                Plus.bq.add(msg);
            }
        }
    }
}
