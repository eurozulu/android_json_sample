package org.spoofer.jsonexamples.data;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by rob on 13/03/2018.
 */

public class SimpleMember implements Member {

    private final String firstName;
    private final String surName;
    private final Date bithday;
    private final String gender;
    private final List<Contact> contacts;
    

    public SimpleMember(String firstName, String surName, Date bithday, String gender, List<Contact> contacts) {
        this.firstName = firstName;
        this.surName = surName;
        this.bithday = bithday;
        this.gender = gender;
        this.contacts = Collections.unmodifiableList(contacts); // Make contact list read only
    }


    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
    public Date getBithday() {
        return bithday;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return firstName + surName;
    }


}
