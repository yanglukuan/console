package com.company.stream;

import com.company.model.PersonModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yanglk on 2017/7/21.
 */
public class StreamTest {

    public static void listTest() {
        Integer[] listNu = {1, 2, 3, 4};

        List<Integer> list = Arrays.asList(listNu);

        list.stream().forEach(m -> System.out.println(m));


        List<PersonModel> personModels = new ArrayList<>();
        PersonModel model = new PersonModel();
        model.setAge(2);
        model.setId(2);
        model.setName("测试2");
        personModels.add(model);

        PersonModel model1 = new PersonModel();
        model1.setAge(1);
        model1.setId(1);
        model1.setName("测试1");
        personModels.add(model1);

        PersonModel model3 = new PersonModel();
        model3.setAge(3);
        model3.setId(3);
        model3.setName("a");

        personModels.add(model3);


        //list排序
        personModels.sort(Comparator.comparing(PersonModel::getId));

        //stream
        personModels.stream().sorted(Comparator.comparing(PersonModel::getId))
                .filter(m -> m.getId().equals(1));//筛选  对流排序  不影响list

        personModels.stream().sorted(Comparator.comparing(PersonModel::getId)
                .reversed());//倒序


        Arrays.stream(listNu).filter(m -> m % 2 == 0).forEach(System.out::println);//筛选

        personModels.stream().filter(m -> m.getId().equals(1)).findFirst();//返回第一个 跟在filter后面  Optional 类型  避免空指针

        personModels.stream().filter(m -> m.getId().equals(1)).findAny();//返回任意一个 不一定是第一个 跟在filter后面  Optional 类型  避免空指针

        boolean re= personModels.stream().anyMatch(m->m.getId()>3);//是否至少存在一个满足条件的值

        personModels.stream().allMatch(m->m.getId()>3);//是否全部满足

        personModels.stream().noneMatch(m->m.getId()>3);//是否全部不满足

        personModels.stream().peek(m -> System.out.println(m.getName())).collect(Collectors.toList());//peek 遍历 返回stream

        Integer intmax = Arrays.stream(listNu).max(Integer::compare).get();//筛选  取最大

        Integer intmaxid = personModels.stream().max(Comparator.comparing(PersonModel::getId)).get().getId(); //筛选 取属性最大

        List<PersonModel> mo = personModels.stream().map(m -> m).limit(3).skip(2).collect(Collectors.toList());//limit 前n个元素  skip 扔掉前n个元素

        String str = Stream.of("a", "c", "b").reduce("", String::concat);//reduce

        String strr = Stream.of("a", "c", "b").map(String::toUpperCase).reduce("",String::concat);//大小写转换

        personModels.stream().map(m->m.getName().toUpperCase()).reduce("",String::concat);//取列表中每个元素的name 转成大写 并输出为字符串

        String ss = personModels.stream().map(m -> m.getName()).collect(Collectors.joining(","));


        //termimal 终端操作 不返回stream    orEach、 forEachOrdered、 toArray、 reduce、 collect、
        // min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator

        //Intermediate 中间操作  返回stream
        // map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered


        //Stream 转换为 list
        // stream.collect(Collectors.toList()

        //forEach(m->System.out.println(m.getName()));

    }


    public static void funcTest(Function<Integer, Integer> function, int s) {
        System.out.print(function.apply(s));

    }


    public static void funcTest() {
        Function<Integer, Integer> fun = x -> x + 1;//一般函数 参数/返回值
        int s = fun.apply(10);

        funcTest(m -> m * m, 10);

        Predicate<Integer> pre = x -> x > 0;// 谓词函数 参数/返回boolean
        boolean re = pre.test(-1);


        Consumer<Integer> consumer = m -> System.out.print(m);//消费者函数 参数/没有返回值
        consumer.accept(10);


        Supplier<Integer> supplier = () -> 1;//无参数  只有返回值
        supplier.get();

    }


    /**
     * 函数式接口作为参数
     *
     * @param in
     * @param fun
     */
    public static void fun(Integer in, FlInterface fun) {
        fun.run(in);
    }

    public static void main(String[] args) {
        listTest();
        // funcTest();

        /**
         * 调用函数式接口
         */
//        fun(200,m->{
//          System.out.print(m=m*m);
//        });
    }


}
