package org.chitan.platform.manager;

import java.io.Serializable;

import org.chitan.platform.dao.Mapper;
import org.chitan.platform.entity.AbstractEntity;

public abstract class AbstractManager<T extends AbstractEntity, PK extends Serializable> {

	protected abstract Mapper<T, PK> getMapper();

	public int count() {
		return getMapper().count();
	}

	public T selectOne(PK id) {
		return getMapper().selectOne(id);
	}
}
