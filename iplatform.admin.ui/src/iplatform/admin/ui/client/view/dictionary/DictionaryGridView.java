package iplatform.admin.ui.client.view.dictionary;

import mdb.core.ui.client.view.data.grid.GridView;
import iplatform.admin.ui.client.commons.EViewIdent;
import iplatform.admin.ui.client.view.ViewFactory;

public class DictionaryGridView extends GridView {	

	private EViewIdent _viewIdent;	
	
	public DictionaryGridView (EViewIdent viewIdent) {		
		initialize(viewIdent);
	}

	@Override
	protected void createComponents() {
		super.createComponents();
		setSingleInstance(true);
	}
	
	private void initialize (EViewIdent viewIdent) {
		_viewIdent = viewIdent;	
		ViewFactory.viewInitialize(viewIdent, this);			
	}
	
	
	public EViewIdent getViewMenuIdent() {
		return _viewIdent;
	}	
	
}
