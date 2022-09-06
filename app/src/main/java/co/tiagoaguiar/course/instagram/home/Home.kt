package co.tiagoaguiar.course.instagram.home

import co.tiagoaguiar.course.instagram.common.base.BasePresenter
import co.tiagoaguiar.course.instagram.common.base.BaseView
import co.tiagoaguiar.course.instagram.common.model.Post

interface Home {

    interface Presenter : BasePresenter{
        fun fetchFeed()
        fun liked(post: Post, liked: Boolean)
        fun clear()
    }

    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)

        fun displayRequestFailure(message: String)

        fun displayEmptyFeed()
        fun displayFullFeed(posts: List<Post>)
    }

}