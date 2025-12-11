package com.example.firstjcomposeproject.di

import androidx.lifecycle.ViewModel
import com.example.firstjcomposeproject.ui.viewmodel.CommentsViewModel
import com.example.firstjcomposeproject.ui.viewmodel.LoginViewModel
import com.example.firstjcomposeproject.ui.viewmodel.MainViewModel
import com.example.firstjcomposeproject.ui.viewmodel.PostCardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {


    @IntoMap
    @ViewModelKey(CommentsViewModel::class)
    @Binds
    fun bindCommentsViewModel(viewModel: CommentsViewModel): ViewModel


    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    @Binds
    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel


    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel


    @IntoMap
    @ViewModelKey(PostCardViewModel::class)
    @Binds
    fun bindPostCardViewModel(viewModel: PostCardViewModel): ViewModel
}