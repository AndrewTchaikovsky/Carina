package com.solvd.qa.carina.demo.sample.db.mappers;

import com.solvd.qa.carina.demo.sample.db.models.User;

public interface UserMapper {

	void create(User user);

	User findById(long id);

	User findByUserName(String username);

	void update(User user);

	void delete(User user);
}
