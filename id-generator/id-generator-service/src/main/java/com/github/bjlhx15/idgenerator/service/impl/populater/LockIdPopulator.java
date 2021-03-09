package com.github.bjlhx15.idgenerator.service.impl.populater;

import com.github.bjlhx15.idgenerator.service.bean.Id;
import com.github.bjlhx15.idgenerator.service.impl.bean.IdMeta;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockIdPopulator extends BasePopulator {

    private Lock lock = new ReentrantLock();

    public LockIdPopulator() {
        super();
    }

    public void populateId(Id id, IdMeta idMeta) {
        lock.lock();
        try {
            super.populateId(id, idMeta);
        } finally {
            lock.unlock();
        }
    }

}
