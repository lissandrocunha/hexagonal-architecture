package br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2;

import br.com.lissandrocunha.topologyinventory.application.ports.output.RouterManagementOutputPort;
import br.com.lissandrocunha.topologyinventory.domain.entity.Router;
import br.com.lissandrocunha.topologyinventory.domain.vo.Id;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.data.RouterData;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.mappers.RouterH2Mapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RouterManagementH2Adapter implements RouterManagementOutputPort {

    @PersistenceContext
    private EntityManager em;

    public RouterManagementH2Adapter(){
        setUpH2Database();
    }

    @Override
    public Router retrieveRouter(Id id) {
        var routerData = em.getReference(RouterData.class, id.getUuid());
        return RouterH2Mapper.routerDataToDomain(routerData);
    }

    @Override
    public Router removeRouter(Id id) {
        var routerData = em.getReference(RouterData.class, id.getUuid());
        em.remove(routerData);
        return null;
    }

    @Override
    public Router persistRouter(Router router) {
        var routerData = RouterH2Mapper.routerDomainToData(router);
        em.persist(routerData);
        return router;
    }

    private void setUpH2Database() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("inventory");
        EntityManager em =
                entityManagerFactory.createEntityManager();
        this.em = em;
    }
}
