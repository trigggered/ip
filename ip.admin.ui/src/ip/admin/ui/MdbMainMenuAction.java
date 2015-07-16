package ip.admin.ui;

import ip.admin.ui.view.EViewIdent;
import ip.admin.ui.view.ViewFactory;
import mdb.core.ui.client.view.IView;
import mdb.core.ui.client.view.components.menu.mdb.IMdbMainMenuAction;

public class MdbMainMenuAction implements IMdbMainMenuAction {

	static IMdbMainMenuAction instance;
	
	@Override
	public IView getView(String menuAction) {
		EViewIdent viewMenuIdent  = EViewIdent.valueOf(menuAction);		
		IView view = ViewFactory.create(viewMenuIdent);

		return view;
	}

	/**
	 * 
	 */
	public static IMdbMainMenuAction instance() {
		if (instance == null) {
			instance = new MdbMainMenuAction();
		}
		return instance;
		
	}
}
