package io.erudev.mini.spring.test;

import io.erudev.mini.spring.beans.NoSuchBeanDefinitionException;
import io.erudev.mini.spring.context.ClassPathXmlApplicationContext;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 15:11
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchBeanDefinitionException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService service = (AService) ctx.getBean("aservice");
        service.sayHello();
    }
}
