package com.order.domain;

public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        if (!state.isShippingChangeable()) {
            throw new IllegalStateException("can't change shipping in " + state);
        }
        this.shippingInfo = shippingInfo;
    }

    public void changeShipped() {
        this.state = OrderState.SHIPPED;
    }
}
