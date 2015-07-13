/**
 * 
 */
package iplatform.admin.ui.client.view.client.card;

import java.util.logging.Logger;

import com.smartgwt.client.data.Record;

import mdb.core.ui.client.events.IDataEditHandler;
import mdb.core.ui.client.view.data.card.section.IDataSection;

import iplatform.admin.ui.client.view.client.card.ClientCardImpl.EClientCardSection;
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
	
	public static IDataSection init(IDataSection  section) {		
		
		EClientCardSection sectionIdent =  EClientCardSection.fromInt(section.getSectionId());
		
		
		_logger.info("Init section ="+sectionIdent.toString());				
		
		switch(sectionIdent) {
		case Main:
			section.setMainEntityId(MdbEntityConst.ClI_INDIVIDUAL);			
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
			section.setMainEntityId(MdbEntityConst.ACCOUNTS);			
			section.setCaption( Captions.Accounts);			
			break;
		case Contacts:
			section.setMainEntityId(MdbEntityConst.CliContact);			
			section.setCaption( Captions.Contacts);			
			break;
		case IdentDocs:
			section.setMainEntityId(MdbEntityConst.IdentDocs);			
			section.setCaption( Captions.IdentDocs);
			
			/*
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
			*/
		default:
			break;
		}
		return section;
	}
	
}
