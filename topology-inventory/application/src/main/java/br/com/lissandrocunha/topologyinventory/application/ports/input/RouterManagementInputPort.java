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
    private RouterManagementOutputPort routerManagementOutputPort;

    @Override
    public Router createRouter(Vendor vendor, Model model, IP ip, Location location, RouterType routerType) {
        return RouterFactory.getRouter(null,
                vendor, model, ip, location, routerType);
    }

    @Override
    public CoreRouter addRouterToCoreRouter(Router router, CoreRouter coreRouter) {
        var addedRouter =  coreRouter.addRouter(router);
        return addedRouter;
    }

    @Override
    public Router removeRouterFromCoreRouter(Router router, CoreRouter coreRouter) {
        var removedRouter = coreRouter.removeRouter(router);
        return removedRouter;
    }

    @Override
    public Router retrieveRouter(Id id) {
        return routerManagementOutputPort.retrieveRouter(id);
    }

    @Override
    public Router persistRouter(Router router) {
        return routerManagementOutputPort.persistRouter(router);
    }
}
