package com.example.dealeaze;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellFragment extends Fragment {

    TextView sTextViewProduct,sTextViewPrice,sTextViewDesc,sTextViewContact;
    EditText sEditTextProduct, sEditTextPrice, sEditTextDesc,sEditTextContact;
    Button sButtonSell;
    DatabaseReference sellReference;
    SellHelper sellHelper;

    private SellViewModel sellViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sell, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sTextViewProduct = (TextView) view.findViewById(R.id.textViewProduct);
        sTextViewDesc = (TextView) view.findViewById(R.id.textViewDescription);
        sTextViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
        sTextViewContact = (TextView) view.findViewById(R.id.textViewContact);

        sEditTextProduct = (EditText) view.findViewById(R.id.editTextProduct);
        sEditTextDesc = (EditText) view.findViewById(R.id.editTextDescription);
        sEditTextPrice = (EditText) view.findViewById(R.id.editTextPrice);
        sEditTextContact = (EditText) view.findViewById(R.id.editTextContact);

        sButtonSell = (Button) view.findViewById(R.id.buttonSell);

        sellHelper = new SellHelper();
        sellReference = FirebaseDatabase.getInstance().getReference().child("Items");

        sButtonSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sProduct = sEditTextProduct.getText().toString();
                String sDesc = sEditTextDesc.getText().toString();
                String sPrice = sEditTextPrice.getText().toString();
                String sContact = sEditTextContact.getText().toString();

                if (!sProduct.equals("") || !sDesc.equals("") || !sPrice.equals("") || !sContact.equals("")) {
                    if(sContact.length() == 10) {
                        sellHelper.setProduct(sProduct);
                        sellHelper.setDescription(sDesc);
                        sellHelper.setPrice(sPrice);
                        sellHelper.setContact(sContact);

                        sellReference.push().setValue(sellHelper);
                        Toast.makeText(getActivity(), "Product Added!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Please enter 10 digits", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Fill all boxes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





