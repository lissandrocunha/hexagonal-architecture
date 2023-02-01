package br.com.lissandrocunha.topologyinventory.application.routers;


import br.com.lissandrocunha.topologyinventory.application.ApplicationTestData;
import br.com.lissandrocunha.topologyinventory.domain.entity.CoreRouter;
import br.com.lissandrocunha.topologyinventory.domain.entity.EdgeRouter;
import br.com.lissandrocunha.topologyinventory.domain.vo.IP;
import br.com.lissandrocunha.topologyinventory.domain.vo.Model;
import br.com.lissandrocunha.topologyinventory.domain.vo.Vendor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static br.com.lissandrocunha.topologyinventory.domain.vo.RouterType.CORE;
import static br.com.lissandrocunha.topologyinventory.domain.vo.RouterType.EDGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RouterAdd extends ApplicationTestData {

    CoreRouter anotherCoreRouter;

    public RouterAdd(){
        loadData();
    }
    //Adding an edge router to a core router
    @Given("I have an edge router")
    public void assert_edge_router_exists(){
        edgeRouter = (EdgeRouter) this.routerManagementUseCase.createRouter(
                null,
                Vendor.HP,
                Model.XYZ0004,
                IP.fromAddress("20.0.0.1"),
                locationA,
                EDGE
        );
        assertNotNull(edgeRouter);
    }
    @And("I have a core router")
    public void assert_core_router_exists(){
        coreRouter = (CoreRouter) this.routerManagementUseCase.createRouter(
                null,
                Vendor.CISCO,
                Model.XYZ0001,
                IP.fromAddress("30.0.0.1"),
                locationA,
                CORE
        );
        assertNotNull(coreRouter);
    }
    @Then("I add an edge router to a core router")
    public void add_edge_to_core_router(){
        var actualEdgeId = edgeRouter.getId();
        var routerWithEdge = (CoreRouter) this.routerManagementUseCase.
                addRouterToCoreRouter(edgeRouter, coreRouter);
        var expectedEdgeId = routerWithEdge.getRouters().get(actualEdgeId).getId();
        assertEquals(actualEdgeId, expectedEdgeId);
    }
    //Adding a core router to another core router
    @Given("I have this core router")
    public void assert_this_core_router_exists(){
        coreRouter = (CoreRouter) this.routerManagementUseCase.createRouter(
                null,
                Vendor.CISCO,
                Model.XYZ0001,
                IP.fromAddress("30.0.0.1"),
                locationA,
                CORE
        );
        assertNotNull(coreRouter);
    }
    @And("I have another core router")
    public void assert_another_core_router_exists(){
        anotherCoreRouter = (CoreRouter) this.routerManagementUseCase.createRouter(
                null,
                Vendor.CISCO,
                Model.XYZ0001,
                IP.fromAddress("40.0.0.1"),
                locationA,
                CORE
        );
        assertNotNull(anotherCoreRouter);
    }
    @Then("I add a core router to another core router")
    public void add_core_to_core_router(){
        var coreRouterId = coreRouter.getId();
        var routerWithCore = (CoreRouter) this.routerManagementUseCase.
                addRouterToCoreRouter(coreRouter, anotherCoreRouter);
        var expectedCoreId = routerWithCore.
                getRouters().get(coreRouterId).getId();
        assertEquals(coreRouterId, expectedCoreId);
    }
}
