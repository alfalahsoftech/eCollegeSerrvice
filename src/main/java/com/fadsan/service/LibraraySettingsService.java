package com.fadsan.service;

import com.fadsan.model.LibraraySettings;
import com.fadsan.models.dto.LibraraySettingsDTO;

public interface LibraraySettingsService extends CRUDService<Integer, LibraraySettings> {

	LibraraySettingsDTO checkData(int sessionId);

	String saveLibraray(LibraraySettingsDTO libraraySettingDTO);

}
