package com.dlala.dao.gesparams;

import javax.servlet.http.HttpServletRequest;
import com.dlala.bean.Annonce;


public interface GestParamsDAO {
	public void setParams(HttpServletRequest request);
	
	public void setParamsKeyToValue(Annonce annonce);
}
