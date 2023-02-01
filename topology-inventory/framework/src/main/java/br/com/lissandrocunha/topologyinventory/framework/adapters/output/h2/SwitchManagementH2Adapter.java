package br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2;

import br.com.lissandrocunha.topologyinventory.application.ports.output.SwitchManagementOutputPort;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.Id;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.data.SwitchData;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.mappers.RouterH2Mapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SwitchManagementH2Adapter implements SwitchManagementOutputPort {

    @PersistenceContext
    private EntityManager em;

    public SwitchManagementH2Adapter(){
        setUpH2Database();
    }

    @Override
    public Switch retrieveSwitch(Id id) {
        var switchData = em.getReference(SwitchData.class, id.getUuid());
        return RouterH2Mapper.switchDataToDomain(switchData);
    }

    private void setUpH2Database() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("inventory");
        EntityManager em =
                entityManagerFactory.createEntityManager();
        this.em = em;
    }
}
