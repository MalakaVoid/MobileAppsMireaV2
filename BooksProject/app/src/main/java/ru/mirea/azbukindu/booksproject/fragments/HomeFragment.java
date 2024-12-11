package ru.mirea.azbukindu.booksproject.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.azbukindu.booksproject.R;
import ru.mirea.azbukindu.booksproject.recycleAdapters.AllBooksAdapter;
import ru.mirea.azbukindu.booksproject.viewModels.HomeFragmentViewModel;
import ru.mirea.azbukindu.booksproject.viewModels.HomeFragmentViewModelFactory;
import ru.mirea.azbukindu.domain.models.Book;

public class HomeFragment extends Fragment {

    private HomeFragmentViewModel viewModel;
    private RecyclerView recyclerView;
    private AllBooksAdapter allBooksAdapter;
    private List<Book> allBooks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.booksCardsWrapper);
        allBooks = new ArrayList<>();
        allBooksAdapter = new AllBooksAdapter(allBooks);

        recyclerView.setAdapter(allBooksAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        viewModel = new ViewModelProvider(this, new HomeFragmentViewModelFactory(requireContext()))
                .get(HomeFragmentViewModel.class);

        viewModel.getAllBooksLiveData().observe(requireActivity(), books -> {
            allBooks.clear();
            allBooks.addAll(books);
            allBooksAdapter.notifyDataSetChanged();
        });

        viewModel.getAllBooks();
    }
}