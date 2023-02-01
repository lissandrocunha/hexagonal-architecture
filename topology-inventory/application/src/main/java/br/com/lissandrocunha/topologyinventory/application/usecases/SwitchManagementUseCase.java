package br.com.lissandrocunha.topologyinventory.application.usecases;

import br.com.lissandrocunha.topologyinventory.domain.entity.EdgeRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.IP;
import br.com.lissandrocunha.topologyinventory.domain.vo.Id;
import br.com.lissandrocunha.topologyinventory.domain.vo.Location;
import br.com.lissandrocunha.topologyinventory.domain.vo.Model;
import br.com.lissandrocunha.topologyinventory.domain.vo.SwitchType;
import br.com.lissandrocunha.topologyinventory.domain.vo.Vendor;

public interface SwitchManagementUseCase {

    Switch createSwitch(
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            SwitchType switchType
    );

    Switch retrieveSwitch(Id id);

    EdgeRouter addSwitchToEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter);

    EdgeRouter removeSwitchFromEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter);
}
