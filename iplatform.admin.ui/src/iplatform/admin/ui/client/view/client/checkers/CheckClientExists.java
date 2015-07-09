/**
 * 
 */
package iplatform.admin.ui.client.view.client.checkers;

import java.util.logging.Logger;

import mdb.core.ui.client.data.checkers.SimpleChecker;

import com.smartgwt.client.util.BooleanCallback;

/**
 * @author azhuk
 * Creation date: Jul 10, 2015
 *
 */
public class CheckClientExists extends SimpleChecker {
	
	private static final Logger _logger = Logger
			.getLogger(CheckClientExists.class.getName());
	
	private String _clientId; 
	
	public CheckClientExists (String clientId) {
		setClientId(_clientId);
	}
	
	/**
	 * @param _clientId2
	 */
	private void setClientId(String clientId) {
		_clientId = clientId;		
	}


	
	public void check (BooleanCallback callback) {
		
		callback.execute(true);
		
	}
}
