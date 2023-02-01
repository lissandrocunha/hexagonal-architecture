package br.com.lissandrocunha.topologyinventory.framework.adapters.input.generic;

import br.com.lissandrocunha.topologyinventory.application.usecases.NetworkManagementUseCase;
import br.com.lissandrocunha.topologyinventory.application.usecases.SwitchManagementUseCase;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.Id;
import br.com.lissandrocunha.topologyinventory.domain.vo.Network;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NetworkManagementGenericAdapter {

    @Inject
    private SwitchManagementUseCase switchManagementUseCase;
    @Inject
    private NetworkManagementUseCase networkManagementUseCase;

    public NetworkManagementGenericAdapter(
            SwitchManagementUseCase switchManagementUseCase, NetworkManagementUseCase networkManagementUseCase) {
        this.switchManagementUseCase = switchManagementUseCase;
        this.networkManagementUseCase = networkManagementUseCase;
    }

    /**
     * POST /network/add
     * */
    public Switch addNetworkToSwitch(Network network, Id switchId) {
        Switch networkSwitch = switchManagementUseCase.retrieveSwitch(switchId);
        return networkManagementUseCase.addNetworkToSwitch(network, networkSwitch);
    }

    /**
     * POST /network/remove
     * */
    public Switch removeNetworkFromSwitch(String networkName, Id switchId) {
        Switch networkSwitch = switchManagementUseCase.retrieveSwitch(switchId);
        return networkManagementUseCase.removeNetworkFromSwitch(networkName, networkSwitch);
    }
}
