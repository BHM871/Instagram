package co.tiagoaguiar.course.instagram.profile.data

import co.tiagoaguiar.course.instagram.common.base.Cache
import co.tiagoaguiar.course.instagram.common.base.RequestCallback
import co.tiagoaguiar.course.instagram.common.model.Database
import co.tiagoaguiar.course.instagram.common.model.Photo
import co.tiagoaguiar.course.instagram.common.model.Post
import co.tiagoaguiar.course.instagram.common.model.UserAuth

class ProfileLocalDataSource(
    private val profileUserCache: Cache<UserAuth>,
    private val profilePhotoCache: Cache<Photo>,
    private val profilePostCache: Cache<List<Post>>
) : ProfileDataSource {

    override fun fetchUserProfile(userUUID: String, callback: RequestCallback<UserAuth>) {
        val userAuth = profileUserCache.get(userUUID)

        if (userAuth == null) {
            callback.onFailure("User not found")
        } else {
            callback.onSuccess(userAuth)
        }

        callback.onComplete()
    }

    override fun fetchUserPhoto(userUUID: String, callback: RequestCallback<Photo?>) {
        val photo = profilePhotoCache.get(userUUID)

        callback.onSuccess(photo)

        callback.onComplete()
    }

    override fun fetchUserPost(userUUID: String, callback: RequestCallback<List<Post>>) {
        val posts = profilePostCache.get(userUUID)

        if (posts == null) {
            callback.onFailure("List not found")
        } else {
            callback.onSuccess(posts)
        }

        callback.onComplete()
    }

    override fun fetchSession(): UserAuth {
        return Database.sessionAuth ?: throw RuntimeException("User not found")
    }

    override fun putUser(response: UserAuth) {
        profileUserCache.put(response)
    }

    override fun putPhoto(response: Photo?) {
        if (response != null) profilePhotoCache.put(response)
        else {
            profilePhotoCache.put(Photo.EMPTY)
        }
    }

    override fun putPosts(response: List<Post>) {
        profilePostCache.put(response)
    }

}