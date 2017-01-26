/*
 * Copyright © 2017 Denis Shurygin. All rights reserved.
 * Licensed under the Apache License, Version 2.0
 */

package ru.pocketbyte.locolazer.example;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        ((TextView) findViewById(R.id.txtPluralExample1))
                .setText(res.getQuantityString(R.plurals.screen_main_plural_string, 25, 25));

        ((TextView) findViewById(R.id.txtPluralExample2))
                .setText(res.getQuantityString(R.plurals.screen_main_plural_string, 1, 1));

        ((TextView) findViewById(R.id.txtPluralExample3))
                .setText(res.getQuantityString(R.plurals.screen_main_plural_string, 0, 0));

        ((TextView) findViewById(R.id.txtPluralExample4))
                .setText(res.getQuantityString(R.plurals.screen_main_plural_string, 32, 32));
    }
}
