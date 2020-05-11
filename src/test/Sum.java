package test;

import tools.list.LinkedList;

public class Sum {
    public static int sum(int[] arr){
        return arr[0]+every(1,arr);
    }

    private static int every(int l,int[] arr){
        if (l==arr.length)
            return 0;
        return arr[l]+every(l+1,arr);
    }

//    public static void removeNode(LinkedList list,Integer e){
//        if()
//    }
}
