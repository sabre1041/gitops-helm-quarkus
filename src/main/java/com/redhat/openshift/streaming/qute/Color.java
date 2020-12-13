package com.redhat.openshift.streaming.qute;

public enum Color {

    RED("#ff4040"), GREEN("#77dd77"), BLUE("#03cffc");

    public final String hex;

    Color(String hex) {
        this.hex = hex;
    }

    public String toHex() {
        return this.hex;
    }

}
