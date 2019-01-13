package com.example.paulap.crowdsourcing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.paulap.crowdsourcing.Models.Event;
import com.example.paulap.crowdsourcing.Models.User;
import com.example.paulap.crowdsourcing.R;

import java.util.List;
import java.util.Objects;

public class InviteAdapter extends ArrayAdapter<User> {

    private List<User> users;
    private Context context;

    public InviteAdapter(Context context, List<User> users) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
    }



    public View getView(int	position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater	= (LayoutInflater)	context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myRow	=	(convertView	==	null)	? Objects.requireNonNull(inflater).inflate(R.layout.friend_invite_item,	parent,	false)	:	convertView;

        CheckBox name = myRow.findViewById(R.id.friendInviteCheck);
        name.setText(users.get(position).getUsername());
        return	myRow;
    }
}