package com.solvd.qa.carina.demo.sample.db.mappers;

import com.solvd.qa.carina.demo.sample.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
