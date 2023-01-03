package br.com.lissandrocunha.topologyinventory.domain.entity.factory;

import br.com.lissandrocunha.topologyinventory.domain.entity.CoreRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.EdgeRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Router;
import br.com.lissandrocunha.topologyinventory.domain.vo.*;

public class RouterFactory {

    public static Router getRouter(Id id,
                                   Vendor vendor,
                                   Model model,
                                   IP ip,
                                   Location location,
                                   RouterType routerType){

        switch (routerType){
            case CORE:
                return CoreRouter.builder().
                        id(id==null ? Id.withoutId():id).
                        vendor(vendor).
                        model(model).
                        ip(ip).
                        location(location).
                        routerType(routerType).
                        build();
            case EDGE:
                return EdgeRouter.builder().
                        id(id==null ? Id.withoutId():id).
                        vendor(vendor).
                        model(model).
                        ip(ip).
                        location(location).
                        routerType(routerType).
                        build();
            default:
                return null;
        }
    }
}