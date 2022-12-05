package com.hnm.template;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Admin on 12/1/2022.
 */
public class JsonUtils {
    public static final Gson gson = new GsonBuilder().serializeNulls().create();
    public static final ObjectMapper mapper = new ObjectMapper();

}
