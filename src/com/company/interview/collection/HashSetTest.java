package com.company.interview.collection;

import com.company.model.PersonModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yanglk on 2017/9/8.
 */
public class HashSetTest {

    public static void main(String[] args)
    {
        Set<String>  set=new HashSet<>();

        set.add("1");

        set.forEach(m->System.out.println(m));
        for (String s:set)
        {
            System.out.println(s);
        }


        PersonModel model =new PersonModel();

        model.setId(1);
        model.setName("1");

        PersonModel model2 =new PersonModel();

        model2.setId(1);
        model2.setName("1");


        Set<PersonModel> ss=new HashSet<>();
        List<PersonModel>  ll=new ArrayList<>();

        ss.add(model);
        ss.add(model2);

        ll.add(model);
        ll.add(model2);


        System.out.print("SS"+ss.size()+"ll"+ll.size()+ model.hashCode()+ model2.hashCode()+" "+(model2==model));

    }

}
