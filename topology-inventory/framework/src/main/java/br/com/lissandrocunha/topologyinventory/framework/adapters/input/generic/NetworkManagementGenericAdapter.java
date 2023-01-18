package br.com.lissandrocunha.topologyinventory.framework.adapters.input.generic;

import br.com.lissandrocunha.topologyinventory.application.ports.input.NetworkManagementInputPort;
import br.com.lissandrocunha.topologyinventory.application.ports.input.SwitchManagementInputPort;
import br.com.lissandrocunha.topologyinventory.application.usecases.NetworkManagementUseCase;
import br.com.lissandrocunha.topologyinventory.application.usecases.SwitchManagementUseCase;
import br.com.lissandrocunha.topologyinventory.domain.entity.Switch;
import br.com.lissandrocunha.topologyinventory.domain.vo.Id;
import br.com.lissandrocunha.topologyinventory.domain.vo.Network;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.RouterManagementH2Adapter;
import br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.SwitchManagementH2Adapter;

public class NetworkManagementGenericAdapter {

    private SwitchManagementUseCase switchManagementUseCase;
    private NetworkManagementUseCase networkManagementUseCase;

    public NetworkManagementGenericAdapter(){
        setPorts();
    }

    private void setPorts(){
        this.switchManagementUseCase = new SwitchManagementInputPort(SwitchManagementH2Adapter.getInstance());
        this.networkManagementUseCase = new NetworkManagementInputPort(RouterManagementH2Adapter.getInstance());
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
