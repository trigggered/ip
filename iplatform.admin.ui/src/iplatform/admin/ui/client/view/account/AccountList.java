/**
 * 
 */
package iplatform.admin.ui.client.view.account;

import iplatform.admin.ui.client.resources.locales.Captions;
import iplatform.admin.ui.client.view.account.card.AccCardImpl;
import iplatform.admin.ui.client.view.client.card.ClientCardImpl;
import iplatform.admin.ui.shared.MdbEntityConst;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.smartgwt.client.data.Record;

import mdb.core.ui.client.events.IDataEditHandler;
import mdb.core.ui.client.view.data.grid.GridView;

/**
 * @author azhuk
 * Creation date: Jul 9, 2015
 *
 */
public class AccountList extends GridView {
	private static final Logger _logger = Logger.getLogger(AccountList.class
			.getName());
	
	public AccountList() {
		setMainEntityId(MdbEntityConst.ACCOUNTS);
		setCaption(Captions.Accounts);
		
		IDataEditHandler openCardHandler=new IDataEditHandler() {
			
			@Override
			public void onEdit(Record record) {
				_logger.info("Try open account card = "+record.getAttribute("ID"));
				AccCardImpl.OpenById(record.getAttribute("ID"));
				
			}
		};

		addViewEvent(openCardHandler);
		
		addEditEvent(openCardHandler);
	}
}
