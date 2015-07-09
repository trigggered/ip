/**
 * 
 */
package iplatform.admin.ui.client.view.client;

import iplatform.admin.ui.client.resources.locales.Captions;
import iplatform.admin.ui.client.view.client.card.ClientCardImpl;
import iplatform.admin.ui.shared.MdbEntityConst;

import java.util.logging.Logger;

import mdb.core.ui.client.events.IDataEditHandler;
import mdb.core.ui.client.view.data.grid.GridView;

import com.smartgwt.client.data.Record;

/**
 * @author azhuk
 * Creation date: Jul 9, 2015
 *
 */
public class ClientList extends GridView {
	private static final Logger _logger = Logger.getLogger(ClientList.class
			.getName());
	
	
	public ClientList () {
		setMainEntityId(MdbEntityConst.ClI_INDIVIDUAL);
		setCaption(Captions.CLI_INDIVIDUAL);
		
		IDataEditHandler openCardHandler=new IDataEditHandler() {
			
			@Override
			public void onEdit(Record record) {
				_logger.info("Try open client card = "+record.getAttribute("ID"));
				ClientCardImpl.OpenById(record.getAttribute("ID"));
				
			}
		};

		addViewEvent(openCardHandler);
		
		addEditEvent(openCardHandler);
	}
}
