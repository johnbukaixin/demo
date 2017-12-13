package com.peach.demo.thread;

class A{
    public String show(D d){return ("AD");}
    public String show(A a){return ("AA");}
}

class B extends A{
    public String show(B b){return ("BB");}
    public String show(A a){return ("BA");}
}

class C extends B{}

class D extends B{}

public class Test{

    public static void main(String[] args) {
//        A a = new A();
//        B b = new B();
//        C c = new C();
//        D d = new D();
//        System.out.println(a.show(b)+"-"+a.show(c)+"-"+a.show(d)+"-"+b.show(a)+"-"+b.show(c)+"-"+b.show(d));
        float foo = 1;

        float doo2 = 0x1234;
        try {
            System.out.println("try-");
            int[] a = new int[0];
            a[0] = 1;
            System.out.println(a[0]+"-");
            return;
        } catch (Exception e) {
            System.out.println("catch-");
        } finally {
            System.out.println("finally");
        }
    }
}