import java.lang.ref.WeakReference;

public class Main {

    public static void main(String[] args) {
        //如果直接String str = "Crazy Java Course"; 则字符串直接添加到常量池中，gc时不会回收
        String str =new String("Crazy Java Course");
        WeakReference wr=new WeakReference(str);
        str=null;
        System.out.println(wr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        System.out.println(wr.get());
    }
}
