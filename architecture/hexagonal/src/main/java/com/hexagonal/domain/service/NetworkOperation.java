package com.hexagonal.domain.service;

import com.hexagonal.domain.entity.Router;
import com.hexagonal.domain.specification.CIDRSpecification;
import com.hexagonal.domain.specification.NetworkAmountSpecification;
import com.hexagonal.domain.specification.NetworkAvailabilitySpecification;
import com.hexagonal.domain.specification.RouterTypeSpecification;
import com.hexagonal.domain.vo.IP;
import com.hexagonal.domain.vo.Network;

public class NetworkOperation {

    public static Router createNewNetwork(Router router, Network network) {
        var availabilitySpec = new NetworkAvailabilitySpecification(network.getAddress(), network.getName(), network.getCidr());
        var cidrSpec = new CIDRSpecification();
        var routerTypeSpec = new RouterTypeSpecification();
        var amountSpec = new NetworkAmountSpecification();

        if(cidrSpec.isSatisfiedBy(network.getCidr()))
            throw new IllegalArgumentException("CIDR is below "+CIDRSpecification.MINIMUM_ALLOWED_CIDR);

        if(!availabilitySpec.isSatisfiedBy(router))
            throw new IllegalArgumentException("Address already exist");

        if(amountSpec.and(routerTypeSpec).isSatisfiedBy(router)) {
            Network newNetwork = router.createNetwork(network.getAddress(), network.getName(), network.getCidr());
            router.addNetworkToSwitch(newNetwork);
        }
        return router;
    }
}
