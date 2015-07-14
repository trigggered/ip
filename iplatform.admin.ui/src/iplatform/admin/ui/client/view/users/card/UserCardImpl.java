/**
 * 
 */
package iplatform.admin.ui.client.view.users.card;


import iplatform.admin.ui.client.view.client.checkers.CheckClientExists;

import java.util.logging.Logger;

import mdb.core.ui.client.app.AppController;
import mdb.core.ui.client.data.checkers.IChecker;
import mdb.core.ui.client.view.data.IDataView;
import mdb.core.ui.client.view.data.card.ACard;
import mdb.core.ui.client.view.data.card.section.IDataSection;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;

/**
 * @author azhuk
 * Creation date: Jul 13, 2015
 *
 */
public class UserCardImpl extends ACard {
	private static final Logger _logger = Logger.getLogger(UserCardImpl.class
			.getName());

	enum  EClientCardSection {
		Main(1),
		Profiles(2)
		;
		
		public static EClientCardSection  fromInt(int value) {			
			switch (value ) {
				case 1: return Main;
				case 2: return Profiles;				
			}
			return null;
		 }		
		
		
		private int _value;
		
		public int getValue() {
		    return _value;
	   }
		
		private EClientCardSection (int value) {
			_value = value;
		}

	
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
		UserCardImpl  toReturn = new UserCardImpl();
		toReturn.setSingleInstance(true);
		toReturn.setViewState(EViewState.Edit);			
		
		return toReturn;
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
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#createFieldSections()
	 */
	@Override
	protected void createFieldSections() {
		// TODO Auto-generated method stub

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

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#createCardLayouts()
	 */
	@Override
	protected void createCardLayouts() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#addSection(mdb.core.ui.client.view.data.card.section.IDataSection)
	 */
	@Override
	protected void addSection(IDataSection dataSection) {
		// TODO Auto-generated method stub
		
	}
}
