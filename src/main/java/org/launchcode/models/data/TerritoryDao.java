package org.launchcode.models.data;


import org.launchcode.models.Resource;
import org.launchcode.models.Territory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TerritoryDao extends CrudRepository<Territory, Integer> {
}