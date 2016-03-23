package com.dorukkangal.android.mvp.contact;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dorukkangal.android.library.dao.Contact;
import com.dorukkangal.android.mvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by polata on 22/03/2016.
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHolder> {

    public interface ItemActionListener {

        void onCall(String phone);

        void onSendEmail(String email);

        void onDelete(String name);
    }

    private List<Contact> contacts;

    private ItemActionListener listener;

    public ContactListAdapter(ItemActionListener listener) {
        this(new ArrayList<Contact>(), listener);
    }

    public ContactListAdapter(List<Contact> contacts, ItemActionListener listener) {
        this.contacts = contacts;
        this.listener = listener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_contact, parent, false);

        return new ContactViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        final Contact contact = contacts.get(position);

        holder.textViewName.setText(contact.getName());
        holder.textViewName.setTag(contact);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public boolean deleteItem(String name) {

        int position = 0;

        for (Contact contact : contacts) {
            if (TextUtils.equals(contact.getName(), name)) {
                contacts.remove(contact);
                notifyItemRemoved(position);
                return true;
            }

            position++;
        }

        return false;
    }

    public void addItems(List<Contact> contacts) {
        this.contacts.addAll(contacts);
        notifyDataSetChanged();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        ImageButton imageButtonCall;
        ImageButton imageButtonEmail;
        ImageButton imageButtonDelete;

        private ContactListAdapter.ItemActionListener listener;

        public ContactViewHolder(View itemView, ContactListAdapter.ItemActionListener listener) {
            super(itemView);
            this.listener = listener;

            textViewName = (TextView) itemView.findViewById(R.id.list_item_contact_text_view_name);
            imageButtonCall = (ImageButton) itemView.findViewById(R.id.list_item_contact_button_call);
            imageButtonEmail = (ImageButton) itemView.findViewById(R.id.list_item_contact_button_email);
            imageButtonDelete = (ImageButton) itemView.findViewById(R.id.list_item_contact_button_delete);

            imageButtonCall.setOnClickListener(this);
            imageButtonEmail.setOnClickListener(this);
            imageButtonDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Contact contact = (Contact) textViewName.getTag();
            if (v.getId() == imageButtonCall.getId()) {
                listener.onCall(contact.getPhone());
            } else if (v.getId() == imageButtonEmail.getId()) {
                listener.onSendEmail(contact.getEmail());
            } else if (v.getId() == imageButtonDelete.getId()) {
                listener.onDelete(contact.getName());
            }
        }
    }
}
