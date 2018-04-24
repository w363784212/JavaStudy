import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        //由于hashCode为count,根据hashCode值会自动排序存储在hashSet中
        HashSet<R> hashSet=new HashSet<>();
        hashSet.add(new R(5));
        hashSet.add(new R(1));
        hashSet.add(new R(2));
        System.out.println(hashSet);

        //将hashSet第一个元素的count改为2
        Iterator it=hashSet.iterator();
        R first=(R)it.next();
        first.count=2;
        System.out.println(hashSet);

        //删除hashSet中count为1的元素,由于是根据count为2计算hashCode值来删除的，所以删除的是第二个2;
        hashSet.remove(new R(2));
        System.out.println(hashSet);

        //需要hashCode值相等并且equals()方法返回true时contains才返回true,此时剩下的2的hashCode值为1
        System.out.println(hashSet.contains(new R(2)));
        System.out.println(hashSet.contains(new R(1)));
    }
}

class R{
    int count;
    public R(int count){
        this.count=count;
    }
    public String toString(){
        return "R(count:"+count+")";
    }

    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(obj != null && obj.getClass()==R.class){
            return this.count == ((R)obj).count;
        }
        return false;
    }

    public int hashCode(){
        return this.count;
    }
}
