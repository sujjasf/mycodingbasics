package ComputerNetwork.unit3;

import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ProxySelector {

    public class InnerProxySelector extends ProxySelector {

        public final String proxyHost;
        public final int proxyPort;
        public final List<URI> failedList = new ArrayList<URI>();

        public localProxyServer(String host, int port) {
            this.proxyHost = host;
            this.proxyPort = port;
        }
        List<Proxy> proxies = new ArrayList<Proxy>();
        @Override
        public List<Proxy> select(URI uri) {
            if(uri == null) {
                throw new IllegalArgumentException("URI can't be null");
            }
            if(proxyHost.isEmpty() || proxyPort == null) {
                throw new IllegalStateException("Proxy host/port is not set");
            }
            SocketAddress address = new InetSocketAddress(proxyHost, proxyPort)
            proxy proxy = new Proxy(Proxy.Type.HTTP, address);
            proxies.add(proxy);
            return proxies;

            @Override
            public void connectionFailed(URI uri, SocketAddress sa, IOException ioe) {
                if(sa != null) {
                    if(!failedList.contains(ioe))
                }
            }
        }        
    }
    public static void main(String[] args) {
        
    }
    
}
