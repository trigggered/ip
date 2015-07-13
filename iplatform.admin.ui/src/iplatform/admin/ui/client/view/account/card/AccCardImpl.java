/**
 * 
 */
package iplatform.admin.ui.client.view.account.card;

import java.util.logging.Logger;

import mdb.core.ui.client.app.AppController;
import mdb.core.ui.client.view.data.IDataView;
import mdb.core.ui.client.view.data.card.ACard;
import mdb.core.ui.client.view.data.card.section.IDataSection;

import com.smartgwt.client.data.Record;

/**
 * @author azhuk
 * Creation date: Jul 14, 2015
 *
 */
public class AccCardImpl extends ACard {
	private static final Logger _logger = Logger.getLogger(AccCardImpl.class
			.getName());

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
	 * @see mdb.core.ui.client.view.data.card.ACard#createCardLayouts()
	 */
	@Override
	protected void createCardLayouts() {
		// TODO Auto-generated method stub

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
	 * @see mdb.core.ui.client.view.data.card.ACard#addSection(mdb.core.ui.client.view.data.card.section.IDataSection)
	 */
	@Override
	protected void addSection(IDataSection dataSection) {
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

	/**
	 * @param attribute
	 */
	public static void OpenById(String accId) {
		AppController.getInstance().getMainView().openViewInTab(createCard (accId));		
	}
	
	public static IDataView createCard(String accId) {
		AccCardImpl  toReturn = new AccCardImpl();
		toReturn.setSingleInstance(true);
		toReturn.setViewState(EViewState.Edit);
		toReturn.setCardId(Long.parseLong(accId));	
		
		return toReturn;
	}
	
	@Override
	public void prepareRequestData() {
		
		for( IDataSection section : 	getDataSections().values() ) {
			section.getParams().add("ACCID", String.valueOf(getCardId()));
		}
		
		super.prepareRequestData();					
	}
	
}
