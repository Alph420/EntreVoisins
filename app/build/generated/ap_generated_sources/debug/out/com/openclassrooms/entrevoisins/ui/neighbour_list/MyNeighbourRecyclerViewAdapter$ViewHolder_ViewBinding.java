// Generated code from Butter Knife. Do not modify!
package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.openclassrooms.entrevoisins.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyNeighbourRecyclerViewAdapter$ViewHolder_ViewBinding<T extends MyNeighbourRecyclerViewAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public MyNeighbourRecyclerViewAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.mNeighbourAvatar = Utils.findRequiredViewAsType(source, R.id.item_list_avatar, "field 'mNeighbourAvatar'", ImageView.class);
    target.mNeighbourName = Utils.findRequiredViewAsType(source, R.id.item_list_name, "field 'mNeighbourName'", TextView.class);
    target.mDeleteButton = Utils.findRequiredViewAsType(source, R.id.item_list_delete_button, "field 'mDeleteButton'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mNeighbourAvatar = null;
    target.mNeighbourName = null;
    target.mDeleteButton = null;

    this.target = null;
  }
}
