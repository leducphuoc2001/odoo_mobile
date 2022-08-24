package com.example.myapplication.contact;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Handle.ImageUtils;
import com.example.myapplication.R;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private final Context context;
    private final List<Contact> contactArrayList;

    public ContactAdapter(Context context, List<Contact> contactArrayList) {
        this.context = context;
        this.contactArrayList = contactArrayList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactArrayList.get(position);
        if (!contact.getName().equals(false)) {
            holder.txtName.setText((String) contact.getName());
        }
        if (!contact.getCompany_name().equals(false)) {
            holder.txtCompany.setText((String) contact.getCompany_name());
        }
        if (!contact.getEmail().equals(false)) {
            holder.txtEmail.setText((String) contact.getEmail());
        }
        if (!contact.getImage().equals(false)) {
            holder.imgAvatar.setImageBitmap(ImageUtils.getBitmapImage((String) contact.getImage()));
        }
        else {
            holder.imgAvatar.setImageResource(R.drawable.ic_launcher_background);
        }
        holder.layoutContact.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtName, txtEmail, txtCompany;
        private final ImageView imgAvatar;
        private final ConstraintLayout layoutContact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtCompany = itemView.findViewById(R.id.txtCompany);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            layoutContact = itemView.findViewById(R.id.layoutContact);
        }
    }
}
