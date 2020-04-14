// Generated code from Butter Knife. Do not modify!
package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.openclassrooms.entrevoisins.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddNeighbourActivity_ViewBinding<T extends AddNeighbourActivity> implements Unbinder {
  protected T target;

  private View view2131230783;

  @UiThread
  public AddNeighbourActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.avatar = Utils.findRequiredViewAsType(source, R.id.avatar, "field 'avatar'", ImageView.class);
    target.nameInput = Utils.findRequiredViewAsType(source, R.id.nameLyt, "field 'nameInput'", TextInputLayout.class);
    target.phoneInput = Utils.findRequiredViewAsType(source, R.id.phoneNumberLyt, "field 'phoneInput'", TextInputLayout.class);
    target.addressInput = Utils.findRequiredViewAsType(source, R.id.addressLyt, "field 'addressInput'", TextInputLayout.class);
    target.aboutMeInput = Utils.findRequiredViewAsType(source, R.id.aboutMeLyt, "field 'aboutMeInput'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.create, "field 'addButton' and method 'addNeighbour'");
    target.addButton = Utils.castView(view, R.id.create, "field 'addButton'", MaterialButton.class);
    view2131230783 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addNeighbour();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.avatar = null;
    target.nameInput = null;
    target.phoneInput = null;
    target.addressInput = null;
    target.aboutMeInput = null;
    target.addButton = null;

    view2131230783.setOnClickListener(null);
    view2131230783 = null;

    this.target = null;
  }
}
