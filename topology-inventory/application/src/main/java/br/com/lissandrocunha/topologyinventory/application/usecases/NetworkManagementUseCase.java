package br.com.lissandrocunha.topologyinventory.application.usecases;

import br.com.lissandrocunha.topologyinventory.application.ports.input.RouterManagementInputPort;
import br.com.lissandrocunha.topologyinventory.application.ports.output.RouterManagementOutputPort;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.IP;
import br.com.lissandrocunha.topologyinventory.domain.vo.Network;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public interface NetworkManagementUseCase {

    void setOutputPort(RouterManagementOutputPort routerManagementOutputPort);

    Network createNetwork(
            IP networkAddress,
            String networkName,
            int networkCidr);

    Switch addNetworkToSwitch(Network network, Switch networkSwitch);

    Switch removeNetworkFromSwitch(String name, Switch networkSwitch);
}
