package io.erudev.mini.spring.context;

import io.erudev.mini.spring.beans.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 14:53
 */
public class ClassPathXmlApplicationContext {

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();

    private Map<String, Object> singletons = new HashMap<>();

    public ClassPathXmlApplicationContext(String fileName) {
        this.readXml(fileName);
        this.instanceBeans();
    }

    private void readXml(String fileName) {
        SAXReader reader = new SAXReader();
        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
            Document document = reader.read(xmlPath);
            Element root = document.getRootElement();
            for (Element element : (List<Element>) root.elements()) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("className");
                BeanDefinition beanDefinition = new BeanDefinition(id, className);
                beanDefinitions.add(beanDefinition);
            }
        } catch (Exception ignored) {

        }
    }

    private void instanceBeans() {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                singletons.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (Exception ignored) {

            }
        }
    }

    public Object getBean(String id) {
        return singletons.get(id);
    }
}
