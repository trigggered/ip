/**
 * 
 */
package ip.admin.ui.view;



import ip.admin.ui.MdbEntityConst;
import ip.admin.ui.recources.locales.Captions;
import ip.admin.ui.view.account.AccountList;
import ip.admin.ui.view.client.ClientList;
import ip.admin.ui.view.client.FindClient;
import ip.admin.ui.view.user.UserList;

import java.util.List;
import java.util.logging.Logger;

import com.vaadin.data.Item;

import mdb.core.ui.client.events.ICallbackEvent;
import mdb.core.ui.client.view.IView;
import mdb.core.vaadin.ui.view.data.GridView;
import mdb.core.vaadin.ui.view.data.TableView;
import mdb.core.vaadin.ui.view.dialogs.FormDialog;
import mdb.core.vaadin.ui.view.dialogs.SelectDialog;

/**
 * @author azhuk
 * Creation date: Jul 1, 2015
 *
 */
public class ViewFactory {
	private static final Logger _logger = Logger.getLogger(ViewFactory.class
			.getName());

	/**
	 * @param home
	 * @return
	 */
	public static IView create(EViewIdent viewIdent) {
		
		switch (viewIdent) {
		case Home:
			return new FormDialog();
		case Search:
			return new SelectDialog(new ICallbackEvent<List<Item>>() {
				
				@Override
				public void doWork(List<Item> data) {
					 
					
				}
			});
		case DicBranches:
			return  createDicGrid (MdbEntityConst.BRANCHES,Captions.BRANCHES );
		case DicCurrency:
			return  createDicGrid (MdbEntityConst.CURRENCY,Captions.CURRENCY );
		case DicUaBanks:
			return  createDicGrid (MdbEntityConst.UA_BANKS,Captions.UA_BANKS );
		case DicSecProfiles:
			return  createDicGrid (MdbEntityConst.DIC_SEC_PROFILES,Captions.DIC_SEC_PROFILES );		
		case FindClient: {
			return new FindClient();						
		}
		case ClientListIndividual: {
			return new ClientList();						
		}
		case AccountList:
			{
				IView view  = new AccountList();				
				return view;
			}
		
		case Users:
			{
				IView view  = new UserList();				
				return view;
			}
		}
		return null;
	}

	/**
	 * @param dicSecProfiles2 
	 * @param dicSecProfiles 
	 * @param viewIdent
	 * @return
	 */
	private static GridView createDicGrid(int entityId, String caption) {
		GridView view = new GridView();
		view.setMainEntityId(entityId);
		view.setCaption(caption);
		return view;
	}

	/**
	 * @param viewIdent
	 * @param dictionaryGridView
	 */
	public static void viewInitialize(EViewIdent viewIdent,
			IView dictionaryGridView) {
		// TODO Auto-generated method stub
		
	}
}
