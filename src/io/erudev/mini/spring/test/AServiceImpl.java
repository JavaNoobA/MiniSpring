package io.erudev.mini.spring.test;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 15:11
 */
public class AServiceImpl implements AService{
    @Override
    public void sayHello() {
        System.out.println("hello spring!");
    }
}
