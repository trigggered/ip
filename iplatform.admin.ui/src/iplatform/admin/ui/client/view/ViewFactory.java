/**
 * 
 */
package iplatform.admin.ui.client.view;

import iplatform.admin.ui.client.commons.EViewIdent;
import iplatform.admin.ui.client.resources.locales.Captions;
import iplatform.admin.ui.client.view.dictionary.DictionaryGridView;
import iplatform.admin.ui.client.view.dictionary.DictionaryViewFactory;
import iplatform.admin.ui.shared.MdbEntityConst;

import java.util.logging.Level;
import java.util.logging.Logger;

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
				return DictionaryViewFactory.create(viewIdent);
		case CliIndividual:
			IDataView view  = new DictionaryGridView(viewIdent);
			view.setMainEntityId(MdbEntityConst.ClI_INDIVIDUAL);
			view.setCaption(Captions.CLI_INDIVIDUAL);
			return view;
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
