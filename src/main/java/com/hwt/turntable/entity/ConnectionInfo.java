package com.hwt.turntable.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ConnectionInfo {

    private String ipString;

    private int port;

    private String host;


    public static final class ConnectionInfoBuilder {
        private String ipString;
        private int port;
        private String host;

        public ConnectionInfoBuilder() {
        }

        public static ConnectionInfoBuilder aConnectionInfo() {
            return new ConnectionInfoBuilder();
        }

        public ConnectionInfoBuilder setIpString(String ipString) {
            this.ipString = ipString;
            return this;
        }

        public ConnectionInfoBuilder setPort(int port) {
            this.port = port;
            return this;
        }

        public ConnectionInfoBuilder setHost(String host) {
            this.host = host;
            return this;
        }

        public ConnectionInfo build() {
            ConnectionInfo connectionInfo = new ConnectionInfo();
            connectionInfo.setIpString(ipString);
            connectionInfo.setPort(port);
            connectionInfo.setHost(host);
            return connectionInfo;
        }
    }
}
