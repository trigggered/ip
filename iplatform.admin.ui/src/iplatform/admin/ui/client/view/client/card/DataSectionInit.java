/**
 * 
 */
package iplatform.admin.ui.client.view.client.card;

import java.util.logging.Logger;

import com.smartgwt.client.data.Record;

import mdb.core.ui.client.events.IDataEditHandler;
import mdb.core.ui.client.view.data.card.section.IDataSection;

import iplatform.admin.ui.client.view.client.card.ClientCardImpl.EDataSection;
import iplatform.admin.ui.shared.MdbEntityConst;
import iplatform.admin.ui.client.resources.locales.Captions;

/**
 * @author azhuk
 * Creation date: Jul 10, 2015
 *
 */
public class DataSectionInit {
	private static final Logger _logger = Logger
			.getLogger(DataSectionInit.class.getName());
	
	public static void init(IDataSection  section) {
		
		EDataSection sectionIdent =  EDataSection.valueOf( section.getSectionId());
		
		section.getParams().add("CLIENTID", String.valueOf(section.getCard().getId()));
		
		switch(sectionIdent) {
		case Main:
			section.setMainEntityId(MdbEntityConst.CliIndividualCard);			
			section.setCaption( Captions.CliCard);			
			
			//section.setImgCaption(Images.ACCEPTING_EMP );
			//_selectedListEntityId = MdbEntityConst.EMP_LIST;
			
			section.addEditEvent(new IDataEditHandler() {
				
				@Override
				public void onEdit(Record record) {
					// TODO Auto-generated method stub
					
				}
			});			
			break;
		case Accounts:
			section.setMainEntityId(MdbEntityConst.CliAccounts);			
			section.setCaption( Captions.Accounts);			
			break;
		case PlasticCards:
			section.setMainEntityId(MdbEntityConst.CliPlasticCards);			
			section.setCaption( Captions.PlasticCards);			
			break;
		case Loants:
			section.setMainEntityId(MdbEntityConst.CliLoans);			
			section.setCaption( Captions.Loans);
			break;
		case Deposits:
			section.setMainEntityId(MdbEntityConst.CliDeposits);			
			section.setCaption( Captions.Deposits);
			break;
		}
	}
}
