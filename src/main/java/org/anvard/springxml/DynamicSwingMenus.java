package org.anvard.springxml;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DynamicSwingMenus {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/menuDefinition.xml");
		@SuppressWarnings("unchecked")
		List<MenuItem> toplevel = (List<MenuItem>) ctx.getBean("toplevel");
        JFrame mainFrame = new JFrame();
        JMenuBar menuBar = new JMenuBar();
        for (MenuItem item: toplevel) {
        	menuBar.add(item.build());
        }
        mainFrame.add(menuBar);
        mainFrame.pack();
        mainFrame.setVisible(true);
	}
}
