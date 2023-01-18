package br.com.lissandrocunha.topologyinventory.application.usecases;

import br.com.lissandrocunha.topologyinventory.application.ports.output.SwitchManagementOutputPort;
import br.com.lissandrocunha.topologyinventory.domain.entity.EdgeRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.*;

public interface SwitchManagementUseCase {

    void setOutputPort(SwitchManagementOutputPort switchManagementOutputPort);

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
