package io.erudev.mini.spring.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * @author pengfei.zhao
 * @date 2023/12/12 15:58
 */
public class ClassPathXmlResource implements Resource {

    Document document;

    Element rootElement;

    Iterator<Element> elementIterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader reader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        try {
            document = reader.read(xmlPath);
            rootElement = document.getRootElement();
            elementIterator = (Iterator<Element>) rootElement.elementIterator();
        } catch (Exception ignored) {

        }
    }

    @Override
    public boolean hasNext() {
        return elementIterator.hasNext();
    }

    @Override
    public Object next() {
        return elementIterator.next();
    }
}
