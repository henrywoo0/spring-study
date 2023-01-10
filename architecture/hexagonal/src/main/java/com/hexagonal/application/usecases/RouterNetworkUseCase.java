package com.hexagonal.application.usecases;

import com.hexagonal.domain.entity.Router;
import com.hexagonal.domain.vo.Network;
import com.hexagonal.domain.vo.RouterId;

public interface RouterNetworkUseCase {

    Router addNetworkToRouter(RouterId routerId, Network network);
}
