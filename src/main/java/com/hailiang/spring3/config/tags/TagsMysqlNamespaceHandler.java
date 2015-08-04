package com.hailiang.spring3.config.tags;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class TagsMysqlNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("client", new MysqlMapClientParser());
	}

}
