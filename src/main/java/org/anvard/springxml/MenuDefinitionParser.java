package org.anvard.springxml;

import java.util.List;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

public class MenuDefinitionParser extends AbstractBeanDefinitionParser {

	@Override
	protected AbstractBeanDefinition parseInternal(Element element,
			ParserContext context) {

		BeanDefinitionBuilder builder = parseItem(element);

		List<Element> childElements = DomUtils.getChildElementsByTagName(
				element, "menu");

		if (null != childElements && childElements.size() > 0) {
			ManagedList<AbstractBeanDefinition> children = new ManagedList<>(
					childElements.size());

			for (Element child : childElements) {
				children.add(parseInternal(child, context));
			}
			builder.addPropertyValue("children", children);
		}

		return builder.getBeanDefinition();
	}

	private BeanDefinitionBuilder parseItem(Element element) {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder
				.rootBeanDefinition(MenuItem.class);

		String id = element.getAttribute("id");
		if (StringUtils.hasText(id)) {
			builder.addPropertyValue("id", id);
		}

		String title = element.getAttribute("title");
		if (StringUtils.hasText(title)) {
			builder.addPropertyValue("title", title);
		}

		String listener = element.getAttribute("listener");
		if (StringUtils.hasText(listener)) {
			builder.addPropertyReference("listener", listener);
		}

		return builder;
	}

}
