package io.erudev.mini.spring.beans;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 16:05
 */
public interface BeanFactory {

    Object getBean(String id) throws NoSuchBeanDefinitionException;

    void registerBeanDefinition(BeanDefinition bf);
}
