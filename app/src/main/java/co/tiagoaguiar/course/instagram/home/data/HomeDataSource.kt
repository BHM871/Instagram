package co.tiagoaguiar.course.instagram.home.data

import co.tiagoaguiar.course.instagram.common.base.RequestCallback
import co.tiagoaguiar.course.instagram.common.model.Post
import co.tiagoaguiar.course.instagram.common.model.UserAuth

interface HomeDataSource {

    fun fetchFeed(userUUID: String, callback: RequestCallback<List<Post>>)
    fun liked(post: Post, liked: Boolean)

    fun fetchSession() : String { throw UnsupportedOperationException("User not found") }
    fun putFeed(response: List<Post>) { throw UnsupportedOperationException("User not found") }
    fun removeCache() { throw UnsupportedOperationException("User not found") }

}