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
		Main(1),
		Accounts(2),
		Contact(3),
		Addreses(4),
		IdentDocs(5),
		Identifications(6),
		PlasticCards(7),
		Loants(8),
		Deposits(9),
		Profiles(10)
		;
		public static EDataSection  fromInt(int value) {			
			switch (value ) {
				case 1: return Main;
				case 2: return Accounts;		
				case 3: return Contact;
				case 4: return Addreses;
				case 5: return IdentDocs;			
				case 6: return Identifications;
				case 7: return PlasticCards;
				case 8: return Loants;
				case 9: return Deposits;
				case 10: return Profiles;				
			}
			return null;
		 }		
		
		
		private int _value;
		
		public int getValue() {
		    return _value;
	   }
		
		private EDataSection (int value) {
			_value = value;
		}
		
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
		DataSectionInit.init(createDataSection (EDataSection.Accounts.getValue(), ESectionType.Grid));
		DataSectionInit.init(createDataSection (EDataSection.PlasticCards.getValue(), ESectionType.Grid));
		DataSectionInit.init(createDataSection (EDataSection.Loants.getValue(), ESectionType.Grid));
		DataSectionInit.init(createDataSection (EDataSection.Deposits.getValue(), ESectionType.Grid));
		
		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#createFieldSections()
	 */
	@Override
	protected void createFieldSections() {		
		DataSectionInit.init(createDataSection (EDataSection.Main.getValue(), ESectionType.Fields));
		
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
