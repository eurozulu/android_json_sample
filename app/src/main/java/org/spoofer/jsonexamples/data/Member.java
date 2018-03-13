package org.spoofer.jsonexamples.data;

import java.util.Date;
import java.util.List;

/**
 * Created by rob on 13/03/2018.
 */

public interface Member {

    public String getFirstName();

    public String getSurName();

    public Date getBithday();

    public String getGender();

    public List<Contact> getContacts();


}
