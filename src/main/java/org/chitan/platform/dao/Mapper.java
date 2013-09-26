package org.chitan.platform.dao;

import java.io.Serializable;

import org.chitan.platform.entity.AbstractEntity;

public interface Mapper<T extends AbstractEntity, PK extends Serializable> {

	public int count();

	public T selectOne(PK id);
}
