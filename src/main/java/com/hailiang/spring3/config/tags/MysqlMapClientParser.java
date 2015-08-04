package com.hailiang.spring3.config.tags;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class MysqlMapClientParser extends AbstractSimpleBeanDefinitionParser {

	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		super.doParse(element, parserContext, builder);
		
		// 从标签中取出相应的属性值
		String dbname = element.getAttribute("dbname");
		String datasouceip = element.getAttribute("datasouceip");
		String username = element.getAttribute("username");
		String password = element.getAttribute("password");
		String characterEncoding = element.getAttribute("characterEncoding");
		String configLocation = element.getAttribute("configLocation");
		
		System.out.println("dbname=" + dbname);
		System.out.println("datasouceip=" + datasouceip);
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		System.out.println("characterEncoding=" + characterEncoding);
		System.out.println("configLocation=" + configLocation);  
		
		builder.addPropertyValue("dbname123", dbname);
	}

	@Override
	protected Class<?> getBeanClass(Element element) {
		return DatasourceConfig.class;
	}

}
