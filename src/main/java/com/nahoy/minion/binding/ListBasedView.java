package com.nahoy.minion.binding;

import java.util.List;

public interface ListBasedView<Model extends List> extends View<Model> {
    void showMore(Model list);
}
