package com.jlch.webauto.dboperate;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParserXml {

    public List parser3Xml(String fileName) {
        File inputXml = new File(fileName);    
        List list=new ArrayList();                
        int count = 1;
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            Element employees = document.getRootElement();
            for (Iterator i = employees.elementIterator(); i.hasNext();) {
                Element employee = (Element) i.next();
                Map map = new HashMap();
                Map tempMap = new HashMap();
                for (Iterator j = employee.elementIterator(); j.hasNext();) {
                    Element node = (Element) j.next();                    
                    tempMap.put(node.getName(), node.getText());                    
                }
                map.put(employee.getName(), tempMap);
                list.add(map);
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
     

}