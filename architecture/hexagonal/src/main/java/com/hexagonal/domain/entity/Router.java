package com.hexagonal.domain.entity;

import com.hexagonal.domain.vo.IP;
import com.hexagonal.domain.vo.Network;
import com.hexagonal.domain.vo.RouterId;
import com.hexagonal.domain.vo.RouterType;

import java.util.List;
import java.util.function.Predicate;

public class Router {

    private final RouterType routerType;
    private final RouterId routerId;
    private Switch networkSwitch;

    public Router(RouterType routerType, RouterId routerId) {
        this.routerType = routerType;
        this.routerId = routerId;
    }

    public static Predicate<Router> filterRouterByType(RouterType routerType) {
        return routerType.equals(RouterType.CORE) ? Router.isCore() : Router.isEdge();
    }

    public static Predicate<Router> isCore() {
        return p -> p.getRouterType() == RouterType.CORE;
    }

    public static Predicate<Router> isEdge() {
        return p -> p.getRouterType() == RouterType.EDGE;
    }

    public void addNetworkToSwitch(Network network) {
        this.networkSwitch = networkSwitch.addNetwork(network);
    }

    public Network createNetwork(IP address, String name, int cidr) {
        return new Network(address, name, cidr);
    }

    public List<Network> retrieveNetworks() {
        return networkSwitch.getNetworks();
    }

    public RouterType getRouterType() {
        return routerType;
    }

    @Override
    public String toString() {
        return "Router{" + "type=" + routerType + ", id=" + routerId + '}';
    }
}
