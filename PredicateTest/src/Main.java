import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Collection<String> books=new HashSet();
        books.add("crazy java");
        books.add("crazy Android");
        books.add("c++ primer");

        System.out.println("num of str contains crazy:"+calAll(books,ele->((String)ele).contains("crazy")));
        System.out.println("num of str length over 10:"+calAll(books,ele->((String)ele).length()>10));
    }

    static int calAll(Collection c, Predicate p)
    {
        int num=0;
        for(Object obj:c)
        {
            if(p.test(obj))
            {
                num++;
            }
        }
        return num;
    }
}
