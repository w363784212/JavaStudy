import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Collection<String> books=new HashSet();
        books.add("crazy java");
        books.add("crazy Android");
        books.add("c++ primer");

        books.forEach(obj->System.out.println("Iterator element:"+obj));

        Iterator it =books.iterator();
        while(it.hasNext()) {
            String book=(String)it.next();
            System.out.println(book);
            if(book.equals("crazy Android")) {

                //删除上次调用next()方法返回的对象
                //不可使用books.remove(book);
                //这是因为Iterator的fail-fast机制，一旦迭代过程中集合被修改，程序立即引发ConcurrentModificationException
                it.remove();

            }
            //对book变量赋值，不会改变集合元素本身
            book="test string";
        }
        System.out.println(books);
    }
}
