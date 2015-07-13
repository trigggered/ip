package iplatform.admin.ui.client.view.main;

import iplatform.admin.ui.client.commons.EViewIdent;
import iplatform.admin.ui.client.communication.rpc.MyAuthService;
import iplatform.admin.ui.client.communication.rpc.MyAuthServiceAsync;
import iplatform.admin.ui.client.communication.rpc.mdbgw.MdbGWQueueProcessor;
import iplatform.admin.ui.client.view.ViewFactory;
import iplatform.admin.ui.shared.Application;
import iplatform.admin.ui.shared.MdbEntityConst;

import java.util.LinkedHashMap;
import java.util.logging.Logger;

import mdb.core.shared.auth.AuthUser;
import mdb.core.shared.data.Params;
import mdb.core.ui.client.app.AppController;
import mdb.core.ui.client.communication.impl.GatewayQueue;
import mdb.core.ui.client.view.AMainView;
import mdb.core.ui.client.view.components.menu.IMenu;
import mdb.core.ui.client.view.components.menu.IMenuContainer;
import mdb.core.ui.client.view.components.menu.mdb.IMdbMainMenuAction;
import mdb.core.ui.client.view.components.menu.mdb.MdbMainMenu;
import mdb.core.ui.client.view.components.menu.mdb.MdbMainMenuCommand;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;


public class Main extends AMainView   {
	

	private static  MyAuthServiceAsync _asyncAuthService = GWT.create(MyAuthService.class);
		
    private static final Logger _logger = Logger.getLogger(Main.class.getName());    
    
    
	@Override
    protected void registerGatewayQueue() {		
		GatewayQueue.instance().setProcessor(new MdbGWQueueProcessor());
	}

	@Override
	public void onModuleLoad() {
		super.onModuleLoad();	
		_logger.info("Start onModuleLoad");
		//SignXWrapper.regSignControlAsHTML();
		//SignAppletWrapper.regSignControlAsHTML();
		
		/*Яна сказала не надо, без подписи 21.05.2015*/		
		//SignControlWrapper.getSignControl().regSignControlAsHTML();		
		retrieveUserInfoFromServer();		 
	}
	
	@Override
	protected void registerDynamicMenu() {
		
		Params params = new Params();
		params.add("ID_USER",String.valueOf(AppController.getInstance().getCurrentUser().getId()) );
		params.add("ID_APP",String.valueOf(getAppId()));
		
		IMenu mainMenu = new MdbMainMenu(MdbEntityConst.MAIN_MENU_ID ,getAppId(), getMenuContainer(), 
				new MdbMainMenuCommand(this, getMdbMainMenuActionImpl() ), params );
		mainMenu.setPosition(0);		
	}
	
	
	@Override
	protected void createMenu() {		
		IMenuContainer container =  getMenuContainer();				
		if (container != null) {
			loadTopBarLogo();				
		}	
	}
	
		
	protected void retrieveUserInfoFromServer() {
		
		_logger.info("Try Retrieve Auth UserInfo ");
		_asyncAuthService.retrieveUserInfo(new AsyncCallback<AuthUser>() {
			
				@Override
				public void onSuccess(AuthUser result) {
					_logger.info("Success Retrieve Auth UserInfo. User id is ="+result.getId() +" user roles:"+result.getRoles().toString());					
					AppController.getInstance().setCurrentUser(result);					
					AppController.getInstance().initialAppContext();
					
					registerDynamicMenu();
					callRequestData();										
				}
				
				@Override
				public void onFailure(Throwable caught) {
					_logger.severe("Remote Procedure Call - Failure:" + caught.getMessage());
				}
		});
	}


	
	@Override
	public void bindDataComponents() {
		
		openViewInTab(
		 			ViewFactory.create(EViewIdent.Home));
				
		super.bindDataComponents();
	}
	
	
	

	
	@Override
	protected void setupEvents() {
		AppController.setInstance(new AppController());
		AppController.getInstance().setMainView(this);
		
		History.addValueChangeHandler(AppController.getInstance().getValueChangeHandler());				
		History.fireCurrentHistoryState();
	}
	
	
	@Override
	public int getAppId() {
		return Application.APPLICATION_ID;
	}


	@Override
	protected IMdbMainMenuAction getMdbMainMenuActionImpl() {
		return new MdbMainMenuAction();
	}


	@Override
	public void prepareRequestData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loadTopBarLogo() {
		Img imgLogo = new Img("ukrsib/rp_logo_ua.png", 364,58);
		getMenuContainer().addMemberToContainer(imgLogo);		
	}
	
	 protected String  getCurrentSkinName() {
	    	return "Graphite";
	 }
	 

	 
	 @Override
	 protected DynamicForm  getSkinControlComponent() {
		 DynamicForm   toReturn = super.getSkinControlComponent();
		 toReturn.setVisible(true);
		 return toReturn;
	 }
	
}
