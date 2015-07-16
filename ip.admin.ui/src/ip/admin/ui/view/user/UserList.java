/**
 * 
 */
package ip.admin.ui.view.user;


import ip.admin.ui.MdbEntityConst;
import ip.admin.ui.recources.locales.Captions;

import java.util.logging.Logger;

import mdb.core.vaadin.ui.view.data.TableView;

/**
 * @author azhuk
 * Creation date: Aug 7, 2015
 *
 */
public class UserList extends TableView {
	private static final Logger _logger = Logger.getLogger(UserList.class
			.getName());
	
	public UserList() {
		setMainEntityId(MdbEntityConst.USERS);
		setCaption(Captions.USERS);
	}
}
