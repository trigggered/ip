package ip.admin.ui.view;


import ip.admin.ui.Application;
import ip.admin.ui.MdbMainMenuAction;

import java.util.logging.Logger;

import mdb.core.shared.auth.AuthUser;
import mdb.core.shared.auth.IUserInfo;
import mdb.core.shared.data.Params;
import mdb.core.ui.client.app.AppController;
import mdb.core.ui.client.communication.impl.GatewayQueue;
import mdb.core.ui.client.view.IView;
import mdb.core.ui.client.view.components.menu.IMenu;
import mdb.core.ui.client.view.components.menu.mdb.IMdbMainMenuAction;
import mdb.core.ui.client.view.components.menu.mdb.MdbMainMenu;
import mdb.core.ui.client.view.components.menu.mdb.MdbMainMenuCommand;
import mdb.core.ui.client.view.data.IDataView;
import mdb.core.ui.client.view.dialogs.message.Dialogs;
import mdb.core.vaadin.ui.communication.mdbgw.MdbGWQueueProcessor;
import mdb.core.vaadin.ui.data.VaadinDataWraper;
import mdb.core.vaadin.ui.view.AMainView;
import mdb.core.vaadin.ui.view.dialogs.messages.MessageDialogs;


public class MainView extends AMainView  {

	private static final Logger _logger = Logger.getLogger(MainView.class.getName());

	private static final int MAIN_MENU_ID = 5291;

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.IMainView#getAppId()
	 */
	@Override
	public int getAppId() {
		return Application.APPLICATION_ID;
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.vaadin.client.view.AMainView#registerGatewayQueue()
	 */
	@Override
	protected void registerGatewayQueue() {	
		
		GatewayQueue.instance().setProcessor(new MdbGWQueueProcessor());
		Dialogs.regiserMessageDialogs(new MessageDialogs());
		
	}
	
	@Override
	protected void registerDynamicMenu() {		
		Params params = new Params();
		params.add("ID_USER",String.valueOf(AppController.getInstance().getCurrentUser().getId()) );
		params.add("ID_APP",String.valueOf(getAppId()));
		
		IMenu mainMenu = new MdbMainMenu(new VaadinDataWraper() ,MAIN_MENU_ID ,
				getAppId(), getMenuContainer(), 
				new MdbMainMenuCommand(this, getMdbMainMenuAction() ), params );
		mainMenu.setPosition(0);		
	}

	
	@Override
	protected void retrieveUserInfoFromServer() {		
		_logger.info("Try Retrieve Auth UserInfo ");
		
		IUserInfo user  =new AuthUser();
		user.setId(90730);
		
		AppController.getInstance().setCurrentUser(user);					
		AppController.getInstance().initialAppContext();		
		
	}
	
	/* (non-Javadoc)
	 * @see mdb.core.ui.vaadin.client.view.AMainView#loadTopBarLogo()
	 */
	@Override
	protected void loadTopBarLogo() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.vaadin.client.view.AMainView#getMdbMainMenuActionImpl()
	 */
	@Override
	protected IMdbMainMenuAction getMdbMainMenuAction() {
		return MdbMainMenuAction.instance();		
		
	}

	
	/* (non-Javadoc)
	 * @see mdb.core.vaadin.ui.view.AMainView#getDefaultView()
	 */
	@Override
	protected IView getDefaultView() {		
		return ViewFactory.create(EViewIdent.DicBranches);
	}

	
	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.ADataView#clearEvents(mdb.core.ui.client.view.data.IDataView)
	 */
	@Override
	protected void clearEvents(IDataView<Object> view) {
		// TODO Auto-generated method stub		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.ABaseView#initSize()
	 */
	@Override
	protected void initSize() {
		// TODO Auto-generated method stub		
	}
	
	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.IDataView#isSelectedRecord()
	 */
	@Override
	public boolean isSelectedRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.IDataView#callDeleteEvent()
	 */
	@Override
	public void callDeleteEvent() {
		// TODO Auto-generated method stub		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.IDataView#getSelectedRecordJSON()
	 */
	@Override
	public String getSelectedRecordJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.ADataView#prepareRequestData()
	 */
	@Override
	public void prepareRequestData() {
		// TODO Auto-generated method stub		
	}

}