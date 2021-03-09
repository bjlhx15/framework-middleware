package com.github.bjlhx15.idgenerator.service.impl.populater;

import com.github.bjlhx15.idgenerator.service.bean.Id;
import com.github.bjlhx15.idgenerator.service.impl.bean.IdMeta;

public interface IdPopulator {

    void populateId(Id id, IdMeta idMeta);

}
