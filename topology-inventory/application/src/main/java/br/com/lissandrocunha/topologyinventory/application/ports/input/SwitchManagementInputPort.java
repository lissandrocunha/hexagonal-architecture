package br.com.lissandrocunha.topologyinventory.application.ports.input;

import br.com.lissandrocunha.topologyinventory.application.ports.output.SwitchManagementOutputPort;
import br.com.lissandrocunha.topologyinventory.application.usecases.SwitchManagementUseCase;
import br.com.lissandrocunha.topologyinventory.domain.entity.EdgeRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SwitchManagementInputPort implements SwitchManagementUseCase {

    SwitchManagementOutputPort switchManagementOutputPort;

    public SwitchManagementInputPort(SwitchManagementOutputPort switchManagementOutputPort){
        this.switchManagementOutputPort = switchManagementOutputPort;
    }

    @Override
    public Switch createSwitch(
            Vendor vendor,
            Model model,
            IP ip,
            Location location,
            SwitchType switchType) {
        return Switch
                .builder()
                .switchId(Id.withoutId())
                .vendor(vendor)
                .model(model)
                .ip(ip)
                .location(location)
                .switchType(switchType)
                .build();
    }

    public Switch retrieveSwitch(Id id){
        return switchManagementOutputPort.retrieveSwitch(id);
    }

    @Override
    public EdgeRouter addSwitchToEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter) {
        networkSwitch.setRouterId(edgeRouter.getId());
        edgeRouter.addSwitch(networkSwitch);
        return edgeRouter;
    }

    @Override
    public EdgeRouter removeSwitchFromEdgeRouter(Switch networkSwitch, EdgeRouter edgeRouter) {
        edgeRouter.removeSwitch(networkSwitch);
        return edgeRouter;
    }
}
