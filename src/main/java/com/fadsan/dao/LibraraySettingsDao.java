package com.fadsan.dao;

import com.fadsan.model.LibraraySettings;

public interface LibraraySettingsDao extends DAO<Integer, LibraraySettings>{

	LibraraySettings checkData(int sessionId);

}
