package com.flaxeninfosoft.guptaoffset.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.flaxeninfosoft.guptaoffset.views.employee.fragments.EmployeeAllAttendanceFragment;
import com.flaxeninfosoft.guptaoffset.views.employee.fragments.EmployeeAllClientsFragment;
import com.flaxeninfosoft.guptaoffset.views.employee.fragments.EmployeeAllExpenseFragment;
import com.flaxeninfosoft.guptaoffset.views.employee.fragments.EmployeeAllLeavesFragment;
import com.flaxeninfosoft.guptaoffset.views.employee.fragments.EmployeeAllOrdersFragment;
import com.flaxeninfosoft.guptaoffset.views.superEmployee.fragments.SuperEmployeeAllEmployeesFragment;

public class SuperEmployeeHomeFragmentStateAdapter extends FragmentStateAdapter {

    public SuperEmployeeHomeFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new EmployeeAllClientsFragment();
            case 1:
                return new EmployeeAllOrdersFragment();
            case 2:
                return new EmployeeAllExpenseFragment();
            case 3:
                return new EmployeeAllLeavesFragment();
            case 4:
                return new EmployeeAllAttendanceFragment();
            case 5:
                return new SuperEmployeeAllEmployeesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}