package br.com.lissandrocunha.topologyinventory.framework.adapters.input.generic;

import br.com.lissandrocunha.topologyinventory.application.ports.input.RouterManagementInputPort;
import br.com.lissandrocunha.topologyinventory.application.ports.input.SwitchManagementInputPort;
import br.com.lissandrocunha.topologyinventory.application.usecases.RouterManagementUseCase;
import br.com.lissandrocunha.topologyinventory.application.usecases.SwitchManagementUseCase;
import br.com.lissandrocunha.topologyinventory.domain.entity.EdgeRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Router;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.*;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.RouterManagementH2Adapter;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.SwitchManagementH2Adapter;

public class SwitchManagementGenericAdapter {


    private SwitchManagementUseCase switchManagementUseCase;
    private RouterManagementUseCase routerManagementUseCase;

    public SwitchManagementGenericAdapter (
            RouterManagementUseCase routerManagementUseCase, SwitchManagementUseCase switchManagementUseCase){
        this.routerManagementUseCase = routerManagementUseCase;
        this.switchManagementUseCase = switchManagementUseCase;
    }

    /**
     * GET /switch/retrieve/{id}
     * */
    public Switch retrieveSwitch(Id switchId) {
        return switchManagementUseCase.retrieveSwitch(switchId);
    }

    /**
     * POST /switch/create
     * */
    public EdgeRouter createAndAddSwitchToEdgeRouter(
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            SwitchType switchType,
            Id routerId
    ) {
        Switch newSwitch = switchManagementUseCase.createSwitch(vendor, model, ip, location, switchType);
        Router edgeRouter = routerManagementUseCase.retrieveRouter(routerId);
        if(!edgeRouter.getRouterType().equals(RouterType.EDGE))
            throw new UnsupportedOperationException("Please inform the id of an edge router to add a switch");
        Router router = switchManagementUseCase.addSwitchToEdgeRouter(newSwitch, (EdgeRouter) edgeRouter);
        return (EdgeRouter) routerManagementUseCase.persistRouter(router);
    }

    /**
     * POST /switch/remove
     * */
    public EdgeRouter removeSwitchFromEdgeRouter(Id switchId, Id edgeRouterId) {
        EdgeRouter edgeRouter = (EdgeRouter) routerManagementUseCase
                .retrieveRouter(edgeRouterId);
        Switch networkSwitch = edgeRouter.getSwitches().get(switchId);
        Router router = switchManagementUseCase
                .removeSwitchFromEdgeRouter(networkSwitch, edgeRouter);
        return (EdgeRouter) routerManagementUseCase.persistRouter(router);
    }
}
