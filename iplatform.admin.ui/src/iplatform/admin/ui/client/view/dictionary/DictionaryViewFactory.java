package iplatform.admin.ui.client.view.dictionary;

import mdb.core.ui.client.view.data.IDataView;
import iplatform.admin.ui.client.commons.EViewIdent;
import iplatform.admin.ui.client.resources.locales.Captions;
import iplatform.admin.ui.shared.MdbEntityConst;

public class DictionaryViewFactory {
  
	public static IDataView create( EViewIdent viewIdent) {
		IDataView dictionary = null;
		int mainEntityId = 0;
		String captions = null;
		switch (viewIdent) {		
			case DicBranches:
				mainEntityId  = MdbEntityConst.BRANCHES;
				captions = Captions.BRANCHES;
				//dictionary = new DictionaryTreeView(viewIdent);
				dictionary = new DictionaryGridView(viewIdent);
				break;
			case DicCurrency:
				dictionary = new DictionaryGridView(viewIdent);
				mainEntityId  = MdbEntityConst.CURRENCY;
				captions = Captions.CURRENCY;
				break;
				
			case DicUaBanks:
				dictionary = new DictionaryGridView(viewIdent);
				mainEntityId  = MdbEntityConst.UA_BANKS;
				captions = Captions.UA_BANKS;
				break;	
		}				
		
		
		dictionary.setMainEntityId(mainEntityId);
		dictionary.setCaption(captions);
		return dictionary;
	  
  }
}
