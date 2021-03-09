package com.github.bjlhx15.idgenerator.service.impl.populater;

import com.github.bjlhx15.idgenerator.service.bean.Id;
import com.github.bjlhx15.idgenerator.service.impl.bean.IdMeta;

public class SyncIdPopulator extends BasePopulator {

    public SyncIdPopulator() {
        super();
    }

    public synchronized void populateId(Id id, IdMeta idMeta) {
        super.populateId(id, idMeta);
    }

}
