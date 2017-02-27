package ru.job4j.Test;

/**
 * Created by Katy on 27.02.2017.
 */
public class Main {

    public static void main(String[] args) {

        BaseClass base = new BaseClass();
        DerivedClass derive = new DerivedClass();

        System.out.println(base.getNumber_base());
        System.out.println(derive.getNumber_derived()+derive.getNumber_base());
        derive.write();

        System.out.println(((BaseClass) derive).getNumber_base());;
        derive.write();
    }
}
