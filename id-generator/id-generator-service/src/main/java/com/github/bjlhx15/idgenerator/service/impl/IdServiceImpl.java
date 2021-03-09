package com.github.bjlhx15.idgenerator.service.impl;

import com.github.bjlhx15.idgenerator.service.bean.Id;
import com.github.bjlhx15.idgenerator.service.impl.populater.LockIdPopulator;
import com.github.bjlhx15.idgenerator.service.impl.populater.SyncIdPopulator;
import com.github.bjlhx15.idgenerator.service.impl.bean.IdType;
import com.github.bjlhx15.idgenerator.service.impl.populater.AtomicIdPopulator;
import com.github.bjlhx15.idgenerator.service.impl.populater.IdPopulator;
import com.github.bjlhx15.idgenerator.util.CommonUtils;

public class IdServiceImpl extends AbstractIdServiceImpl {

    private static final String SYNC_LOCK_IMPL_KEY = "idgenerator.sync.lock.impl.key";

    private static final String ATOMIC_IMPL_KEY = "idgenerator.atomic.impl.key";

    protected IdPopulator idPopulator;

    public IdServiceImpl() {
        super();

        initPopulator();
    }

    public IdServiceImpl(String type) {
        super(type);

        initPopulator();
    }

    public IdServiceImpl(IdType type) {
        super(type);

        initPopulator();
    }

    public void initPopulator() {
        if(idPopulator != null){
            log.info("The " + idPopulator.getClass().getCanonicalName() + " is used.");
        } else if (CommonUtils.isPropKeyOn(SYNC_LOCK_IMPL_KEY)) {
            log.info("The SyncIdPopulator is used.");
            idPopulator = new SyncIdPopulator();
        } else if (CommonUtils.isPropKeyOn(ATOMIC_IMPL_KEY)) {
            log.info("The AtomicIdPopulator is used.");
            idPopulator = new AtomicIdPopulator();
        } else {
            log.info("The default LockIdPopulator is used.");
            idPopulator = new LockIdPopulator();
        }
    }

    protected void populateId(Id id) {
        idPopulator.populateId(id, this.idMeta);
    }

    public void setIdPopulator(IdPopulator idPopulator) {
        this.idPopulator = idPopulator;
    }
}
