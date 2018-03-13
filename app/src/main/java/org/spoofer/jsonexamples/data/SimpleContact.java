package org.spoofer.jsonexamples.data;

/**
 * Created by rob on 13/03/2018.
 */

public class SimpleContact implements Contact {

    private String source;
    private String address;

    public SimpleContact(String source, String address) {
        this.source = source;
        this.address = address;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
