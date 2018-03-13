package org.spoofer.jsonexamples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.spoofer.jsonexamples.data.Member;
import org.spoofer.jsonexamples.data.MemberParser;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = (ViewPager) findViewById(R.id.pager);

        MemberParser parser = null;
        try {
            parser = new MemberParser(getResources().openRawResource(R.raw.samplejson));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        MemberAdapter adapter = new MemberAdapter(getSupportFragmentManager(), parser.getMembers());
        vPager.setAdapter(adapter);

    }


    private void parseJson(URL src) throws IOException {

    }


    /**
     * A simple pager adapter, shows Member pagers in list
     */
    private class MemberAdapter extends FragmentStatePagerAdapter {

        private final Member[] members;

        public MemberAdapter(FragmentManager fm, Member[] members) {
            super(fm);
            this.members = members;
        }

        @Override
        public Fragment getItem(int position) {
            MemberPageFragment item = new MemberPageFragment();
            if (position >= 0 && position < members.length)
                item.setArguments(members[position]);

            return item;
        }

        @Override
        public int getCount() {
            return members.length;
        }
    }
}
