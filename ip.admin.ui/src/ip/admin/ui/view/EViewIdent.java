/**
 * 
 */
package ip.admin.ui.view;

import mdb.core.ui.client.view.ABaseView;
import mdb.core.vaadin.ui.view.BaseView;
import mdb.core.vaadin.ui.view.data.TableView;
import ip.admin.ui.MdbEntityConst;
import ip.admin.ui.recources.locales.Captions;



/**
 * @author azhuk
 * Creation date: Jul 1, 2015
 *
 */
public enum EViewIdent {
	Home ,
	//DicCurrency ("DicCurrency", GridView.class, Captions.CURRENCY, MdbEntityConst.CURRENCY, true )
	DicCurrency, 
	DicBranches,
	DicUaBanks,
	DicSecProfiles,
	CliLegal,
	
	Search,
	AccountList,
	
	FindClient,
	
	ClientListIndividual,
	CliLeagal,
	Users,
	UserGuide
	 ;
	
/*
    private final String viewName;
    private final Class<? extends ABaseView> viewClass;
    private final String caption;
    
    private final int entityId;
    
    private final boolean stateful;
    
    
	private EViewIdent (
		final String viewName,
        final Class<? extends  ABaseView> viewClass, 
        final String caption,
        final int entityConst, 
        final boolean stateful ) {

		this.caption = caption;
	    this.viewName = viewName;
	    this.viewClass = viewClass;
	    this.stateful = stateful;
	    this.entityId = entityConst;
    
	}*/
}
