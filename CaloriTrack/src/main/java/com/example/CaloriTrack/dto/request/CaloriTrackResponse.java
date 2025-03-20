package com.example.CaloriTrack.dto.request;

import com.example.CaloriTrack.dto.request.dish.DishDTO;
import com.example.CaloriTrack.dto.request.user.UserDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CaloriTrackResponse {

    private List<UserDTO> users;
    private List<DishDTO> dishes;
    private List<Errors> errorList;

    public void addErrorList(Errors error) {
        if (this.errorList == null) {
            this.errorList = new ArrayList<>();
        }
        this.errorList.add(error);
    }
}