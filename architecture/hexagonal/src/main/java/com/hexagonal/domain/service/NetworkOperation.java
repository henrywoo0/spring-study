package com.hexagonal.domain.service;

import com.hexagonal.domain.entity.Router;
import com.hexagonal.domain.vo.IP;
import com.hexagonal.domain.vo.Network;

public class NetworkOperation {

    private final int MINIMUM_ALLOWED_CIDR = 8;

    public void createNewNetwork(Router router, IP address, String name, int cidr) {
        if (cidr < MINIMUM_ALLOWED_CIDR)
            throw new IllegalArgumentException("CIDR must be below " + MINIMUM_ALLOWED_CIDR);

        if (!isNetworkAvaliable(router, address, cidr))
            throw new IllegalArgumentException("Address already exists");

        Network network = router.createNetwork(address, name, cidr);
        router.addNetworkToSwitch(network);
    }

    private boolean isNetworkAvaliable(Router router, IP address, int cidr) {
        var availability = true;

        for(Network network : router.retrieveNetworks()) {
            if (network.getAddress().equals(address) && network.getCidr() == cidr) {
                availability = false;
                break;
            }
        }

        return availability;
    }
}
