module application{
    exports br.com.lissandrocunha.topologyinventory.application.ports.output;
    exports br.com.lissandrocunha.topologyinventory.application.ports.input;
    exports br.com.lissandrocunha.topologyinventory.application.usecases;
    requires domain;
    requires static lombok;
}