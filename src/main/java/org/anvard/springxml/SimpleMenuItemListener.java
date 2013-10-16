package org.anvard.springxml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleMenuItemListener implements MenuItemListener {

	private static final Log LOG = LogFactory.getLog(SimpleMenuItemListener.class);
	
	@Override
	public void itemSelected(String id) {
		LOG.info("Menu item selected: " + id);
	}

}
