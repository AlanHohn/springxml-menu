package org.anvard.springxml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MenuNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("menu", new MenuDefinitionParser());
	}

}
