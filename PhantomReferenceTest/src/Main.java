import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class Main {

    public static void main(String[] args)
            throws Exception
    {
        String str=new String("Crazy Java Course");
        ReferenceQueue rq=new ReferenceQueue();
        PhantomReference pr=new PhantomReference(str,rq);
        str=null;
        System.out.println(pr.get());
        //垃圾回收
        System.gc();
        System.runFinalization();

        System.out.println(rq.poll()==pr);
    }
}
