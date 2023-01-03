package br.com.lissandrocunha.topologyinventory.application.usecases;

import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.IP;
import br.com.lissandrocunha.topologyinventory.domain.vo.Network;

public interface NetworkManagementUseCase {

    Network createNetwork(
            IP networkAddress,
            String networkName,
            int networkCidr);


    Switch addNetworkToSwitch(Network network, Switch networkSwitch);

    Switch removeNetworkFromSwitch(Network network, Switch networkSwitch);
}
