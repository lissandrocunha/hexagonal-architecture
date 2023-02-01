module application{
    requires domain;
    requires static lombok;
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;
    requires arc;

    exports br.com.lissandrocunha.topologyinventory.application.ports.output;
    exports br.com.lissandrocunha.topologyinventory.application.ports.input;
    exports br.com.lissandrocunha.topologyinventory.application.usecases;

    provides br.com.lissandrocunha.topologyinventory.application.usecases.RouterManagementUseCase
            with br.com.lissandrocunha.topologyinventory.application.ports.input.RouterManagementInputPort;
    provides br.com.lissandrocunha.topologyinventory.application.usecases.SwitchManagementUseCase
            with br.com.lissandrocunha.topologyinventory.application.ports.input.SwitchManagementInputPort;
    provides br.com.lissandrocunha.topologyinventory.application.usecases.NetworkManagementUseCase
            with br.com.lissandrocunha.topologyinventory.application.ports.input.NetworkManagementInputPort;
}