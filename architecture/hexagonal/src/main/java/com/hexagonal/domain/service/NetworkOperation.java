package com.hexagonal.domain.service;

import com.hexagonal.domain.entity.Router;
import com.hexagonal.domain.specification.CIDRSpecification;
import com.hexagonal.domain.specification.NetworkAmountSpecification;
import com.hexagonal.domain.specification.NetworkAvailabilitySpecification;
import com.hexagonal.domain.specification.RouterTypeSpecification;
import com.hexagonal.domain.vo.IP;
import com.hexagonal.domain.vo.Network;

public class NetworkOperation {

    public void createNewNetwork(Router router, IP address, String name, int cidr) {

        var availabilitySpec = new NetworkAvailabilitySpecification(address, name, cidr);
        var cidrSpec = new CIDRSpecification();
        var routerTypeSpec = new RouterTypeSpecification();
        var amountSpec = new NetworkAmountSpecification();

        if (cidrSpec.isSatisfiedBy(cidr)) {
            throw new IllegalArgumentException("CIDR is below" + CIDRSpecification.MINIMUM_ALLOWED_CIDR);
        }

        if (availabilitySpec.isSatisfiedBy(router)) {
            throw new IllegalArgumentException("Address already exists");
        }

        if (amountSpec.and(routerTypeSpec).isSatisfiedBy(router)) {
            Network network = router.createNetwork(address, name, cidr);
            router.addNetworkToSwitch(network);
        }
    }
}
