package com.github.bjlhx15.idgenerator.sample.embed;


import com.github.bjlhx15.idgenerator.service.bean.Id;
import com.github.bjlhx15.idgenerator.service.intf.IdService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmbedSample {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring/idgenerator-service-sample.xml");
        IdService idService = (IdService) ac.getBean("idService");

        long id = idService.genId();
        Id ido = idService.expId(id);

        System.out.println(id + ":" + ido);
    }
}
