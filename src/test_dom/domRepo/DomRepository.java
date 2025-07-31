package test_dom.domRepo;

import java.util.List;

import db.DbConn;
import db.GenericRepositoryInterface;
import test_dom.dom_model.DomModel;

public class DomRepository extends DbConn
implements GenericRepositoryInterface<DomModel>{


	public  int insert(DomModel DM)
	{
		return 0;
	}
	public int getCount() {
		return 0;
	}
	public  List<DomModel> findAll() {
		return null;
	}
	public  DomModel find(String id) {
		return null;
	}
}
