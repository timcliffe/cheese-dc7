package org.launchcode.models.data;



import org.launchcode.models.City;
import org.launchcode.models.Nation;
import org.launchcode.models.Resource;
import org.launchcode.models.Territory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NationDao extends CrudRepository<Nation, Integer> {
    void save(Resource newResource);

    void save(City newCity);

    void save(Territory newTerritory);
}