package br.com.lissandrocunha.topologyinventory.application.ports.input;

import br.com.lissandrocunha.topologyinventory.application.ports.output.RouterManagementOutputPort;
import br.com.lissandrocunha.topologyinventory.application.usecases.RouterManagementUseCase;
import br.com.lissandrocunha.topologyinventory.domain.entity.CoreRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Router;
import br.com.lissandrocunha.topologyinventory.domain.entity.factory.RouterFactory;
import br.com.lissandrocunha.topologyinventory.domain.vo.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RouterManagementInputPort implements RouterManagementUseCase {

    RouterManagementOutputPort routerManagementOutputPort;

    public RouterManagementInputPort(RouterManagementOutputPort routerNetworkOutputPort){
        this.routerManagementOutputPort = routerNetworkOutputPort;
    }

    @Override
    public Router createRouter(Id id,
                               Vendor vendor,
                               Model model,
                               IP ip,
                               Location location,
                               RouterType routerType) {
        return RouterFactory.getRouter(null,
                vendor,
                model,
                ip,
                location,
                routerType
        );
    }

    @Override
    public Router removeRouter(Id id) {
        return routerManagementOutputPort.removeRouter(id);
    }

    @Override
    public Router retrieveRouter(Id id) {
        return routerManagementOutputPort.retrieveRouter(id);
    }

    @Override
    public Router persistRouter(Router router) {
        return routerManagementOutputPort.persistRouter(router);
    }

    @Override
    public CoreRouter addRouterToCoreRouter(Router router, CoreRouter coreRouter) {
        var addedRouter = coreRouter.addRouter(router);
        return (CoreRouter) persistRouter(addedRouter);
    }

    @Override
    public Router removeRouterFromCoreRouter(Router router, CoreRouter coreRouter) {
        var removedRouter = coreRouter.removeRouter(router);
        persistRouter(coreRouter);
        return removedRouter;
    }
}