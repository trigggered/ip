/**
 * 
 */
package ip.admin.ui.view.account;



import ip.admin.ui.MdbEntityConst;
import ip.admin.ui.recources.locales.Captions;

import java.util.logging.Level;
import java.util.logging.Logger;

import mdb.core.ui.client.events.IDataEditHandler;
import mdb.core.vaadin.ui.view.data.TableView;

/**
 * @author azhuk
 * Creation date: Aug 7, 2015
 *
 */
public class AccountList extends TableView {
	private static final Logger _logger = Logger.getLogger(AccountList.class
			.getName());
	
	public AccountList() {
		setMainEntityId(MdbEntityConst.ACCOUNTS);
		setCaption(Captions.Accounts);
		
/*		IDataEditHandler<Record> openCardHandler=new IDataEditHandler<Record>() {
			
			@Override
			public void onEdit(Record record) {
				_logger.info("Try open account card = "+record.getAttribute("ID"));
				AccCardImpl.OpenById(record.getAttribute("ID"));
				
			}
		};

		addViewEvent(openCardHandler);
		
		addEditEvent(openCardHandler);*/
	}
	
}
