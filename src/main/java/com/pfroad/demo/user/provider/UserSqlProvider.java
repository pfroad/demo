package com.pfroad.demo.user.provider;

import com.pfroad.demo.base.AbstractSqlProvider;
import com.pfroad.demo.user.entity.User;

public class UserSqlProvider extends AbstractSqlProvider<User, Long> {
	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
}
