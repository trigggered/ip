/**
 * 
 */
package iplatform.admin.ui.client.view;

import iplatform.admin.ui.client.commons.EViewIdent;
import iplatform.admin.ui.client.resources.locales.Captions;
import iplatform.admin.ui.client.view.account.AccountList;
import iplatform.admin.ui.client.view.client.ClientList;
import iplatform.admin.ui.client.view.dictionary.DictionaryGridView;
import iplatform.admin.ui.client.view.dictionary.DictionaryViewFactory;
import iplatform.admin.ui.client.view.users.UserList;
import iplatform.admin.ui.shared.MdbEntityConst;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.icu.text.BreakIterator;

import mdb.core.ui.client.view.IView;
import mdb.core.ui.client.view.data.IDataView;

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
		case DicBranches:
		case DicCurrency:
		case DicUaBanks:
				return DictionaryViewFactory.create(viewIdent);
		case ClientListIndividual: {
			IDataView view  = new ClientList();
			view.setMainEntityId(MdbEntityConst.ClI_INDIVIDUAL);
			view.setCaption(Captions.CLI_INDIVIDUAL);
			return view;
		}
		case AccountList:
			{
				IDataView view  = new AccountList();
				view.setMainEntityId(MdbEntityConst.ACC_LIST);
				view.setCaption(Captions.ACCOUNTS);
				return view;
			}
		
		case Users:
			{
				IDataView view  = new UserList();
				view.setMainEntityId(MdbEntityConst.USERS);
				view.setCaption(Captions.USERS);
				return view;
			}
		}
		return null;
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
