/**
 * 
 */
package iplatform.admin.ui.client.view.client.card;

import iplatform.admin.ui.client.view.client.checkers.CheckClientExists;

import java.util.logging.Logger;

import mdb.core.ui.client.app.AppController;
import mdb.core.ui.client.data.checkers.IChecker;
import mdb.core.ui.client.view.data.IDataView;
import mdb.core.ui.client.view.data.card.ACard;
import mdb.core.ui.client.view.data.card.section.IDataSection.ESectionType;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;


/**
 * @author azhuk
 * Creation date: Jul 10, 2015
 *
 */
public class ClientCardImpl  extends ACard {
	private static final Logger _logger = Logger.getLogger(ClientCardImpl.class
			.getName());
	
	enum  EDataSection {
		Main,
		Accounts,
		Contact,
		Addreses,
		IdentDocs,
		Identifications,
		PlasticCards,
		Loants,
		Deposits,
		Profiles
	}
	

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ICard#getCardEntityId()
	 */
	@Override
	public int getCardEntityId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.IDataView#getSelectedRecord()
	 */
	@Override
	public Record getSelectedRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.IDataView#getSelectedRecords()
	 */
	@Override
	public Record[] getSelectedRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.IDataView#isSelectedRecord()
	 */
	@Override
	public boolean isSelectedRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#createGridSections()
	 */
	@Override
	protected void createGridSections() {
		DataSectionInit.init(createDataSection (EDataSection.Accounts.toString(), ESectionType.Grid));
		DataSectionInit.init(createDataSection (EDataSection.PlasticCards.toString(), ESectionType.Grid));
		DataSectionInit.init(createDataSection (EDataSection.Loants.toString(), ESectionType.Grid));
		DataSectionInit.init(createDataSection (EDataSection.Deposits.toString(), ESectionType.Grid));
		
		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#createFieldSections()
	 */
	@Override
	protected void createFieldSections() {		
		DataSectionInit.init(createDataSection (EDataSection.Main.toString(), ESectionType.Fields));
		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#visibleButtons(java.lang.Boolean[])
	 */
	@Override
	public void visibleButtons(Boolean[] visibles) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#doBindDataIfNewState()
	 */
	@Override
	protected void doBindDataIfNewState() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#doPrepareRequestDataIdNewState()
	 */
	@Override
	protected void doPrepareRequestDataIdNewState() {
		// TODO Auto-generated method stub
		
	}
	
	public static void OpenById(final String clientId) {
		
		IChecker checker = new CheckClientExists(clientId);		
		
		checker.check(new BooleanCallback() {			
			@Override
			public void execute(Boolean value) {
				if (value) {
					AppController.getInstance().getMainView().openViewInTab(createCard (clientId));
				}
				
			}
		});					
		
	}
	
	public static IDataView createCard(String clientId) {
		ClientCardImpl  toReturn = new ClientCardImpl();
		toReturn.setSingleInstance(true);
		toReturn.setViewState(EViewState.Edit);
		toReturn.setId(Long.parseLong(clientId));	
		
		return toReturn;
	}
	
}
