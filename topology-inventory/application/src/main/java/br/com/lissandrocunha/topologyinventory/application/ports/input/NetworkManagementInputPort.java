package br.com.lissandrocunha.topologyinventory.application.ports.input;

import br.com.lissandrocunha.topologyinventory.application.usecases.NetworkManagementUseCase;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.IP;
import br.com.lissandrocunha.topologyinventory.domain.vo.Network;

public class NetworkManagementInputPort implements NetworkManagementUseCase {
    @Override
    public Network createNetwork(IP networkAddress, String networkName, int networkCidr) {
        return Network
                .builder()
                .networkAddress(networkAddress)
                .networkName(networkName)
                .networkCidr(networkCidr)
                .build();
    }

    @Override
    public Switch addNetworkToSwitch(Network network, Switch networkSwitch) {
        networkSwitch.addNetworkToSwitch(network);
        return networkSwitch;
    }

    @Override
    public Switch removeNetworkFromSwitch(Network network, Switch networkSwitch) {
        networkSwitch.removeNetworkFromSwitch(network);
        return networkSwitch;
    }
}
