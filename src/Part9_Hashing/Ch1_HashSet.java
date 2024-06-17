package Part9_Hashing;

import java.util.HashSet;
import java.util.Iterator;


public class Ch1_HashSet {
    public static void main(String[] args) {
        

        // creating 
        HashSet<Integer> set = new HashSet<>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //print all the elements
        System.out.println(set);

        //Size
        System.out.println(set.size());//3

        //Search - contains
        if (set.contains(1)) {
            System.out.println("Set Contains 1");
        }
        if (!set.contains(6)) {
            System.out.println("Set doesn't Contains 6");
        }

        //delete
        // set.remove(1);
        // if (!set.remove(1)) {
        //     System.out.println("We deleted 1");
        // }

        //iterator
        Iterator it = set.iterator();
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.next());
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
