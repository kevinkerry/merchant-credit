package com.sdp.mc.msp.api.vo;

import java.io.Serializable;

public class ValidOrders implements Serializable {

	private static final long serialVersionUID = -8837630952608175191L;
	private Long orderId;

    private boolean selected;

    public ValidOrders() {
    }

    public ValidOrders(Long orderId, boolean selected) {
        this.orderId = orderId;
        this.selected = selected;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
