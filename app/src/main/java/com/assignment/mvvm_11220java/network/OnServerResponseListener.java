package com.assignment.mvvm_11220java.network;

import org.json.JSONArray;

public interface OnServerResponseListener {

    void OnServerResponse(boolean isSuccess, JSONArray response);

}

