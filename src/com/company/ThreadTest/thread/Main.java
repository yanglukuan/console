package com.company.ThreadTest.thread;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

//
//        Set<String> hashset=new HashSet<>();
//
//        hashset.add("1");
//
//        for (String str:hashset){
//            System.out.println(str);
//        }
//
//
//        Set<String> linkedhashSet=new LinkedHashSet<>();
//
//        linkedhashSet.add("3");
//        linkedhashSet.add(null);
//
//        for (String s:linkedhashSet)
//        {
//            System.out.println(s);
//        }
//
//
//        Set<String> treeSet=new TreeSet<>();
//
//        treeSet.add("2");
//
//        for (String s:treeSet) {
//            System.out.println(s);
//        }
//
//        final   String ssss="2";

        int[] arry=new int[]{1,2,3,4,5,6,7};
        Reverse(arry,1,3);
        //reverseArray2(arry);
    }



//    请将方法补充完整：
//
//    public static void Reverse(int[] array, int begin, int end)
//    {
//   ...
//    }
//    Reverse方法的作用是将array数组中，从begin下标到end下标之间的元素反序一下，如一个数组初始值是[1, 2, 3, 4, 5, 6]，begin为1，end为4，那么当调用了Reverse之后，
//    array数组中的元素便依次成为[1, 5, 4, 3, 2, 6]，其中从array[1]到array[4]之前的元素被反序了。此外补充一点……其实本不用补充：这个方法需要对传入参数的正确性进行校验，
//    如果用户调用该方法时传入了非法的参数，那么则需要抛出异常，并写清原因。您可以使用您喜欢的语言来实现：C#，VB，Java，Ruby，Python……但是请不要使用内置库中已经有的功能。:)
    public static void Reverse(int[] array, int begin, int end) throws Exception {
       if(array==null || array.length<0)
       {
           throw  new Exception("array not null");
       }

       if(begin<0 || begin>array.length)
       {
           throw new Exception("begin erry");
       }

       if(end<0 || end>array.length)
       {
           throw  new Exception("end erry");
       }

       if(begin>end)
       {
           throw  new Exception("begin>end");
       }


       int[] temparry= new int[end-begin+1];

        for(int i=0;i<array.length;i++){
         if(i>=begin && i<=end){
             temparry[i-(begin)]=array[i];
         }
        }

        temparry= reverseArray2(temparry);



        for(int i=0;i<array.length;i++){
            if(i>=begin && i<=end){
               array[i]= temparry[i-(begin)];
            }
        }

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }


//        1 2 3 4 5 6
//        1 2 6 5 4 3

    }

    private static int[] reverseArray2(int[] Array) {
        int[] new_array = new int[Array.length];
        for (int i = 0; i < Array.length; i++) {
            // 反转后数组的第一个元素等于源数组的最后一个元素：
            new_array[i] = Array[Array.length - i - 1];
        }
        return new_array;
    }

}
