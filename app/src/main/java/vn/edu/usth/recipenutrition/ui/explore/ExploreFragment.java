package vn.edu.usth.recipenutrition.ui.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import vn.edu.usth.recipenutrition.databinding.FragmentExploreBinding;
import vn.edu.usth.recipenutrition.R;
import android.util.Log;

public class ExploreFragment extends Fragment {

    private FragmentExploreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExploreViewModel exploreViewModel =
                new ViewModelProvider(this).get(ExploreViewModel.class);

        binding = FragmentExploreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textExplore;
        exploreViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Add MenuProvider after view creation
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.search_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_search) {
                    // Handle search item click here
                    return true;
                }
                return false;
            }
        }, getViewLifecycleOwner());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SearchView searchView = view.findViewById(R.id.action_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission here
                performSearch(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                // Leave this empty for now
                return true;
            }
        });
    }

    private void performSearch(String query) {
        if (query != null) {
            Log.d("ExploreFragment", "Search performed for query: " + query);
            // This for testing if the search functionality works
        }
    }
}