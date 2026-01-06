package ComputerNetwork.unit3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class LocalProxySelector extends ProxySelector {

    private final String proxyHost;
    private final int proxyPort;
    private final List<URI> failedUris = new ArrayList<>();

    public LocalProxySelector(String host, int port) {
        this.proxyHost = host;
        this.proxyPort = port;
    }

    @Override
    public List<Proxy> select(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("URI can't be null");
        }

        if (proxyHost == null || proxyHost.isEmpty() || proxyPort <= 0) {
            throw new IllegalStateException("Proxy host/port is not set");
        }

        List<Proxy> proxies = new ArrayList<>();
        SocketAddress address = new InetSocketAddress(proxyHost, proxyPort);
        proxies.add(new Proxy(Proxy.Type.HTTP, address));

        return proxies;
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        if (uri != null) {
            failedUris.add(uri);
            System.err.println("Connection failed for URI: " + uri);
        }
    }

    public static void main(String[] args) {
        ProxySelector selector = new LocalProxySelector("127.0.0.1", 8080);
        ProxySelector.setDefault(selector);
    }
}
