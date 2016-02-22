package com.nahoy.minion.binding;

import com.nahoy.minion.exception.ViewError;

public interface View<Model> {
    void showModel(Model model);

    void showError(ViewError viewError);
}
