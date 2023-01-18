module framework {
    requires domain;
    requires application;
    requires static lombok;
    requires org.eclipse.persistence.core;
    requires java.sql;
    requires jakarta.persistence;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    exports br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.data;
    opens br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.data;

    provides br.com.lissandrocunha.topologyinventory.application.ports.output.RouterManagementOutputPort
            with br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.RouterManagementH2Adapter;
    provides br.com.lissandrocunha.topologyinventory.application.ports.output.SwitchManagementOutputPort
            with br.com.lissandrocunha.topologyinventory.framework.adapters.output.h2.SwitchManagementH2Adapter;

    uses br.com.lissandrocunha.topologyinventory.application.usecases.RouterManagementUseCase;
    uses br.com.lissandrocunha.topologyinventory.application.usecases.SwitchManagementUseCase;
    uses br.com.lissandrocunha.topologyinventory.application.usecases.NetworkManagementUseCase;
    uses br.com.lissandrocunha.topologyinventory.application.ports.output.RouterManagementOutputPort;
    uses br.com.lissandrocunha.topologyinventory.application.ports.output.SwitchManagementOutputPort;


}