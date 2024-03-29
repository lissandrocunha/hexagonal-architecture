module framework {
    requires domain;
    requires application;
    requires static lombok;
    requires org.eclipse.persistence.core;
    requires java.sql;
    requires jakarta.persistence;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires jakarta.enterprise.cdi.api;
    requires jakarta.inject.api;
    requires java.ws.rs;
    requires io.smallrye.mutiny;
    requires java.xml.bind;
    requires smallrye.common.annotation;
    requires com.fasterxml.jackson.annotation;
    requires microprofile.openapi.api;

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