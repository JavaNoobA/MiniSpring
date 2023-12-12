package io.erudev.mini.spring.context;

import io.erudev.mini.spring.beans.*;
import io.erudev.mini.spring.core.ClassPathXmlResource;
import io.erudev.mini.spring.core.Resource;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 14:53
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory bf = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = bf;
    }

    public Object getBean(String id) throws NoSuchBeanDefinitionException {
        return beanFactory.getBean(id);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition bf) {
        beanFactory.registerBeanDefinition(bf);
    }
}
