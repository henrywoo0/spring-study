package com.hexagonal.domain.specification;

import com.hexagonal.domain.entity.Router;
import com.hexagonal.domain.specification.shared.AbstractSpecification;
import com.hexagonal.domain.vo.RouterType;

public class RouterTypeSpecification extends AbstractSpecification<Router> {

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.getRouterType().equals(RouterType.CORE) ||
                router.getRouterType().equals(RouterType.EDGE);
    }
}
