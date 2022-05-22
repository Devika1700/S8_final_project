package com.example.programmingknowledge.image_to_text;

import com.example.programmingknowledge.image_to_text.Models.APIResponse;

public interface OnFetchDataListener {

    void onFetchData(APIResponse apiResponse,String message);
    void onError(String message);
}
