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
        }