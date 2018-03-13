package org.spoofer.jsonexamples.data;

/**
 * Created by rob on 13/03/2018.
 */

public interface Contact {

    /**
     * Gets the source of the contact, email, mobile, home phone etc
     * @return source of contact
     */
    public String getSource();

    /**
     * Gets the actual contact adress data.  Address can be a phone number, email address, location address etc.
     * @return
     */
    public String getAddress();
}
