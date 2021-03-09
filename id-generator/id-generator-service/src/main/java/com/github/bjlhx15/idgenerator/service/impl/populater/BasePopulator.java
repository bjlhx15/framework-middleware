package com.github.bjlhx15.idgenerator.service.impl.populater;

import com.github.bjlhx15.idgenerator.service.bean.Id;
import com.github.bjlhx15.idgenerator.service.impl.bean.IdMeta;
import com.github.bjlhx15.idgenerator.service.impl.bean.IdType;
import com.github.bjlhx15.idgenerator.util.TimeUtils;

public abstract class BasePopulator implements IdPopulator, ResetPopulator {
    protected long sequence = 0;
    protected long lastTimestamp = -1;

    public BasePopulator() {
        super();
    }

    public void populateId(Id id, IdMeta idMeta) {
        long timestamp = TimeUtils.genTime(IdType.parse(id.getType()));
        TimeUtils.validateTimestamp(lastTimestamp, timestamp);

        if (timestamp == lastTimestamp) {
            sequence++;
            sequence &= idMeta.getSeqBitsMask();
            if (sequence == 0) {
                timestamp = TimeUtils.tillNextTimeUnit(lastTimestamp, IdType.parse(id.getType()));
            }
        } else {
            lastTimestamp = timestamp;
            sequence = 0;
        }

        id.setSeq(sequence);
        id.setTime(timestamp);
    }

    public void reset() {
        this.sequence = 0;
        this.lastTimestamp = -1;
    }
}
