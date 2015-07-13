/**
 * 
 */
package iplatform.admin.ui.client.view.client.card;

import iplatform.admin.ui.client.resources.locales.Captions;
import iplatform.admin.ui.client.view.client.checkers.CheckClientExists;
import iplatform.admin.ui.shared.MdbEntityConst;

import java.util.logging.Logger;

import mdb.core.ui.client.app.AppController;
import mdb.core.ui.client.data.checkers.IChecker;
import mdb.core.ui.client.view.data.IDataView;
import mdb.core.ui.client.view.data.card.ACard;
import mdb.core.ui.client.view.data.card.section.IDataSection;
import mdb.core.ui.client.view.data.card.section.IDataSection.ESectionType;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;


/**
 * @author azhuk
 * Creation date: Jul 10, 2015
 *
 */
public class ClientCardImpl  extends ACard {
	private static final Logger _logger = Logger.getLogger(ClientCardImpl.class
			.getName());
	
	enum  EClientCardSection {
		Main(1),
		Accounts(2),
		Contacts(3),
		Addreses(4),
		IdentDocs(5),
		Identifications(6),
		PlasticCards(7),
		Loants(8),
		Deposits(9),
		Profiles(10)
		;
		public static EClientCardSection  fromInt(int value) {			
			switch (value ) {
				case 1: return Main;
				case 2: return Accounts;		
				case 3: return Contacts;
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
		
		private EClientCardSection (int value) {
			_value = value;
		}
		
	}	

	protected TabSet _mainTabSet;
	
	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ICard#getCardEntityId()
	 */
	@Override
	public int getCardEntityId() {
		// TODO Auto-generated method stub
		return MdbEntityConst.ClI_INDIVIDUAL;
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
		addSection(DataSectionInit.init(createDataSection (EClientCardSection.Contacts.getValue(), ESectionType.Grid)));
		addSection(DataSectionInit.init(createDataSection (EClientCardSection.IdentDocs.getValue(), ESectionType.Grid)));
		addSection(DataSectionInit.init(createDataSection (EClientCardSection.Accounts.getValue(), ESectionType.Grid)));		
/*
		addSection(DataSectionInit.init(createDataSection (EClientCardSection.PlasticCards.getValue(), ESectionType.Grid)));
		addSection(DataSectionInit.init(createDataSection (EClientCardSection.Loants.getValue(), ESectionType.Grid)));
		addSection(DataSectionInit.init(createDataSection (EClientCardSection.Deposits.getValue(), ESectionType.Grid)));		
		
*/
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#createFieldSections()
	 */
	@Override
	protected void createFieldSections() {		
		addSection(DataSectionInit.init(createDataSection (EClientCardSection.Main.getValue(), ESectionType.Fields)));
		
		
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
		toReturn.setCardId(Long.parseLong(clientId));	
		
		return toReturn;
	}
	
	@Override	
	public String getCaption() {
		return Captions.CliCard;
	}

	/* (non-Javadoc)
	 * @see mdb.core.ui.client.view.data.card.ACard#createCardLayouts()
	 */
	@Override
	protected void createCardLayouts() {

		Layout mainLayout = new HLayout();
		mainLayout.setHeight("95%");
		_mainTabSet = new TabSet();
		_mainTabSet.setWidth("50%");
		_mainTabSet.setShowResizeBar(true);
		
		//Layout rightLayout = new HLayout();
		//mainLayout.addMembers(_mainTabSet, rightLayout);
		mainLayout.addMembers(_mainTabSet);
		
		getViewPanel().addMembers(mainLayout, createBottomLayout());		
		
	}
	
	protected void addSection(IDataSection dataSection) {
		Tab tab = new Tab();
		tab.setTitle( dataSection.getCaption());
		tab.setIcon( dataSection.getImgCaption());		
		tab.setPane(dataSection.getCanvas());
		dataSection.setViewContainerID(tab.getID());
		_mainTabSet.addTab(tab);
	}
	
	@Override
	public void prepareRequestData() {
		
		for( IDataSection section : 	getDataSections().values() ) {
			section.getParams().add("CLIENTID", String.valueOf(getCardId()));
		}
		
		super.prepareRequestData();					
	}
}
