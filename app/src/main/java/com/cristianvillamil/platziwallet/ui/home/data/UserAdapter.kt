package com.cristianvillamil.platziwallet.ui.home.data

import com.cristianvillamil.platziwallet.ui.home.view.UserViewModel

class UserAdapter() {
    fun getUserViewModel(userResponse: UserResponse) : UserViewModel{
        return UserViewModel(userResponse.name,userResponse.userPhotoURL)
    }
}