package br.com.lissandrocunha.topologyinventory.application.usecases;

import br.com.lissandrocunha.topologyinventory.domain.entity.CoreRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Router;
import br.com.lissandrocunha.topologyinventory.domain.vo.*;

public interface RouterManagementUseCase {

    Router createRouter(
            Id id,
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            RouterType routerType);

    Router removeRouter(Id id);

    Router retrieveRouter(Id id);

    Router persistRouter(Router router);

    Router addRouterToCoreRouter(
            Router router, CoreRouter coreRouter);

    Router removeRouterFromCoreRouter(
            Router router, CoreRouter coreRouter);
}
