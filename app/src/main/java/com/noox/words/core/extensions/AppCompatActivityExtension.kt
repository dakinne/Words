import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun AppCompatActivity.initActionBar(@Nullable toolbar: Toolbar, block: ActionBar.() -> Unit = {}) {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        block()
    }
}

fun <T : ViewDataBinding> AppCompatActivity.initBinding(@LayoutRes layout: Int): T {
    return DataBindingUtil.setContentView(this, layout)
}
