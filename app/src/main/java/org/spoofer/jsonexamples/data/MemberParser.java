package org.spoofer.jsonexamples.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rob on 13/03/2018.
 */

public class MemberParser extends JsonBase {

    public static final String JSON_OBJECT_MEMBERS = "members";
    public static final String JSON_OBJECT_CONTACTS = "contacts";

    public static final String JSON_FIRSTNAME = "first-name";
    public static final String JSON_SURNAME = "surname";
    public static final String JSON_GENDER = "gender";
    public static final String JSON_BIRTHDAY = "birthday";

    private Member[] members;

    public MemberParser(InputStream src) throws JSONException, IOException {
        JSONObject jObj = openJson(src);
        members = parseMembers(jObj);
    }


    public Member[] getMembers() {
        return members;
    }


    private Member[] parseMembers(JSONObject parser) throws JSONException {

        JSONArray jArray = parser.getJSONArray(JSON_OBJECT_MEMBERS);
        int len = jArray.length();
        List<Member> members = new ArrayList<>(len);

        for (int index = 0; index < len; index++) {
            JSONObject member = jArray.getJSONObject(index);
            members.add(parserMember(member));
        }
        Member[] mBuff = new Member[members.size()];
        members.toArray(mBuff);
        return mBuff;
    }

    private Member parserMember(JSONObject jsonMember) throws JSONException {
        String firstName = jsonMember.getString(JSON_FIRSTNAME);
        String surName = jsonMember.getString(JSON_SURNAME);
        String gender = jsonMember.getString(JSON_GENDER);
        Date birthday = new Date(jsonMember.getLong(JSON_BIRTHDAY));
        List<Contact> contacts = parseContacts(jsonMember.getJSONObject(JSON_OBJECT_CONTACTS));

        return new SimpleMember(firstName, surName, birthday, gender, contacts);
    }

    private List<Contact> parseContacts(JSONObject jsonContacts) throws JSONException {
        List<Contact> contacts = new ArrayList<>();
        Iterator<String> keys = jsonContacts.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = jsonContacts.optString(key);
            contacts.add(new SimpleContact(key, value));
        }

        return contacts;
    }
}