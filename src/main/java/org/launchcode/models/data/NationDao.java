package org.launchcode.models.data;



import org.launchcode.models.Nation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NationDao extends CrudRepository<Nation, Integer> {
}
