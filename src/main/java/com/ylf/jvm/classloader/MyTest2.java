package com.ylf.jvm.classloader;

/**
 * 常量（final修饰）在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会出发定义常量的类的初始化
 * 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
 * 甚至，编译后我们可以将MyParent2的class文件删除
 *
 * 助记符：
 * ldc表示将int，float或是String类型的常量值从常量池推送到栈顶
 * bipush表示将单字节（-128 - 127）的常量值推送到栈顶
 * sipush表示将一个短整型（-32768 - 32767）常量值推送至栈顶
 * iconst_1表示将int类型的数字1推送到栈顶（iconst_1 - iconst_5）
 */
public class MyTest2 {

    public static void main(String[] args) {
        // 结果为hello world，不初始化MyParent2
        System.out.println(MyParent2.str);
        System.out.println(MyParent2.s);
        System.out.println(MyParent2.i);
        System.out.println(MyParent2.m);
    }
}

class MyParent2 {
    public static final String str = "hello world";

    public static final short s = 7;

    public static final int i = 128;

    public static final int m = 5;

    static {
        System.out.println("MyParent2 static block");
    }
}
