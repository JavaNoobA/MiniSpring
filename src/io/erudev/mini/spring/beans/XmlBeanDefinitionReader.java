package io.erudev.mini.spring.beans;

import io.erudev.mini.spring.core.Resource;
import org.dom4j.Element;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 16:15
 */
public class XmlBeanDefinitionReader {

    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanName = element.attributeValue("id");
            String className = element.attributeValue("class");
            beanFactory.registerBeanDefinition(new BeanDefinition(beanName, className));
        }
    }
}
