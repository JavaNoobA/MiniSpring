package io.erudev.mini.spring.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 16:07
 */
public class SimpleBeanFactory implements BeanFactory {

    private final List<BeanDefinition> beanDefinitionList = new ArrayList<>();

    private final List<String> beanNameList = new ArrayList<>();

    private final Map<String, Object> singletons = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws NoSuchBeanDefinitionException {
        Object singleton = singletons.get(beanName);
        if (singleton == null) {
            int i = beanNameList.indexOf(beanName);
            if (i == -1) {
                throw new NoSuchBeanDefinitionException();
            } else {
                BeanDefinition bd = beanDefinitionList.get(i);
                try {
                    singleton = Class.forName(bd.getClassName()).newInstance();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            singletons.put(beanName, singleton);
        }
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition bf) {
        beanNameList.add(bf.getId());
        beanDefinitionList.add(bf);
    }
}
