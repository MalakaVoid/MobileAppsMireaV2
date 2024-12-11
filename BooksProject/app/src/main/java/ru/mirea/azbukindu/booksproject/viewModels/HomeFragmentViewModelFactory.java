package ru.mirea.azbukindu.booksproject.viewModels;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class HomeFragmentViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;

    public HomeFragmentViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeFragmentViewModel(context);
    }

}
