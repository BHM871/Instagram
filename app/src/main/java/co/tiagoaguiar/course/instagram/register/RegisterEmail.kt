package co.tiagoaguiar.course.instagram.register

import androidx.annotation.StringRes
import co.tiagoaguiar.course.instagram.common.base.BasePresenter
import co.tiagoaguiar.course.instagram.common.base.BaseView

interface RegisterEmail {

    interface Presenter : BasePresenter{
        fun create(email: String)
    }

    interface View : BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun goToNamePasswordScreen(email: String)
        fun displayEmailFailure(@StringRes messageError: Int?)
        fun onEmailError(message: String)
    }

}