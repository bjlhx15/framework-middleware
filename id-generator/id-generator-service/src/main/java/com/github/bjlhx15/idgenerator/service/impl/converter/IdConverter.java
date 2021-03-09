package com.github.bjlhx15.idgenerator.service.impl.converter;


import com.github.bjlhx15.idgenerator.service.bean.Id;

public interface IdConverter {

    public long convert(Id id);

    public Id convert(long id);

}
