package org.spoofer.jsonexamples;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import org.spoofer.jsonexamples.data.Member;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by rob on 13/03/2018.
 */

public class MemberPageFragment extends Fragment {

    public static final String ARG_MEMBER = "member";
    public static final String DATE_FORMAT = "yy-MM-dd";

    private Member member;


    /**
     * Bit of a hack, should pass in member via a Bundle.
     * @param member the Member this fragment displays
     */
    public void setArguments(Member member) {
        this.member = member;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        // Apply the member data onto a new Fragment layout.


        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.member_fragment, container, false);

        ((TextView) root.findViewById(R.id.txtFirstName)).setText(member.getFirstName());
        ((TextView) root.findViewById(R.id.txtSurname)).setText(member.getSurName());
        ((TextView) root.findViewById(R.id.txtGender)).setText(member.getGender());
        SimpleDateFormat dateFmt = new SimpleDateFormat(DATE_FORMAT);

        ((TextView) root.findViewById(R.id.txtBirthday)).setText(dateFmt.format(member.getBithday()));
        return root;
    }
}
