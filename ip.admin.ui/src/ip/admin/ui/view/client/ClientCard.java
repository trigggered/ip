/**
 * 
 */
package ip.admin.ui.view.client;

import ip.admin.ui.recources.locales.Captions;

import java.util.logging.Level;
import java.util.logging.Logger;

import mdb.core.ui.client.app.AppController;
import mdb.core.ui.client.data.IBaseDataSource;
import mdb.core.ui.client.data.bind.DataBindException;
import mdb.core.ui.client.view.data.IDataView;
import mdb.core.ui.client.view.data.card.section.IDataSection;
import mdb.core.vaadin.ui.data.IDataSource;
import mdb.core.vaadin.ui.view.data.DataView;
import mdb.core.vaadin.ui.view.data.card.CardView;
import mdb.core.vaadin.ui.view.data.card.section.DataFieldsSection;

import com.google.gwt.user.client.ui.DialogBox.Caption;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;

/**
 * @author azhuk
 * Creation date: Aug 27, 2015
 *
 */
public class ClientCard extends CardView{
	private static final Logger _logger = Logger.getLogger(ClientCard.class
			.getName());

	
	private static String ID = "ID"; 

	Item _mainItem;
	IDataSource _mainDs;
	
	public ClientCard () {
		
	}
	
	public ClientCard (IDataSource mainDS, Item mainItem) {
		_mainItem = mainItem;
		_mainDs = mainDS;
	}
	
	
	 @Override
	 protected void  createContextLayout() {		 
	
		 super.createContextLayout();		 		 
		 
		 /*
		 DataFieldsSection clientSection  = new DataFieldsSection(this);
		 clientSection.setCaption("Клиент");
		 _mainTabs.addTab(clientSection.getMainLayout() ,clientSection.getCaption());
		 tabs.addTab( new Label(),"Контакты");
		 tabs.addTab( new Label(),"Адреса");
		 tabs.addTab( new Label(),"Счета");
		 tabs.addTab( new Label(),"Идентификация");
		 tabs.addTab( new Label(),"Карты");
		 tabs.addTab( new Label(),"Кредиты");
		 tabs.addTab( new Label(),"Депозиты");	
		 */
	     
		 
	 }


	 public Item getMainItem () {
		return _mainItem;
		 
	 }
	 
	/**
	 * @param mainDS 
	 * @param itemProperty
	 */
	public static void OpenCard(IDataSource mainDS, Item mainItem) {
		ClientCard card = new ClientCard(mainDS, mainItem);
		
		card.setCardId((String)mainItem.getItemProperty(ID).getValue());
		card.setCaption(String.format("Карточка клиента № %s", card.getCardId() ));

		AppController.getInstance().getMainView().openView(card);
		
	}
	 
	
	public static void OpenById(String idCard) {
		ClientCard card = new ClientCard();
		
		card.setCardId(idCard);
		card.setCaption(String.format("%s № %s",Captions.CliCard,  card.getCardId() ));

		AppController.getInstance().getMainView().openView(card);
		
	}


	/* (non-Javadoc)
	 * @see mdb.core.vaadin.ui.view.data.card.CardView#createGridSections()
	 */
	@Override
	protected void createGridSections() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see mdb.core.vaadin.ui.view.data.card.CardView#createFieldSections()
	 */
	@Override
	protected void createFieldSections() {
		DataFieldsSection clientSection  = new DataFieldsSection(this, 1, -1, Captions.CliCard);
		
		clientSection.getDataForm().bindData(_mainDs, getMainItem());
		_mainTabs.addTab(clientSection.getMainLayout() ,clientSection.getCaption());
		
		addSection(clientSection);
	}


	/* (non-Javadoc)
	 * @see mdb.core.vaadin.ui.view.data.card.CardView#addSection(mdb.core.ui.client.view.data.card.section.IDataSection)
	 */
	@Override
	protected void addSection(IDataSection dataSection) {
		
		_hmDataSections.put(dataSection.getSectionId(), dataSection);
		
	}


	/* (non-Javadoc)
	 * @see mdb.core.vaadin.ui.view.data.card.CardView#visibleButtons(java.lang.Boolean[])
	 */
	@Override
	public void visibleButtons(Boolean[] visibles) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see mdb.core.vaadin.ui.view.data.card.CardView#doBindDataIfNewState()
	 */
	@Override
	protected void doBindDataIfNewState() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see mdb.core.vaadin.ui.view.data.card.CardView#doPrepareRequestDataIdNewState()
	 */
	@Override
	protected void doPrepareRequestDataIdNewState() {
		// TODO Auto-generated method stub
		
	}

}
