package com.example.myapplication.Handle;


import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class OdooConnect {
    private final String url;
    private final XmlRpcClient client;

    public OdooConnect(String serverAddress, String path) throws MalformedURLException {
        url = serverAddress + "/xmlrpc/2/" + path;

        client = new XmlRpcClient();
        client.setConfig(new XmlRpcClientConfigImpl() {{
            setServerURL(new URL(url));
        }});
    }
    public Object signIn(String db, String username, String password) throws XmlRpcException {
        Object object = null;
        object = client.execute("login", asList(db, username, password));
        return object;
    }
    public Object getProfile(String db, String password, int id) throws XmlRpcException {
        Object object = null;
        object = client.execute("execute_kw", asList(
                db, id, password,
                "res.users", "search_read",
                asList(asList(
                        asList("id", "=", id))),
                new HashMap() {{
                    put("fields", asList("name", "email", "id", "image_128"));
                }}
        ));
        return object;
    }
    public Object checkServer() {
        Object object = null;
        try {
            object = client.execute("list", emptyList());
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return object;
    }

    public Object getContact(String db, int id, String password) {
        Object object = null;
        try {
            object = client.execute("execute_kw", asList(
                    db, id, password,
                    "res.partner", "search_read",
                    emptyList(),
                    new HashMap() {{
                        put("fields",
                                asList("name", "email", "company_name", "image_128"));
                    }}
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return object;
    }
}
