package br.com.lissandrocunha.topologyinventory.application.ports.output;

import br.com.lissandrocunha.topologyinventory.domain.entity.Router;
import br.com.lissandrocunha.topologyinventory.domain.vo.Id;

public interface RouterManagementOutputPort {
    Router retrieveRouter(Id id);

    Router removeRouter(Id id);

    Router persistRouter(Router router);
}

