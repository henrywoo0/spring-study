package com.hexagonal.application.ports.output;

import com.hexagonal.domain.entity.Router;
import com.hexagonal.domain.vo.RouterId;

public interface RouterNetworkOutputPort {
    Router fetchRouterById(RouterId routerId);
    boolean persistRouter(Router router);
}
