package br.com.lissandrocunha.topologyinventory.bootstrap;

import br.com.lissandrocunha.topologyinventory.domain.entity.CoreRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.EdgeRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.IP;
import br.com.lissandrocunha.topologyinventory.domain.vo.Id;
import br.com.lissandrocunha.topologyinventory.domain.vo.Location;
import br.com.lissandrocunha.topologyinventory.domain.vo.Model;
import br.com.lissandrocunha.topologyinventory.domain.vo.Network;
import br.com.lissandrocunha.topologyinventory.domain.vo.Protocol;
import br.com.lissandrocunha.topologyinventory.domain.vo.RouterType;
import br.com.lissandrocunha.topologyinventory.domain.vo.SwitchType;
import br.com.lissandrocunha.topologyinventory.domain.vo.Vendor;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(targets = {
        CoreRouter.class,
        EdgeRouter.class,
        Switch.class,
        Id.class,
        IP.class,
        Location.class,
        Model.class,
        Network.class,
        Protocol.class,
        RouterType.class,
        SwitchType.class,
        Vendor.class,
})
public class ReflectionConfiguration {

}