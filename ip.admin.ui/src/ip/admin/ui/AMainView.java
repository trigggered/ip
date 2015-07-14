/**
 * 
 */
package ip.admin.ui;

import java.util.logging.Level;
import java.util.logging.Logger;


import mdb.core.ui.client.view.IMainView;
import mdb.core.ui.client.view.IView;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

/**
 * @author azhuk
 * Creation date: Jul 15, 2015
 *
 */
public class AMainView extends UI implements  IMainView {
	private static final Logger _logger = Logger.getLogger(AMainView.class
			.getName());

	
	   private TabSheet _mainTabSet; 

	
	@Override
	protected void init(VaadinRequest request) {
		
		_mainTabSet = new TabSheet();
		_mainTabSet.setWidth("100%");
		_mainTabSet.setHeight("100%");
		
		
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		createMenu(); 
		
		
		Tab tab = _mainTabSet.addTab(new VerticalLayout(), "Main Window");
		tab.setClosable(true);
		
		
		layout.addComponent(_mainTabSet);
	}
	
	protected void createMenu() {
		MenuBar mainMenu = new MenuBar();
		Command comand = new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				
				
				Tab tab = _mainTabSet.addTab(new VerticalLayout(),  "Tab "+_mainTabSet.getComponentCount()+1);
				tab.setClosable(true);
			}
		};
		mainMenu.addItem("Open", comand);
		
		Layout mainLayout = (Layout) getContent();
		mainLayout.addComponent(mainMenu);
	}
	
	
	 
	    public void openViewInTab (IView view) {
	    	if(view == null) {
	    		return;
	    	}
	    	
	    	if ( view.isSingleInstance())  {
	    		Tab existTab = checkExistView(view);
	    		if ( existTab != null) {
	    			
	    			String tabId = existTab.getID(); 
	    			if (_mapView.containsKey(tabId) )  {
						IView existView =_mapView.get(tabId);
						if (existView!= null) {
							existView.redraw();
						}
	    			}
	    			_mainTabSet.selectTab(existTab);
	    			view = null;
	    			return;
	    		}
	    	}
	    	
	    	view.initialize();
	    	view.setMainView(this);
	    	Tab tab = new Tab();
	        tab.setContextMenu(getTabContextMenu());        
	        tab.setTitle(view.getCaption());        
	        tab.setPane(view.getCanvas() );
	        
	        _mapView.put(tab.getID(), view);
	        //tab.setAttribute(property, value);
	        tab.setCanClose(true);
	        //view.setWindow()
	        _logger.info("Tab icon ="+view.getImgCaption());
	        if ( view.getImgCaption()!=null && !view.getImgCaption().isEmpty() ) {
	        	tab.setIcon(view.getImgCaption());
	        	
	        }
	        view.setOwnerWindow(tab);
	        _mainTabSet.addTab(tab);
	        _logger.info("Tab icon ="+tab.getIcon());
	        _mainTabSet.selectTab(tab);        
	    }

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#getImgCaption()
		 */
		@Override
		public String getImgCaption() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#setImgCaption(java.lang.String)
		 */
		@Override
		public void setImgCaption(String value) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#getCanvas()
		 */
		@Override
		public Canvas getCanvas() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#initialize()
		 */
		@Override
		public void initialize() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#setMainView(mdb.core.ui.client.view.IMainView)
		 */
		@Override
		public void setMainView(IMainView mainView) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#getMainView()
		 */
		@Override
		public IMainView getMainView() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#addCustomProperty(java.lang.String, java.lang.Object)
		 */
		@Override
		public void addCustomProperty(String name, Object value) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#getCustomProperty(java.lang.String)
		 */
		@Override
		public Object getCustomProperty(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#setOwnerWindow(mdb.core.ui.client.view.Tab)
		 */
		@Override
		public void setOwnerWindow(mdb.core.ui.client.view.Tab tab) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#getOwnerWindow()
		 */
		@Override
		public mdb.core.ui.client.view.Tab getOwnerWindow() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#IsCanClose(mdb.core.ui.client.view.BooleanCallback)
		 */
		@Override
		public void IsCanClose(BooleanCallback callback) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#redraw()
		 */
		@Override
		public void redraw() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#setCanEdit(boolean)
		 */
		@Override
		public void setCanEdit(boolean value) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#isCanEdit()
		 */
		@Override
		public boolean isCanEdit() {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#setViewContainerID(java.lang.String)
		 */
		@Override
		public void setViewContainerID(String id) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#getViewContainerID()
		 */
		@Override
		public String getViewContainerID() {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IView#print()
		 */
		@Override
		public void print() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.ISingleInstanceOnly#setSingleInstance(boolean)
		 */
		@Override
		public void setSingleInstance(boolean vlue) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.ISingleInstanceOnly#isSingleInstance()
		 */
		@Override
		public boolean isSingleInstance() {
			// TODO Auto-generated method stub
			return false;
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
		 */
		@Override
		public void onModuleLoad() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IManagingView#closeCurrentTab()
		 */
		@Override
		public void closeCurrentTab() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IManagingView#closeAllTab()
		 */
		@Override
		public void closeAllTab() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IManagingView#closeAllTabButCurrent()
		 */
		@Override
		public void closeAllTabButCurrent() {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see mdb.core.ui.client.view.IMainView#getAppId()
		 */
		@Override
		public int getAppId() {

			return 0;
		}
}
