package ip.admin.ui;

import ip.admin.ui.event.UiEventBus;

import java.util.Locale;

import javax.servlet.annotation.WebServlet;


import mdb.core.shared.auth.AuthUser;
import mdb.core.shared.auth.IUserInfo;
import mdb.core.ui.client.app.AppController;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Page;
import com.vaadin.server.Page.BrowserWindowResizeEvent;
import com.vaadin.server.Page.BrowserWindowResizeListener;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import ip.admin.ui.event.UiEvent.BrowserResizeEvent;
import ip.admin.ui.event.UiEvent.CloseOpenWindowsEvent;
import ip.admin.ui.event.UiEvent.UserLoggedOutEvent;
import ip.admin.ui.event.UiEvent.UserLoginRequestedEvent;
import ip.admin.ui.view.LoginView;
import ip.admin.ui.view.MainView;

// @Theme("dashboard")

@Theme("tests-valo-dark")
@Title("iAdminUi")
@PreserveOnRefresh
public final class iAdminUI extends UI {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5126360036804227986L;
	

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = iAdminUI.class)
	public static class Servlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
	
    private final UiEventBus eventbus = new UiEventBus();

    @Override
    protected void init(final VaadinRequest request) {
        setLocale(Locale.US);
        setSizeFull();

        UiEventBus.register(this);
        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);

        updateContent();

        // Some views need to be aware of browser resize events so a
        // BrowserResizeEvent gets fired to the event bus on every occasion.
        Page.getCurrent().addBrowserWindowResizeListener(
                new BrowserWindowResizeListener() {
                    @Override
                    public void browserWindowResized(
                            final BrowserWindowResizeEvent event) {
                    	eventbus.post(new BrowserResizeEvent());
                    }
                });
    }

    /**
     * Updates the correct content for this UI based on the current user status.
     * If the user is logged in with appropriate privileges, main view is shown.
     * Otherwise login view is shown.
     */
    private void updateContent() {
    	IUserInfo user = (IUserInfo) VaadinSession.getCurrent().getAttribute(
    			IUserInfo.class.getName());
        if (user != null ) {
            // Authenticated user
        	MainView mainUI = new MainView();        	
            setContent(mainUI.getMainLayout());
            removeStyleName("loginview");
            //getNavigator().navigateTo(getNavigator().getState());
        } else {
            setContent(new LoginView());
            addStyleName("loginview");
        }
    }

    private IUserInfo authenticate (String name, String password) {
    	//return AppController.getInstance().getCurrentUser();
    	//return new  UserInfo(userName, credential, roleNames)
    	IUserInfo  toReturn = new AuthUser();
    	
    	toReturn.setId(90730);
		
		AppController.getInstance().setCurrentUser(toReturn);					
		AppController.getInstance().initialAppContext();		
		
    	return toReturn;
    }
    
    @Subscribe
    public void userLoginRequested(final UserLoginRequestedEvent event) {
    	IUserInfo user = authenticate(event.getUserName(), event.getPassword());
        VaadinSession.getCurrent().setAttribute(IUserInfo.class.getName(), user);
        updateContent();
    }

    @Subscribe
    public void userLoggedOut(final UserLoggedOutEvent event) {
        // When the user logs out, current VaadinSession gets closed and the
        // page gets reloaded on the login screen. Do notice the this doesn't
        // invalidate the current HttpSession.
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();
    }

    @Subscribe
    public void closeOpenWindows(final CloseOpenWindowsEvent event) {
        for (Window window : getWindows()) {
            window.close();
        }
    }


    public static UiEventBus getUiEventbus() {
        return ((iAdminUI) getCurrent()).eventbus;
    }
}
