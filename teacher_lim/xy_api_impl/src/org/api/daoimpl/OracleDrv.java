package org.api.daoimpl;

import org.api.dao.DataDAO;

public class OracleDrv implements DataDAO {

	@Override
	public int doSum(int x, int y) {
		return x + y;
	}

}
