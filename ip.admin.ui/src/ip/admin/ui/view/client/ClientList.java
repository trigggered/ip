/**
 * 
 */
package ip.admin.ui.view.client;

import ip.admin.ui.MdbEntityConst;
import ip.admin.ui.recources.locales.Captions;

import java.util.logging.Logger;

import com.vaadin.data.Item;

import mdb.core.ui.client.events.IDataEditHandler;
import mdb.core.vaadin.ui.data.IDataSource;
import mdb.core.vaadin.ui.view.data.GridView;
import mdb.core.vaadin.ui.view.data.TableView;

/**
 * @author azhuk
 * Creation date: Aug 7, 2015
 *
 */
public class ClientList extends GridView {
	private static final Logger _logger = Logger.getLogger(ClientList.class
			.getName());
	
	
			
	public ClientList () {
		setMainEntityId(MdbEntityConst.ClI_INDIVIDUAL);
		setCaption(Captions.CLI_INDIVIDUAL);

		addViewEvent(new IDataEditHandler<Object>() {
			
			@Override
			public void onEdit(Object record) {
				Item rec = (Item)record;
				
				ClientCard.OpenCard((IDataSource)getMainDataSource(),  rec);
				
			}
		});
		
	/*	IDataEditHandler<Record> openCardHandler=new IDataEditHandler<Record>() {
			
			@Override
			public void onEdit(Record record) {
				_logger.info("Try open client card = "+record.getAttribute("ID"));
				ClientCardImpl.OpenById(record.getAttribute("ID"));
				
			}
		};

		addViewEvent(openCardHandler);
		
		addEditEvent(openCardHandler);*/
	}
}
